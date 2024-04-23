package ait.cohort34.book.service;

import ait.cohort34.book.dto.AuthorDto;
import ait.cohort34.book.dto.BookDto;

public interface BookService {
    Boolean addBook(BookDto bookDto);

    BookDto findBookByIsbn(Integer isbn);

    BookDto removeBook(Integer isbn);

    BookDto updateBookTitle(Integer isbn, String newTitle);


    BookDto[] findBooksByAuthor(String author);

    BookDto[] findBooksByPublisher(String publisher);

    AuthorDto[] findAuthorsByIsbn(Integer isbn);

    String[] findPublishersByAuthor(String author);


    AuthorDto removeAuthor(String author);

}
