package edu.sandbox.javadatabasetools.springdatajpa.test.impl;

import edu.sandbox.javadatabasetools.springdatajpa.model.Book;
import edu.sandbox.javadatabasetools.springdatajpa.model.Comment;
import edu.sandbox.javadatabasetools.springdatajpa.repository.CommentRepository;
import edu.sandbox.javadatabasetools.springdatajpa.test.impl.base.BaseEntityWithRelationshipCollectionPersister;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;

@Slf4j
@Getter
@Service
@RequiredArgsConstructor
public class CommentEntityPersister extends BaseEntityWithRelationshipCollectionPersister<Book, Comment> {

    private final CommentRepository repository;

    @Override
    public List<Comment> getChildRelationship(Book root) {
        return root.getComments();
    }

    @Override
    public Class<?> executeAfter() {
        return BookEntityPersister.class;
    }
}
