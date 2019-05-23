package com.adminPortal.service;

import java.util.List;

import com.adminPortal.domain.Book;

public interface BookService {
	public Book save(Book book);
    public List <Book> findAll();
	public void deleteBook(Long id);
	public Book findOne(Long id);
	
	
    


    
    
    
    
    
    
}
