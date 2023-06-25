package com.sunitkale.multitentexample;

import com.sunitkale.multitentexample.service.TenantSchemaService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class TenantSchemaServiceTest {

    @Autowired
    private TenantSchemaService tenantSchemaService;

    @Test
    public void createSchemaAndTables() {
        tenantSchemaService.createSchemaAndTables();
    }
}
