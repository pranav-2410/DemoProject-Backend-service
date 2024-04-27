package com.example.demo.service.impl;

import com.example.demo.model.Books;
import com.example.demo.repository.BooksRepository;
import com.example.demo.service.BooksService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

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

        try {
            return booksRepository.save(books);
        }
        catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }
}
