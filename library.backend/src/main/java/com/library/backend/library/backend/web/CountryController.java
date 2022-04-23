package com.library.backend.library.backend.web;

import com.library.backend.library.backend.model.Author;
import com.library.backend.library.backend.model.Country;
import com.library.backend.library.backend.repository.CountryRepository;
import com.library.backend.library.backend.services.CountryService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/country")
@RequiredArgsConstructor
public class CountryController {

    private final CountryService countryService;

    @PostMapping("/add")
    public Country addNewCountry(@RequestBody Country country){
        return  countryService.addNewCountry(country);
    }

    @GetMapping
    public List<Country> getAll() {
        return countryService.findAll();
    }
}
