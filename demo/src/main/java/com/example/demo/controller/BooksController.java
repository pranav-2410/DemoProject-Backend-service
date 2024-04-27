package com.example.demo.controller;

import com.example.demo.model.Books;
import com.example.demo.service.BooksService;
import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api")
public class BooksController {

    @Autowired
    private BooksService booksService;

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

    @DeleteMapping("/removeBook/{id}")
    public ResponseEntity<String> removeBook(@PathVariable int id){
        try{
            booksService.deleteBook(id);
            System.out.println("Successfully deleted!");
            return new ResponseEntity<String>("Deleted successfully with id: "+id, HttpStatus.OK );
        }
        catch (Exception e){
            throw new RuntimeException();
        }
    }

    @PutMapping("/updateBook/{id}")
    public ResponseEntity<Books> updateBook(@PathVariable int id,
                                            @RequestBody Books bookChanges){

        try{
            Books updated = booksService.updateBookById(id, bookChanges);
            System.out.println("Book updated successfully!");
            return new ResponseEntity<Books>(updated,HttpStatus.OK);
        }
        catch (Exception e){
            throw new RuntimeException();
        }

    }
}
