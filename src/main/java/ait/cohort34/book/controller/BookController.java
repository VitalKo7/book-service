package ait.cohort34.book.controller;

import ait.cohort34.book.dto.AuthorDto;
import ait.cohort34.book.dto.BookDto;
import ait.cohort34.book.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;


@RestController
//@RequestMapping("")
@RequiredArgsConstructor
public class BookController {
    final BookService bookService;

    @PostMapping("/book")
    public Boolean addBook(@RequestBody BookDto bookDto) {
        return bookService.addBook(bookDto);
    }

    @GetMapping("/book/{isbn}")
    public BookDto findBookByIsbn(@PathVariable Integer isbn) {
        return bookService.findBookByIsbn(isbn);
    }

    @DeleteMapping("/book/{isbn}")
    public BookDto removeBook(@PathVariable Integer isbn) {
        return bookService.removeBook(isbn);
    }

    @PutMapping("/book/{isbn}/title/{newTitle}")
    public BookDto updateBookTitle(@PathVariable Integer isbn, @PathVariable String newTitle) {
        return bookService.updateBookTitle(isbn, newTitle);
    }

    @GetMapping("/books/author/{author}")
    public BookDto[] findBooksByAuthor(@PathVariable String author) {
        return bookService.findBooksByAuthor(author);
    }

    @GetMapping("/books/publisher/{publisher}")
    public BookDto[] findBooksByPublisher(@PathVariable String publisher) {
        return bookService.findBooksByPublisher(publisher);
    }

    @GetMapping("/authors/book/{isbn}")
    public AuthorDto[] findAuthorsByIsbn(@PathVariable Integer isbn) {
        return bookService.findAuthorsByIsbn(isbn);
    }

    @GetMapping("/publishers/author/{author}")
    public String[] findPublishersByAuthor(@PathVariable String author) {
        return bookService.findPublishersByAuthor(author);
    }

    @DeleteMapping("/author/{author}")
    public AuthorDto removeAuthor(@PathVariable String author) {
        return bookService.removeAuthor(author);
    }
}
