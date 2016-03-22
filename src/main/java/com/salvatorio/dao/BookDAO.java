package com.salvatorio.dao;

import com.salvatorio.model.Book;

import java.util.List;

public interface BookDAO {
    public void saveBook(Book book);
    public Book updateBook(Book book);
    public void deleteBook(long id);
    public List<Book> listBooks();
    public Book getBook(long id);
}
