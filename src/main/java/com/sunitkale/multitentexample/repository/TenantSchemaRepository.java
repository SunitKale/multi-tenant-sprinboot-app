package com.sunitkale.multitentexample.repository;

import com.sunitkale.multitentexample.entity.TenantGroup;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TenantSchemaRepository extends JpaRepository<TenantGroup, Long> {
}
