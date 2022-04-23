package com.library.backend.library.backend.web;

import com.library.backend.library.backend.model.Author;
import com.library.backend.library.backend.model.Book;
import com.library.backend.library.backend.model.dtos.AuthorDto;
import com.library.backend.library.backend.services.AuthorService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/author")
@RequiredArgsConstructor
public class AuthorController {

    private final AuthorService authorService;

    @PostMapping("/add")
    public Author addNewAuthor(@RequestBody AuthorDto authorDto){
        return authorService.addNewAuthor(authorDto);
    }
}
