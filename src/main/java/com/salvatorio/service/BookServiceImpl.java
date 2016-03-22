package com.salvatorio.service;


import com.salvatorio.dao.BookDAO;
import com.salvatorio.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
@Transactional
public class BookServiceImpl implements BookService {
    @Autowired
    private BookDAO bookDAO;

    @Override
    public void saveBook(Book book) {
         bookDAO.saveBook(book);
    }

    @Override
    public Book updateBook(Book book) {
        return bookDAO.updateBook(book);
    }

    @Override
    public void deleteBook(long id) {
        bookDAO.deleteBook(id);
    }

    @Override
    public List<Book> listBooks() {
        return bookDAO.listBooks();
    }

    @Override
    public Book getBook(long id) {
        return bookDAO.getBook(id);
    }
}
