package com.salvatorio.controller;

import com.salvatorio.model.Book;
import com.salvatorio.service.BookService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Controller
public class AlterController {

    @Autowired
    private BookService bookService;

    @RequestMapping("/createBook")
    public String createBook(@ModelAttribute Book book) {
        return "bookForm";
    }

    @RequestMapping("/editBook/{bookId}")
    public String editBook(@PathVariable("bookId") long id, @ModelAttribute Book book, Model model) {
        book = bookService.getBook(id);
        model.addAttribute("bookObject", book);
        return "bookForm";
    }

    @RequestMapping(value = "/saveBook", method = RequestMethod.POST)
    public String saveBook(@ModelAttribute Book book,
                           BindingResult bindingResult,
                           @RequestParam MultipartFile bookData) {

        book.setFileName(bookData.getOriginalFilename());
        book.setContentType(bookData.getContentType());
        try {
            book.setBookData(bookData.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }

        if(book.getId() == 0){ // if book id is 0 then creating the book other updating the book
            bookService.saveBook(book);
        } else {
            bookService.updateBook(book);
        }
        return "redirect:/adminPage";
    }

    @RequestMapping("/deleteBook/{bookId}")
    public String deleteBook(@PathVariable("bookId") long id) {
        bookService.deleteBook(id);
        return "redirect:/adminPage";
    }



}
