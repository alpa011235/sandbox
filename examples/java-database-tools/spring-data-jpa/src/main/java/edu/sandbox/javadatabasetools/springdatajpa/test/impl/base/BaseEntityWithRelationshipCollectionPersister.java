package edu.sandbox.javadatabasetools.springdatajpa.test.impl.base;

import edu.sandbox.javadatabasetools.springdatajpa.test.EntityPersister;
import lombok.extern.slf4j.Slf4j;

import java.util.Collection;

import static org.springframework.util.CollectionUtils.isEmpty;

@Slf4j
public abstract class BaseEntityWithRelationshipCollectionPersister<PARENT, CHILD> extends BaseEntityJpaPersister<CHILD> implements EntityPersister<PARENT> {

    @Override
    public void persist(PARENT entity) {
        var collection = getChildRelationship(entity);
        if (!isEmpty(collection)) {
            saveAll(collection);
        }
    }

    abstract protected Collection<CHILD> getChildRelationship(PARENT entity);
}
