package com.library.backend.library.backend.model.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class BookDto {

    @JsonProperty("name")
    private String name;

    @JsonProperty("availableCopies")
    private Integer availableCopies;

    @JsonProperty("author")
    private Long author;

    @JsonProperty("category")
    private String category;

}
