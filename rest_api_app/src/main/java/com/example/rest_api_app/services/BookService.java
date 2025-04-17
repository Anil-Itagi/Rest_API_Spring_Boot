package com.example.rest_api_app.services;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.rest_api_app.dao.BookRepository;
import com.example.rest_api_app.model.Book;


@Component
public class BookService {

    @Autowired
    private BookRepository bookRepository;
    
// get all books
public List<Book> getAllBooks() {
    List<Book> list=(List<Book>)this.bookRepository.findAll();
    return list;

}

// get a single book
public Book getBookById(int id) {

    Book b = null;
    try {
        b = this.bookRepository.findById(id);
        return b; 
        
    } catch (Exception e) {
        e.printStackTrace();
        return b;
    }
}
    
public Book addBook(Book book) {
    Book b=this.bookRepository.save(book);  
    return b;
}

public void deleteBook(int id) {
    bookRepository.deleteById(id);
}

public Book updateBook(Book book, int id) {
    book.setId(id);
    bookRepository.save(book);
    return book;
}



}
