package ait.cohort34.book.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(of = "publisherName")
@Entity
public class Publisher {
    @Id
    String publisherName;

    @Override
    public String toString() {
        return publisherName;
    }
}
