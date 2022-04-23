package com.library.backend.library.backend.web;

import com.library.backend.library.backend.model.enums.CategoryType;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/categories")
@RequiredArgsConstructor
public class CategoryController {

    @GetMapping
    public List<CategoryType> findAll() {
        return Arrays.asList(CategoryType.values());
    }
}
