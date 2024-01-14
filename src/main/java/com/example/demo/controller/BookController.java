package com.example.demo.controller;

import com.example.demo.dto.response.BookResponse;
import com.example.demo.exception.BookNotFoundException;
import com.example.demo.entity.BookEntity;
import com.example.demo.mapper.BookMapper;
import com.example.demo.repository.BookRepository;
import com.google.gson.Gson;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
public class BookController {
    @Autowired
    BookRepository bookRepository;

    @Autowired
    private BookMapper bookMapper;

    @GetMapping("/books")
    public List<BookEntity> getAllNotes() {
        return bookRepository.findAll();
    }
    @PostMapping("/books")
    public BookEntity createNote(@Valid @RequestBody BookEntity bookEntity){
        return bookRepository.save(bookEntity);
    }
    // Get a Single Note
    @GetMapping("/books/{id}")
    public BookEntity getNoteById(@PathVariable(value = "id") Long bookId) throws BookNotFoundException {
        return bookRepository.findById(bookId)
                .orElseThrow(() -> new BookNotFoundException(bookId));
    }
    // Update a Note
    @PutMapping("/books/{id}")
    public BookEntity updateNote(@PathVariable(value = "id") Long bookId,
                                 @Valid @RequestBody BookEntity bookEntityDetails) throws BookNotFoundException {

        BookEntity bookEntity = bookRepository.findById(bookId)
                .orElseThrow(() -> new BookNotFoundException(bookId));

        bookEntity.setBookName(bookEntityDetails.getBookName());
        bookEntity.setAuthorName(bookEntityDetails.getAuthorName());
        bookEntity.setIsbn(bookEntityDetails.getIsbn());

        BookEntity updatedBookEntity = bookRepository.save(bookEntity);

        return updatedBookEntity;
    }

    // Delete a Note
    @DeleteMapping("/books/{id}")
    public ResponseEntity<?> deleteBook(@PathVariable(value = "id") Long bookId) throws BookNotFoundException {
        BookEntity bookEntity = bookRepository.findById(bookId)
                .orElseThrow(() -> new BookNotFoundException(bookId));

        bookRepository.delete(bookEntity);


        return ResponseEntity.ok().build();
    }

    @GetMapping("/book-name/{bookName}")
    public String findBookName(@PathVariable String bookName){
        List<BookEntity> phucTap = bookRepository.findPhucTap(bookName);
        List<BookResponse> bookResponses = bookMapper.map(phucTap);
        Gson gson = new Gson().newBuilder().create();

        return gson.toJson(bookResponses);

    }
}
