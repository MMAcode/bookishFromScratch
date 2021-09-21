package com.bootcamp.bookishFromScratch.models;

import lombok.Getter;
import lombok.Setter;
import lombok.Value;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Getter
@Setter
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String Title;
    private String Author;
    private Integer AvailableCopies;
}
