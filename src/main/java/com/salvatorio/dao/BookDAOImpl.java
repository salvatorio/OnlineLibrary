package com.salvatorio.dao;

import com.salvatorio.model.Book;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class BookDAOImpl implements BookDAO {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void saveBook(Book book) {
        getSession().save(book);
    }

    @Override
    public Book updateBook(Book book) {
        getSession().update(book);
        return book;
    }

    @Override
    public void deleteBook(long id) {
        Book book = new Book();
        book.setId(id);
        book.setFileName("");
        getSession().delete(book);
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Book> listBooks() {
        return getSession().createCriteria(Book.class).list();
    }

    @Override
    public Book getBook(long id) {
        return (Book)getSession().get(Book.class, id);
    }

    private Session getSession() {
        Session session = getSessionFactory().getCurrentSession();
        if (session == null) {
            session = getSessionFactory().openSession();
        }
        return session;
    }

    private SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}
