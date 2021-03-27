package com.codegallery.librarystatistics.controller;

import com.codegallery.librarystatistics.domain.model.BorrowerStats;
import com.codegallery.librarystatistics.domain.service.LibraryStatisticService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
public class LibraryStatController {

    private LibraryStatisticService libraryStatisticService;

    @Autowired
    public LibraryStatController(LibraryStatisticService libraryStatisticService) {
        this.libraryStatisticService = libraryStatisticService;
    }

    @GetMapping("/stats/{borrowerId}")
    public BorrowerStats getBooks(@PathVariable String borrowerId) {
        return libraryStatisticService.getBorrowerStats(UUID.fromString(borrowerId));
    }
}
