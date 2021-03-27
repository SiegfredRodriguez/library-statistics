package com.codegallery.librarystatistics.domain.model;

import lombok.Data;

import java.util.Map;
import java.util.UUID;

@Data
public class BorrowerStats {
    private UUID borrowerId;
    private Map<String, Integer> categoryStat;
    private Map<String, Integer> titleStats;
}
