package com.codegallery.librarystatistics.domain.service;

import com.codegallery.librarystatistics.domain.model.Book;
import com.codegallery.librarystatistics.domain.model.Borrower;
import com.codegallery.librarystatistics.domain.model.BorrowerStats;
import com.codegallery.librarystatistics.domain.repository.BorrowerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.UUID;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
public class LibraryStatisticService {

    private BorrowerRepository borrowerRepository;

    @Autowired
    public LibraryStatisticService(BorrowerRepository borrowerRepository) {
        this.borrowerRepository = borrowerRepository;
    }

    public BorrowerStats getBorrowerStats(UUID borrowerId) {
        Borrower borrower = borrowerRepository.findBorrowerById(borrowerId)
                .orElseThrow();

        BorrowerStats stats = new BorrowerStats();

        stats.setCategoryStat(getCategoryStatistics(borrower.getBorrowedBooks()));
        stats.setTitleStats(getTitleStatistics(borrower.getBorrowedBooks()));
        stats.setBorrowerId(borrower.getId());

        return stats;
    }

    protected Map<String, Integer> getCategoryStatistics(List<Book> books) {
        return reduceToMap(books, Book::getCategory);
    }

    protected Map<String, Integer> getTitleStatistics(List<Book> books) {
        return reduceToMap(books, Book::getTitle);
    }

    protected Map<String, Integer> reduceToMap(List<Book> books, Function<Book,String> reducer) {
        return books.stream()
                .collect(Collectors.toMap(
                        reducer,
                        e -> 1,
                        Math::addExact,
                        TreeMap::new
                ));
    }

}
