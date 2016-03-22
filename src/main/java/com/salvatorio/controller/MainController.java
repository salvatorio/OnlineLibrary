package com.salvatorio.controller;

import com.salvatorio.model.Book;
import com.salvatorio.service.BookService;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;



import javax.servlet.http.HttpServletResponse;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Map;

@Controller
public class MainController {
    @Autowired
    private BookService bookService;

    @RequestMapping(value = {"/", "/index"})
    public String listBooks(Map<String, Object> map) {
        map.put("book", new Book());
        map.put("bookList", bookService.listBooks());
        return "index";
    }

    @RequestMapping("/downloadBook/{bookId}")
    public String downloadBook(@PathVariable("bookId") long id, HttpServletResponse response) {
        Book book = bookService.getBook(id);
        try {
            response.setHeader("Content-Disposition", "inline;filename=\"" + book.getFileName()+ "\"");
            OutputStream out = response.getOutputStream();
            response.setContentType(book.getContentType());
            IOUtils.copy(new ByteArrayInputStream(book.getBookData()), out);
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return "redirect:index";
    }
}
