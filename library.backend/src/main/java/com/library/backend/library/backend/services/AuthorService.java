package com.library.backend.library.backend.services;

import com.library.backend.library.backend.model.Author;
import com.library.backend.library.backend.model.Country;
import com.library.backend.library.backend.model.dtos.AuthorDto;
import com.library.backend.library.backend.repository.AuthorRepository;
import com.library.backend.library.backend.repository.CountryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthorService {

    private final AuthorRepository authorRepository;
    private final CountryRepository countryRepository;

    public Author addNewAuthor(AuthorDto authorDto) {
        Author author = new Author();
        Country country = countryRepository.findById(authorDto.getCountry())
                .orElseGet(null);
        author.setCountry(country);
        author.setName(authorDto.getName());
        author.setSurname(authorDto.getSurname());
        return authorRepository.save(author);
    }
}
