package com.adminPortal.repository;

import org.springframework.data.repository.CrudRepository;

import com.adminPortal.domain.Book;

public interface BookRepository extends CrudRepository<Book, Long>{

}
