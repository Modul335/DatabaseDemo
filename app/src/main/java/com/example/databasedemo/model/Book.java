package com.example.databasedemo.model;


import com.orm.SugarRecord;

public class Book extends SugarRecord {
    String title;
    String autor;
    String verlag;
    String isbn;

    public Book(){
    }

    public Book(String title, String autor, String verlag, String isbn){
        this.title = title;
        this.autor = autor;
        this.verlag = verlag;
        this.isbn = isbn;
    }
}

