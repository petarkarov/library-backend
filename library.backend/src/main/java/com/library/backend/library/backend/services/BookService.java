package com.library.backend.library.backend.services;

import com.library.backend.library.backend.model.Author;
import com.library.backend.library.backend.model.Book;
import com.library.backend.library.backend.model.dtos.BookDto;
import com.library.backend.library.backend.model.enums.CategoryType;
import com.library.backend.library.backend.repository.AuthorRepository;
import com.library.backend.library.backend.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BookService {

    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;

    public List<Book> findAll() {
        return bookRepository.findAll();
    }

    public Book addNewBook(BookDto bookDto) {
        Book book = new Book();
        book.setName(bookDto.getName());
        book.setAvailableCopies(bookDto.getAvailableCopies());
        Author author = authorRepository.findById(bookDto.getAuthor())
                .orElse(null);
        book.setAuthor(author);
        book.setCategory(CategoryType.valueOf(bookDto.getCategory()));
        return bookRepository.save(book);
    }

    public Book updateBook(Book oldBook) {
        Book book = this.findById(oldBook.getId());
        book.setAuthor(oldBook.getAuthor());
        book.setAvailableCopies(oldBook.getAvailableCopies());
        book.setCategory(oldBook.getCategory());
        book.setName(oldBook.getName());
        return bookRepository.save(book);
    }

    public Book findById(Long id) {
        return bookRepository.findById(id)
                .orElseGet(null);
    }

    public void deleteBook(Long id) {
        bookRepository.deleteById(id);
    }

    public void rentBook(Long bookId) {
        Book book = this.findById(bookId);
        book.setAvailableCopies(book.getAvailableCopies() - 1);
        bookRepository.save(book);
    }
}
