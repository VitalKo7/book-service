package ait.cohort34.book.dao;

import ait.cohort34.book.model.Book;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.stream.Stream;

@Repository
public class BookRepositoryImpl implements BookRepository {

    @PersistenceContext
    EntityManager em;


    @Override
    public Stream<Book> findByAuthorsName(String authorName) {
//        return em.createQuery("SELECT b FROM Book b JOIN b.authors a WHERE a.name = :authorName", Book.class)
//                .setParameter("authorName", authorName)
//                .getResultStream();

        return em.createQuery("SELECT b FROM Book b JOIN b.authors a WHERE a.name = ?1", Book.class)
                .setParameter(1, authorName)
                .getResultStream();
    }

    @Override
    public Stream<Book> findByPublisherPublisherName(String publisherName) {
//        return em.createQuery("SELECT b FROM Book b WHERE b.publisher.publisherName = :publisherName", Book.class)
//                .setParameter("publisherName", publisherName)
//                .getResultStream();

        return em.createQuery("SELECT b FROM Book b join b.publisher p where p.publisherName =?1", Book.class)
                .setParameter(1, publisherName)
                .getResultStream();
    }

    @Override
    public void deleteByAuthorsName(String authorName) {
//        em.createQuery("DELETE FROM Book b WHERE :authorName IN (SELECT a.name FROM b.authors a)")
//                .setParameter("authorName", authorName)
//                .executeUpdate();

//        Query query = em.createQuery("DELETE FROM Book b join b.authors a WHERE a.name = ?1");
//                query.setParameter(1, authorName);
//                query.executeUpdate();

        em.createQuery("delete from Book b where :name member of b.authors")
                .setParameter("name", authorName)
                .executeUpdate();
    }

    @Override
    public boolean existsById(String isbn) {
        return em.find(Book.class, isbn) != null;
    }

    @Override
    public Book save(Book book) {
        em.persist(book);
        return book;
    }

    @Override
    public Optional<Book> findById(String isbn) {
        return Optional.ofNullable(em.find(Book.class, isbn));
    }

    @Override
    public Book deleteById(String isbn) {
        Book book = em.find(Book.class, isbn);
        if (book != null) {
            em.remove(book);
        }
        return book;
    }
}
