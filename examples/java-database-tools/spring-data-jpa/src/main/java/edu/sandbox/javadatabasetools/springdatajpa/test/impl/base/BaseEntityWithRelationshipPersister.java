package edu.sandbox.javadatabasetools.springdatajpa.test.impl.base;

import edu.sandbox.javadatabasetools.springdatajpa.test.EntityPersister;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

@Slf4j
public abstract class BaseEntityWithRelationshipPersister<PARENT, CHILD> implements EntityPersister<PARENT> {

    @Override
    public void persist(PARENT entity) {
        getChildRelationship(entity).ifPresent(child -> getRepository().save(child));
    }

    abstract protected Optional<CHILD> getChildRelationship(PARENT entity);

    abstract protected JpaRepository<CHILD, ?> getRepository();
}
