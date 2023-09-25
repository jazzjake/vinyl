package com.jacobs.vinyl.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import org.springframework.stereotype.Repository;

import java.util.List;

//@NamedQuery(name="getallgenre", query="select g from Genre g")
@Repository
public class GenreRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public Genre save (Genre genre) {
        entityManager.persist(genre);
        return genre;
    }

    public List<Genre> findAll() {
        TypedQuery<Genre> query1 = entityManager.createNamedQuery("getallgenre", Genre.class);
        return query1.getResultList();

    }
}
