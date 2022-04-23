package com.library.backend.library.backend.model;

import com.library.backend.library.backend.model.enums.CategoryType;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity(name = "book")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Enumerated(EnumType.STRING)
    @Column(name = "category")
    private CategoryType category;

    @ManyToOne
    private Author author;

    @Column(name = "available_copies")
    private Integer availableCopies;
}
