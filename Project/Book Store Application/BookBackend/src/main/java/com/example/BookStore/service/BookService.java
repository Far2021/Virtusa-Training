package com.example.BookStore.service;


import java.util.List;


import com.example.BookStore.model.Book;
public interface BookService {
	public Book saveBook(Book book);
	public List<Book> getAllBooks();
}
