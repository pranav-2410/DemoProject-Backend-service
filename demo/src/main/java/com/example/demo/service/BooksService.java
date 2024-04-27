package com.example.demo.service;

import com.example.demo.model.Books;

import java.util.List;

public interface BooksService {

    List<Books> getBooks() throws Exception;

    Books saveBooks(Books books) throws Exception;

    void deleteBook(int id);

    Books updateBookById(int id, Books bookChanges);
}
