package edu.sandbox.javadatabasetools.springdatajpa.test.impl.base;

import edu.sandbox.javadatabasetools.springdatajpa.test.EntityPersister;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.jpa.repository.JpaRepository;

@Slf4j
public abstract class BaseEntityPersister<T> implements EntityPersister<T> {

    @Override
    public void persist(T entity) {
        getRepository().save(entity);
    }

    protected abstract JpaRepository<T, ?> getRepository();
}
