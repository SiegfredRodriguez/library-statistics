package com.codegallery.librarystatistics.domain.model;

import lombok.Data;

@Data
public class Book {
    private String isbn;
    private String title;
    private String category;
}
