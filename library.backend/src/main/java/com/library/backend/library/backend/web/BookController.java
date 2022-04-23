package com.library.backend.library.backend.web;

import com.library.backend.library.backend.model.Book;
import com.library.backend.library.backend.model.dtos.BookDto;
import com.library.backend.library.backend.services.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/books")
@RequiredArgsConstructor
public class BookController {

    private final BookService bookService;

    @GetMapping
    public List<Book> findAll() {
        return bookService.findAll();
    }

    @PostMapping("/add")
    public Book addNewBook(@RequestBody BookDto bookDto){
        return bookService.addNewBook(bookDto);
    }

    @PatchMapping("/update")
    public Book updateBook(@RequestBody Book oldBook){
        return bookService.updateBook(oldBook);
    }

    @GetMapping("/{id}")
    public Book findById(@PathVariable("id") Long id) {
        return bookService.findById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteBook(@PathVariable("id") Long id) {
        bookService.deleteBook(id);
    }

    @PostMapping("/rent")
    public void rentBook(@RequestParam Long bookId) {
        bookService.rentBook(bookId);
    }

}
