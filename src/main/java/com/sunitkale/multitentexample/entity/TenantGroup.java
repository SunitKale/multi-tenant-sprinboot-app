package com.sunitkale.multitentexample.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "tenant-schema")
public class TenantGroup {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "tenant-name")
    private String tenantName;

    @Column(name = "schema_name")
    private String schemaName;
}
