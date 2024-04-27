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
@AllArgsConstructor
@NoArgsConstructor
public class BooksServiceImpl implements BooksService {

    @Autowired
    private BooksRepository booksRepository;

    @Override
    public List<Books> getBooks() {

        return (List<Books>) booksRepository.findAll();
    }

    @Override
    public Books
    saveBooks(Books books) {

        return booksRepository.save(books);
    }
}
