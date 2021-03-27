package com.codegallery.librarystatistics.repository.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;
import java.util.UUID;

@Data
@Entity
@Table(schema = "library", name = "borrower")
public class BorrowerEntity {

    @Id
    private UUID id;

    @Column
    private String name;

    @OneToMany
    @JoinTable(
            schema = "library",
            name = "ledger",
            joinColumns = @JoinColumn(name = "borrower_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "book_isbn", referencedColumnName = "isbn")
    )
    private List<BookEntity> bookEntities;
}
