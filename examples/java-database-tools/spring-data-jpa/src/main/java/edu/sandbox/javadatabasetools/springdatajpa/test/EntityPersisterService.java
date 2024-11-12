package edu.sandbox.javadatabasetools.springdatajpa.test;

import edu.sandbox.javadatabasetools.springdatajpa.model.Book;
import edu.sandbox.javadatabasetools.springdatajpa.test.order.DefaultOrder;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class EntityPersisterService {

    private final List<EntityPersister<Book>> persisters;

    public void save(Book book) {
        // sorting phase
        var sortedPersisters = sort();

        // execution phase
        sortedPersisters.forEach(persister -> persister.persist(book));

        log.info(">>>> finished");
    }

    private List<EntityPersister<Book>> sort() {
        Map<Class<?>, EntityPersister<Book>> perstistersMap = persisters.stream()
                .collect(Collectors.toMap(EntityPersister::getClass, p -> p));

        Set<Class<?>> visited = new HashSet<>();
        List<EntityPersister<Book>> sorted = new ArrayList<>();

        for (var persister : persisters) {
            sort(persister, perstistersMap, sorted, visited);
        }

        return sorted;
    }

    private void sort(
            EntityPersister<Book> persister,
            Map<Class<?>, EntityPersister<Book>> perstistersMap,
            List<EntityPersister<Book>> sorted,
            Set<Class<?>> visited
    ) {
        var persisterClass = persister.getClass();
        if (visited.contains(persisterClass)) {
            return;
        }
        visited.add(persisterClass);

        Class<?> dependency = persister.executeAfter();
        if (dependency != null && !dependency.equals(DefaultOrder.class) && perstistersMap.containsKey(dependency)) {
            sort(perstistersMap.get(dependency), perstistersMap, sorted, visited);
        }

        if (DefaultOrder.class.equals(dependency)) {
            sorted.add(0, persister);
            return;
        }

        sorted.add(persister);
    }
}
