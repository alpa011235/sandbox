package edu.sandbox.javadatabasetools.springdatajpa.test.impl.base;

import edu.sandbox.javadatabasetools.springdatajpa.test.EntityPersister;
import lombok.extern.slf4j.Slf4j;

import java.util.Objects;

@Slf4j
public abstract class BaseEntityRootPersister<T> extends BaseEntityJpaPersister<T> implements EntityPersister<T> {

    @Override
    public void persist(T entity) {
        Objects.requireNonNull(entity, "root entity can't be null");
        save(entity);
    }
}
