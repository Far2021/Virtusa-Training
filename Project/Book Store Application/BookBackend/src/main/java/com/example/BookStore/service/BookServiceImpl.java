package com.example.BookStore.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.BookStore.model.Book;
import com.example.BookStore.repository.BookRepository;

@Service
public class BookServiceImpl implements BookService {
	 @Autowired
	    private BookRepository bookRepository;
	
	@Override
	 	public Book saveBook(Book book) {
	        return bookRepository.save(book);
	    }

	@Override
	    public List<Book> getAllBooks() {
	        return bookRepository.findAll();
	    }
}
