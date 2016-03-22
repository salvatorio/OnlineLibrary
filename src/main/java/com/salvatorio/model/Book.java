package com.salvatorio.model;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "book")
public class Book {

    private long id;
    private String name;
    private String code;
    private String authors;
    private String isbn;
    private String publisher;
    private Date publishedOn;
    private String fileName;
    private byte[] bookData;
    private String contentType;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public long getId() {
        return id;
    }

    @Column
    public String getName() {
        return name;
    }

    @Column
    public String getCode() {
        return code;
    }

    @Column
    public String getAuthors() {
        return authors;
    }

    @Column
    public String getIsbn() {
        return isbn;
    }

    @Column
    public String getPublisher() {
        return publisher;
    }

    @Column(name = "publishedDate")
    public Date getPublishedOn() {
        return publishedOn;
    }

    @Column
    public String getFileName() {
        return fileName;
    }

    @Column
    public byte[] getBookData() {
        return bookData;
    }

    @Column
    public String getContentType() {
        return contentType;
    }


    public void setId(long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public void setBookData(byte[] bookData) {
        this.bookData = bookData;
    }

    public void setContentType(String contentType) {
        this.contentType = contentType;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public void setAuthors(String authors) {
        this.authors = authors;
    }

    public void setPublishedOn(Date publishedOn) {
        this.publishedOn = publishedOn;
    }

}
