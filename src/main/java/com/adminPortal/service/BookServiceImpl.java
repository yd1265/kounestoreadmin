package com.adminPortal.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.adminPortal.domain.Book;
import com.adminPortal.repository.BookRepository;

@Service
public class BookServiceImpl implements BookService{
	
	@Autowired
	private BookRepository bookRepository;
	
	@Override
	public Book save(Book book) {
	
	return bookRepository.save(book);
	
}
	
	@Override
	public List <Book> findAll(){
	return (List<Book>) bookRepository.findAll();
	
	}
	@Override
	public void deleteBook(Long id) {
   bookRepository.deleteById(id);		
	}
	
	@Override
	public Book findOne(Long id) {
		return bookRepository.findById(id).get();
	}

	

}