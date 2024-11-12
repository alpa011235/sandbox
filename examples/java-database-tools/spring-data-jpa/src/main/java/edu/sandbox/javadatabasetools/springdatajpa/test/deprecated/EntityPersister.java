package edu.sandbox.javadatabasetools.springdatajpa.test.deprecated;

public interface EntityPersister extends edu.sandbox.javadatabasetools.springdatajpa.test.EntityPersister {

    // Сценарий сохранения Book:
    // 1. На вход поступает Book
    // 2. Нам нужно сохранить сначала его связь Author чтобы получить author_id
    // 3. Потом можно сохранить Book
    // 5. После чего можно сохранить коллекцию Comment т.к. у неe есть связь book_id
    // 6. После чего можно сохранить коллекцию Genre т.к. у неe есть связь book_id

    // 1. На основе корневой сущности нужно получить сущность которую мы хотим сохранить
//    <T, E> E extractEntity(T root);

    // 2. Нам нужно сохранить эту сущность
//    <E> void persist(E entity);
}
