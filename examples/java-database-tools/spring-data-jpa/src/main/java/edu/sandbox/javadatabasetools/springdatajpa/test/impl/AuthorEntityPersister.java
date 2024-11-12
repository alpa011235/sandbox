package edu.sandbox.javadatabasetools.springdatajpa.test.impl;

import edu.sandbox.javadatabasetools.springdatajpa.model.Author;
import edu.sandbox.javadatabasetools.springdatajpa.model.Book;
import edu.sandbox.javadatabasetools.springdatajpa.repository.AuthorRepository;
import edu.sandbox.javadatabasetools.springdatajpa.test.impl.base.BaseEntityWithRelationshipPersister;
import edu.sandbox.javadatabasetools.springdatajpa.test.order.DefaultOrder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Slf4j
@Getter
@Service
@RequiredArgsConstructor
public class AuthorEntityPersister extends BaseEntityWithRelationshipPersister<Book, Author> {

    private final AuthorRepository repository;

    @Override
    public void persist(Book entity) {
        super.persist(entity);
        log.info(">>>> 1. I'm AuthorEntityPersister");
    }

    @Override
    public Optional<Author> getChildRelationship(Book book) {
        return Optional.of(book)
                .map(Book::getAuthor);
    }

    @Override
    public Class<?> executeAfter() {
        return DefaultOrder.class;
    }
}
