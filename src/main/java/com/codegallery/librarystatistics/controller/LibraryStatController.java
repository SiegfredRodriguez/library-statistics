package com.codegallery.librarystatistics.controller;

import com.codegallery.librarystatistics.domain.model.BorrowerStats;
import com.codegallery.librarystatistics.domain.repository.BorrowerRepository;
import com.codegallery.librarystatistics.domain.service.LibraryStatisticService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
public class LibraryStatController {

    private BorrowerRepository borrowerRepository;
    private LibraryStatisticService libraryStatisticService;

    public LibraryStatController(LibraryStatisticService libraryStatisticService) {
        this.libraryStatisticService = libraryStatisticService;
    }

    @GetMapping("/stats")
    public BorrowerStats getBooks() {
        return libraryStatisticService.getBorrowerStats(UUID.fromString("3b8e929e-ad56-431f-9d3f-1ea6252cd5fc"));
    }
}
