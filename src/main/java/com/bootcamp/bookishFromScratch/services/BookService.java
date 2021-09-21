package com.bootcamp.bookishFromScratch.services;

import com.bootcamp.bookishFromScratch.models.Book;
import com.bootcamp.bookishFromScratch.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class BookService {
    private final BookRepository bookRepository;

    @Autowired
    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public List<Book> getAllBooksOrderedByTitle() {
        Iterable<Book> books = bookRepository.findAll();
        // use streams to sort the iterable of books by title
        return StreamSupport.stream(books.spliterator(), false)
            .sorted(Comparator.comparing(Book::getTitle))
            .collect(Collectors.toList());
    }

    public Optional<Book> findBookById(Integer id) {
        return bookRepository.findById(id);
    }

    public Book updateOrCreateBook(Book book) {
        return bookRepository.save(book);
    }

    public void deleteBookById(Integer id) {
        bookRepository.deleteById(id);
    }
}
