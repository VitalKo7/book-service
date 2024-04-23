package ait.cohort34.book.dto;

import lombok.Getter;

import java.time.LocalDate;

@Getter
public class AuthorDto {
    String name;
    LocalDate birthDate;
}
