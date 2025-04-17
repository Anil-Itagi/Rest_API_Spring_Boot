package com.example.rest_api_app.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Author {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int authorId;
    private String firstName;
    private String lastName;
    private String langauge;
    public int getAuthorId() {
        return authorId;
    }
    public void setAuthorId(int authorId) {
        this.authorId = authorId;
    }
    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public String getLangauge() {
        return langauge;
    }
    public void setLangauge(String langauge) {
        this.langauge = langauge;
    }
    public Author(int authorId, String firstName, String lastName, String langauge) {
        this.authorId = authorId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.langauge = langauge;
    }

    public Author() {
        super();
    }
    
}
