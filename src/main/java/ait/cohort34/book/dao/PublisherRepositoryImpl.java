package ait.cohort34.book.dao;

import ait.cohort34.book.model.Publisher;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

@Repository
public class PublisherRepositoryImpl implements PublisherRepository {

    @PersistenceContext
    EntityManager em;


    @Override
    public List<String> findByPublishersAuthor(String authorName) {
//        String jpql = "SELECT DISTINCT p.publisherName FROM Publisher p JOIN p.books b JOIN b.authors a WHERE a.name = :authorName";
//        return em.createQuery(jpql, String.class)
//                .setParameter("authorName", authorName)
//                .getResultList();

        return em.createQuery("select distinct p.publisherName from Book b join b.publisher p join b.authors a where a.name =?1")
                .setParameter(1, authorName)
                .getResultList();
    }

    @Override
    public Stream<Publisher> findDistinctByBooksAuthorsName(String authorName) {
//        String jpql = "SELECT DISTINCT p FROM Publisher p JOIN p.books b JOIN b.authors a WHERE a.name = :authorName";
//        return em.createQuery(jpql, Publisher.class)
//                .setParameter("authorName", authorName)
//                .getResultStream();

        TypedQuery<Publisher> query = em.createQuery("SELECT DISTINCT p FROM Book b JOIN b.publisher p join b.authors a where a.name =?1", Publisher.class);
        query.setParameter(1, authorName);
        return query.getResultStream();
    }

    @Override
    public Optional<Publisher> findById(String publisher) {
        return Optional.ofNullable(em.find(Publisher.class, publisher));
    }

    @Override
    public Publisher save(Publisher publisher) {
        em.persist(publisher);
//        em.merge(publisher);
        return publisher;
    }
}
