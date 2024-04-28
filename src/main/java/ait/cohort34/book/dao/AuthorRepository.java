package ait.cohort34.book.dao;

import ait.cohort34.book.model.Author;

import java.util.Optional;

public interface AuthorRepository  {

    Optional<Author> findById(String authorName);

    Author save(Author author);

    Author deleteById(String authorName);
}
