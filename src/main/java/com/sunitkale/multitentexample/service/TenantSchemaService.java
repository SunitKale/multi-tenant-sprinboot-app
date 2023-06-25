package com.sunitkale.multitentexample.service;

import com.sunitkale.multitentexample.repository.TenantSchemaRepository;
import liquibase.Liquibase;
import liquibase.database.Database;
import liquibase.database.DatabaseFactory;
import liquibase.database.jvm.JdbcConnection;
import liquibase.resource.ClassLoaderResourceAccessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.sql.Connection;

@Service
public class TenantSchemaService {

    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Autowired
    private TenantSchemaRepository tenantSchemaRepository;

    public void createSchemaAndTables() {
        tenantSchemaRepository.findAll().forEach(tenantGroup -> {
            try {
                // Create the new schema
                String sql = "CREATE SCHEMA IF NOT EXISTS " + tenantGroup.getSchemaName();
                jdbcTemplate.execute(sql);
                createLiquibase(tenantGroup.getSchemaName().toLowerCase());
            }
            catch (Exception e) {
                System.out.println(e);
            }
        });
    }
    
    private void createLiquibase(String schemaName) {
        try(Connection connection = jdbcTemplate.getDataSource().getConnection();
            Database database = DatabaseFactory.getInstance().findCorrectDatabaseImplementation(new JdbcConnection(connection));
        ) {
            database.setDefaultSchemaName(schemaName); // Set the default schema
            new Liquibase("db/tenantgroup/master.yaml", new ClassLoaderResourceAccessor(), database).update("");
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
