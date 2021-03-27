package com.codegallery.librarystatistics.repository.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(schema = "library", name = "book")
public class BookEntity {

    @Id
    private String isbn;

    @Column
    private String title;

    @Column
    private String category;
}
