package com.nit.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nit.entity.Book;
import com.nit.repository.BookRepository;

@Service
public class BookServiceImpl implements BookService {

	@Autowired
	private  BookRepository repository;
	
//constructor injection
	
	public BookServiceImpl(BookRepository repository) {
		
		this.repository=repository;
	}
	
	
	@Override
	public String upsertBook(Book book) {
		Book saveBook =  repository.save(book);
		return "Insert Successfully";
	}
	
	@Override
	public List<Book> getAllBook() {
		
		return repository.findAll();
	}
	
	@Override
	public String deleteBook(Integer bookId) {
		
		repository.deleteById(bookId);
		return "Book deleted";
	}
	
}
