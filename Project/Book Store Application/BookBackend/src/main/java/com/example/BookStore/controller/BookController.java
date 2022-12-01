package com.example.BookStore.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.BookStore.model.Book;
import com.example.BookStore.service.BookService;

@RestController
@RequestMapping("/book")
@CrossOrigin
public class BookController {
	@Autowired
    private BookService bookService;

    @PostMapping("/add")
    public String add(@RequestBody Book book){
        bookService.saveBook(book);
        return "New Book is added";
    }

    @GetMapping("/getAll")
    public List<Book> list(){
        return bookService.getAllBooks();
    }
}
