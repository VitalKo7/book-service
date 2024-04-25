package ait.cohort34.book.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(of = "name")
@Entity
@Table(name = "author")
public class Author {
    @Id
    @Column(name = "name")
    String name;

    @Column(name = "birth_date")
    LocalDate birthDate;

    @ManyToMany(mappedBy = "authors", cascade = CascadeType.REMOVE)
//    @JsonIgnore   //чтобы избежать рекурсию;
    Set<Book> books;

    public Author(String name, LocalDate birthDate) {
        this.name = name;
        this.birthDate = birthDate;
    }
}
