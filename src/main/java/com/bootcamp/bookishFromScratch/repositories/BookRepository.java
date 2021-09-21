package com.bootcamp.bookishFromScratch.repositories;

import com.bootcamp.bookishFromScratch.models.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book, Integer> {

}
