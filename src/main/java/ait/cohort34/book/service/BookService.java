package ait.cohort34.book.service;

import ait.cohort34.book.dto.AuthorDto;
import ait.cohort34.book.dto.BookDto;

public interface BookService {
    Boolean addBook(BookDto bookDto);

    BookDto findBookByIsbn(String isbn);

    BookDto removeBook(String isbn);

    BookDto updateBookTitle(String isbn, String newTitle);


   Iterable<BookDto> findBooksByAuthor(String authorName);

    Iterable<BookDto> findBooksByPublisher(String publisherName);

   Iterable<AuthorDto> findBookAuthorsByIsbn(String isbn);

    Iterable<String> findPublishersByAuthor(String authorName);


    AuthorDto removeAuthor(String authorName);


}
