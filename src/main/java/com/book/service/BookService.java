package com.book.service;

import com.book.models.Book;

import java.util.List;

public interface BookService {
    Book saveBook(Book book);

    void deleteBookById(Long id);

    List<Book> findAllBooks();
}
