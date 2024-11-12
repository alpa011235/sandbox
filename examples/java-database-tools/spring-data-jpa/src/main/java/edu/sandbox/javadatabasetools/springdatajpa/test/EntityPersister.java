package edu.sandbox.javadatabasetools.springdatajpa.test;

public interface EntityPersister<T> {

    // Сценарий сохранения Book:
    // 1. На вход поступает Book
    // 2. Нам нужно сохранить сначала его связь Author чтобы получить author_id
    // 3. Потом можно сохранить Book
    // 5. После чего можно сохранить коллекцию Comment т.к. у неe есть связь book_id
    // 6. После чего можно сохранить коллекцию Genre т.к. у неe есть связь book_id

    void persist(T entity);

    Class<?> executeAfter();
}
