package ait.cohort34.book.dao;

import ait.cohort34.book.model.Book;

import java.util.Optional;
import java.util.stream.Stream;

public interface BookRepository  {

    Stream<Book> findByAuthorsName(String authorName);

    Stream<Book> findByPublisherPublisherName(String publisherName);

    void deleteByAuthorsName(String authorName);

    boolean existsById(String isbn);

    Book save(Book book);

    Optional<Book> findById(String isbn);

    Book deleteById(String isbn);
}
