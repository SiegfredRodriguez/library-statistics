package com.codegallery.librarystatistics.repository;

import com.codegallery.librarystatistics.repository.entity.BookEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<BookEntity, String> {
}