package com.library.backend.library.backend.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity(name = "country")
public class Country {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "continent")
    private String continent;
}
