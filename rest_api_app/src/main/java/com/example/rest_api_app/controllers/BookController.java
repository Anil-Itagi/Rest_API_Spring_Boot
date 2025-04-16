package com.example.rest_api_app.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.rest_api_app.model.Book;
import com.example.rest_api_app.services.BookService;



@RestController
public class BookController {


    @Autowired
    private BookService bookService;

    @GetMapping("/books")
    public ResponseEntity<?> getBooks() {
        List<Book> list = null;
        try {
            list = this.bookService.getAllBooks();
            if (list.size() > 0) {
                return ResponseEntity.ok(list);
            }
            else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Error happened");
            }
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Error happened");

        }

    }
    
    @GetMapping("/books/{id}")
    public ResponseEntity<?> getBook(@PathVariable("id") int id) {
        try {
            Book b = bookService.getBookById(id);
            return ResponseEntity.ok(b);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Error happned");
        }
    }

    @PostMapping("/books")
    public ResponseEntity<?> addBook(@RequestBody Book book) {
        Book b = null;
        try {
            b = this.bookService.addBook(book);
            return ResponseEntity.ok(b);
            
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Error in creating post");
        }
        
    }
    
    @DeleteMapping("/books/{id}")
    public ResponseEntity<?> deleteBook(@PathVariable("id") int id) {

        try {      
            this.bookService.deleteBook(id);
            return ResponseEntity.ok("Deletition completed successfully");

        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Error in deletion");
        }
    }

    @PutMapping("/books/{id}")
    public ResponseEntity<?> updateBook(@RequestBody Book book, @PathVariable("id") int id) {
        
        Book b = null;
        try {
            b = this.bookService.updateBook(book, id);
            return ResponseEntity.ok(b);          
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body("Error in updating the book");
        }
    }
}
