package edu.sandbox.javadatabasetools.springdatajpa.test.impl;

import edu.sandbox.javadatabasetools.springdatajpa.model.Book;
import edu.sandbox.javadatabasetools.springdatajpa.repository.BookRepository;
import edu.sandbox.javadatabasetools.springdatajpa.test.impl.base.BaseEntityRootPersister;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Getter
@Service
@RequiredArgsConstructor
public class BookEntityPersister extends BaseEntityRootPersister<Book> {

    private final BookRepository repository;

    @Override
    public Class<?> executeAfter() {
        return AuthorEntityPersister.class;
    }
}
