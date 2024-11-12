package edu.sandbox.javadatabasetools.springdatajpa.test.impl;

import edu.sandbox.javadatabasetools.springdatajpa.model.Book;
import edu.sandbox.javadatabasetools.springdatajpa.repository.BookRepository;
import edu.sandbox.javadatabasetools.springdatajpa.test.impl.base.BaseEntityPersister;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Getter
@Service
@RequiredArgsConstructor
public class BookEntityPersister extends BaseEntityPersister<Book> {

    private final BookRepository repository;

    @Override
    public void persist(Book entity) {
        super.persist(entity);
        log.info(">>>> 2. I'm BookEntityPersister");
    }

    @Override
    public Class<?> executeAfter() {
        return AuthorEntityPersister.class;
    }
}
