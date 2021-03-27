package com.codegallery.librarystatistics.domain.repository;

import com.codegallery.librarystatistics.domain.model.Borrower;

import java.util.Optional;
import java.util.UUID;

public interface BorrowerRepository {
    Optional<Borrower> findBorrowerById(UUID id);
}
