package edu.sandbox.javadatabasetools.springdatajpa.test.impl;

import edu.sandbox.javadatabasetools.springdatajpa.model.Book;
import edu.sandbox.javadatabasetools.springdatajpa.model.Genre;
import edu.sandbox.javadatabasetools.springdatajpa.repository.GenreRepository;
import edu.sandbox.javadatabasetools.springdatajpa.test.impl.base.BaseEntityWithCollectionRelationshipPersister;
import edu.sandbox.javadatabasetools.springdatajpa.test.order.DefaultOrder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Getter
@Service
@RequiredArgsConstructor
public class GenreEntityPersister extends BaseEntityWithCollectionRelationshipPersister<Book, Genre> {

    private final GenreRepository repository;

    @Override
    public void persist(Book entity) {
        super.persist(entity);
        log.info(">>>> 1. I'm GenreEntityPersister");
    }

    @Override
    public List<Genre> getChildRelationship(Book book) {
        return book.getGenres();
    }

    @Override
    public Class<?> executeAfter() {
        return DefaultOrder.class;
    }
}
