package edu.sandbox.javadatabasetools.springdatajpa.test.impl.base;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;

public abstract class BaseEntityJpaPersister<T> {

    protected void save(T entity) {
        getRepository().save(entity);
    }

    protected void saveAll(Collection<T> collection) {
        getRepository().saveAll(collection);
    }

    protected abstract JpaRepository<T, ?> getRepository();
}
