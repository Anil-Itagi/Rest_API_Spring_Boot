package com.example.rest_api_app.services;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.example.rest_api_app.model.Book;


@Component
public class BookService {

    private static List<Book> list = new ArrayList<>();
    static {

        list.add(new Book(12, "Python course", "Sunil"));
        list.add(new Book(13, "HTML", "Ramesh"));
        list.add(new Book(14, "CSS", "Arun"));
        list.add(new Book(15, "Javascript", "akash"));
        System.out.println("All variables are initializedd");

    }
    
// get all books
public List<Book> getAllBooks() {
    return list;

}

// get a single book
public Book getBookById(int id) {

    Book book = null;
    book = list.stream().filter(e -> e.getId() == id).findFirst().get();
    return book;
}
    
public Book addBook(Book book) {
    list.add(book);
    System.out.println("book added successfully");
    System.out.println(list);
    return book;
}

public void deleteBook(int id) {
    list=list.stream().filter(b->{
        if(b.getId()!=id)
            return true;
        else
            return false;
    }).collect(Collectors.toList());
}

public Book updateBook(Book book ,int id) {
    list = list.stream().map(b -> {
        if (b.getId() == id)
            b.setTitle(book.getTitle());
            b.setAuthor(book.getAuthor());
            return b;
    }).collect(Collectors.toList());
         
    return book;
}



}
