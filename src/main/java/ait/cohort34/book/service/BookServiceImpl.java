package ait.cohort34.book.service;

import ait.cohort34.book.dto.AuthorDto;
import ait.cohort34.book.dto.BookDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookService {

    @Override
    public Boolean addBook(BookDto bookDto) {
        return null;
    }

    @Override
    public BookDto findBookByIsbn(Integer isbn) {
        return null;
    }

    @Override
    public BookDto removeBook(Integer isbn) {
        return null;
    }

    @Override
    public BookDto updateBookTitle(Integer isbn, String newTitle) {
        return null;
    }

    @Override
    public BookDto[] findBooksByAuthor(String author) {
        return new BookDto[0];
    }

    @Override
    public BookDto[] findBooksByPublisher(String publisher) {
        return new BookDto[0];
    }

    @Override
    public AuthorDto[] findAuthorsByIsbn(Integer isbn) {
        return new AuthorDto[0];
    }

    @Override
    public String[] findPublishersByAuthor(String author) {
        return new String[0];
    }

    @Override
    public AuthorDto removeAuthor(String author) {
        return null;
    }
}
