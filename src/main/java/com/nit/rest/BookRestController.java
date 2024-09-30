package com.nit.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.nit.entity.Book;
import com.nit.service.BookService;

@RestController
public class BookRestController {

	
	@Autowired
	private BookService service;
	
	//fetch book details
	@PostMapping("/book")
	public ResponseEntity<String> addBook(@RequestBody Book book){
		
		String msg = service.upsertBook(book);
		
		return new ResponseEntity<>(msg,HttpStatus.CREATED);
	}
	
	//get all book
	@GetMapping("/get")
	public ResponseEntity<List<Book>> getAllBooks(){
		List<Book> allBooks  = service.getAllBook();
		
		return new ResponseEntity<>(allBooks, HttpStatus.OK);
	}
	
	//update data
	@PutMapping("/update")
	public ResponseEntity<String> updateBook(@RequestBody Book book){
		
		String msg = service.upsertBook(book);
		return new ResponseEntity<>(msg,HttpStatus.OK);
	}
	
	//delete data
	@DeleteMapping("/delete/{bookId}")
	public ResponseEntity<String> deleteBookData(@PathVariable Integer bookId){
		
		String msg = service.deleteBook(bookId);
		
		return new ResponseEntity<>(msg , HttpStatus.OK);
	}
}
