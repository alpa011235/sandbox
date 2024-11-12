package edu.sandbox.javadatabasetools.springdatajpa.test.deprecated;

import edu.sandbox.javadatabasetools.springdatajpa.test.EntityPersister;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;

public abstract class BaseEntityCollectionPersister<PARENT, CHILD> implements EntityPersister<PARENT> {

    @Override
    public void persist(PARENT entity) {
        var childCollection = extractEntity(entity);
        if (!childCollection.isEmpty()) {
            getRepository().saveAll(childCollection);
        }
    }

    public abstract Collection<CHILD> extractEntity(PARENT entity);

    public abstract JpaRepository<CHILD, ?> getRepository();
}
