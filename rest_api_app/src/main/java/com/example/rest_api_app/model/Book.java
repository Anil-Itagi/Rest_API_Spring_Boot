package com.example.rest_api_app.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="books")

public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String title;

    @OneToOne(cascade=CascadeType.ALL)
    private Author author;

    
    public Book(int id, String title, Author author) {
        this.id = id;
        this.title = title;
        this.author = author;
    }

    public Book(){
        super();
    }
    
 

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    @Override
    public String toString() {
        return "Boot [id=" + id + ", title=" + title + ", author=" + author + "]";
    }

    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public Author getAuthor() {
        return author;
    }
    public void setAuthor(Author author) {
        this.author = author;
    }
    
}
