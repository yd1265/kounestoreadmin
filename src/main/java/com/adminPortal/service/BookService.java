package com.adminPortal.service;

import java.util.List;

import com.adminPortal.model.Book;

public interface BookService {
public List<Book> findAllBooks();
public Book addBook(Book book);

public void deleteBook(Long id);
public Book findOne(Long id);


}
