package com.example.rest_api_app.dao;

import org.springframework.data.repository.CrudRepository;

import com.example.rest_api_app.model.Book;

public interface BookRepository extends CrudRepository<Book,Integer>{
    public Book findById(int id);
}
