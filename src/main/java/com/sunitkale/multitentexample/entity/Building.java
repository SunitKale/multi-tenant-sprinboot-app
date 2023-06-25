package com.sunitkale.multitentexample.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "building")
public class Building {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String address;
    private String city;
    private String state;
    private String country;
    private String zipcode;
}
