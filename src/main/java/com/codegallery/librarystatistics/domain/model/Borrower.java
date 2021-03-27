package com.codegallery.librarystatistics.domain.model;

import lombok.Data;

import java.util.List;
import java.util.UUID;

@Data
public class Borrower {
    private UUID id;
    private String name;
    private List<Book> borrowedBooks;
}
