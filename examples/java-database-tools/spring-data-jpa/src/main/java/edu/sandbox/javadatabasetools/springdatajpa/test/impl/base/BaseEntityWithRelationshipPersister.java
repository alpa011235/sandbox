package edu.sandbox.javadatabasetools.springdatajpa.test.impl.base;

import edu.sandbox.javadatabasetools.springdatajpa.test.EntityPersister;
import lombok.extern.slf4j.Slf4j;

import java.util.Optional;

@Slf4j
public abstract class BaseEntityWithRelationshipPersister<PARENT, CHILD> extends BaseEntityJpaPersister<CHILD> implements EntityPersister<PARENT> {

    @Override
    public void persist(PARENT entity) {
        getChildRelationship(entity).ifPresent(this::save);
    }

    abstract protected Optional<CHILD> getChildRelationship(PARENT entity);
}
