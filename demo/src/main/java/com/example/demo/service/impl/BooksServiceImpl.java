package com.example.demo.service.impl;

import com.example.demo.model.Books;
import com.example.demo.repository.BooksRepository;
import com.example.demo.service.BooksService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;

@Service
public class BooksServiceImpl implements BooksService {
    @Autowired
    private BooksRepository booksRepository;

    @Override
    public List<Books> getBooks() throws Exception {
        try {
            return (List<Books>) booksRepository.findAll();
        }
        catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public Books
    saveBooks(Books books) throws Exception {

        return booksRepository.save(books);
    }

    @Override
    public void deleteBook(int id) {

        booksRepository.deleteById(id);
    }

    @Override
    public Books updateBookById(int id, Books bookChanges) {

        Books saved=null;
        if (booksRepository.findById(id).isPresent()) {
            Books presentBook = booksRepository.findById(id).get();
            presentBook.setBookName(bookChanges.getBookName());
            presentBook.setPrice(bookChanges.getPrice());
            saved = booksRepository.save(presentBook);
        }
        return saved;
    }
}
