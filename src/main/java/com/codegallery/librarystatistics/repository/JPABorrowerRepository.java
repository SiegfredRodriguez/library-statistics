package com.codegallery.librarystatistics.repository;

import com.codegallery.librarystatistics.domain.model.Book;
import com.codegallery.librarystatistics.domain.model.Borrower;
import com.codegallery.librarystatistics.domain.repository.BorrowerRepository;
import com.codegallery.librarystatistics.repository.entity.BookEntity;
import com.codegallery.librarystatistics.repository.entity.BorrowerEntity;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Repository
public class JPABorrowerRepository extends SimpleJpaRepository<BorrowerEntity, UUID> implements BorrowerRepository {

    public JPABorrowerRepository(EntityManager em) {
        super(BorrowerEntity.class, em);
    }

    private static Borrower toDomainModel(BorrowerEntity entity) {
        Borrower model = new Borrower();

        model.setId(entity.getId());
        model.setName(entity.getName());

        List<Book> bookListModel = entity.getBookEntities()
                .stream()
                .map(JPABorrowerRepository::toDomainModel)
                .collect(Collectors.toList());

        model.setBorrowedBooks(bookListModel);

        return model;
    }

    private static Book toDomainModel(BookEntity bookEntity) {
        Book model = new Book();

        model.setIsbn(bookEntity.getIsbn());
        model.setTitle(bookEntity.getTitle());
        model.setCategory(bookEntity.getCategory());

        return model;
    }

    @Override
    public Optional<Borrower> findBorrowerById(UUID id) {
        Borrower e = super.findById(id)
                .map(JPABorrowerRepository::toDomainModel)
                .orElse(null);

        return Optional.ofNullable(e);
    }
}
