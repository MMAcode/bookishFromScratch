package com.bootcamp.bookishFromScratch.controlers;

import com.bootcamp.bookishFromScratch.models.Book;
import com.bootcamp.bookishFromScratch.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.view.RedirectView;

import java.util.Optional;

@Controller
public class BookController {
    private final BookService bookService;

    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("")
    public ModelAndView getAllBooks() {
        Iterable<Book> books = bookService.getAllBooksOrderedByTitle();
        return new ModelAndView("books/index", "books", books);
        // return new ModelAndView("indexMiro", "books", books);
        // return new ModelAndView("indexMiro");
    }

    @GetMapping("/book/{id}")
    public ModelAndView editBook(@PathVariable Integer id) {
        Optional<Book> book = bookService.findBookById(id);
        return new ModelAndView("books/edit", "book", book.get());
    }

    @GetMapping("/book")
    public ModelAndView addBook() {
        return new ModelAndView("books/new", "book", new Book());
    }

    @PostMapping("/book/{id}")
    public RedirectView updateBook(@ModelAttribute Book book) {
        bookService.updateOrCreateBook(book);
        return new RedirectView("/");
    }

    @PostMapping("/book")
    public RedirectView createBook(@ModelAttribute Book book) {
        bookService.updateOrCreateBook(book);
        return new RedirectView("/");
    }

    @GetMapping("/book/delete/{id}")
    public RedirectView deleteBook(@PathVariable Integer id) {
        bookService.deleteBookById(id);
        return new RedirectView("/");
    }
}
