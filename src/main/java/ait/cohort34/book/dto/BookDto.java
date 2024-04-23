package ait.cohort34.book.dto;

import lombok.Getter;

@Getter
public class BookDto {
    String isbn;
    String title;
    AuthorDto[] authors;
    String publisher;
}
