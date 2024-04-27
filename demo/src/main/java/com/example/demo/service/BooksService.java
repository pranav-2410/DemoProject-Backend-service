package com.example.demo.service;

import com.example.demo.model.Books;

import java.util.List;

public interface BooksService {

    List<Books> getBooks();

    Books saveBooks(Books books);
}
