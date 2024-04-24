package ait.cohort34.book.model;

import ait.cohort34.book.dto.AuthorDto;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import lombok.*;

import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(of = "isbn")
@Entity
public class Book {
    @Id
    String isbn;
    String title;

    @ManyToMany
    Set<Author> authors;

    @ManyToOne
    Publisher publisher;
}
