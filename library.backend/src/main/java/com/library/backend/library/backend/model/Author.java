package com.library.backend.library.backend.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity(name = "author")
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "surname")
    private String surname;

    @ManyToOne
    private Country country;
}
