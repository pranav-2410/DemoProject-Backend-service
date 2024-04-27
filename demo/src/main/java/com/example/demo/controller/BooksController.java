package com.example.demo.controller;

import com.example.demo.model.Books;
import com.example.demo.service.BooksService;
import lombok.extern.slf4j.Slf4j;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api")
public class BooksController {

    private final BooksService booksService;

    public BooksController(BooksService booksService) {
        this.booksService = booksService;
    }

    @GetMapping("/getBooks")
    public ResponseEntity<List<Books>> getBooks() throws Exception {
        List<Books> listOfBooks=null;
        try{
        listOfBooks = booksService.getBooks();
        System.out.println("The list of books available are:  ");
        for(Books book:listOfBooks){
            System.out.println(book.getBookId()+" "+ book.getPrice()+" "+ book.getBookName());
        }
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
        return ResponseEntity.ok(listOfBooks);
    }

    @PostMapping("/saveBook")
    public ResponseEntity<Books> saveBooks(@RequestBody Books books){

        try {
            Books newBook = booksService.saveBooks(books);
            return ResponseEntity.ok(newBook);
        }
        catch (Exception e){
            throw new RuntimeException();
        }

    }
}
