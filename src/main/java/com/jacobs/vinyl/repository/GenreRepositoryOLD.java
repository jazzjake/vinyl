package com.jacobs.vinyl.repository;

import com.jacobs.vinyl.model.Genre;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import org.springframework.stereotype.Repository;

import java.util.List;

//@NamedQuery(name="getallgenre", query="select g from Genre g")
@Repository
public class GenreRepositoryOLD {

    @PersistenceContext
    private EntityManager entityManager;

    public Genre save (Genre genre) {
        entityManager.persist(genre);
        return genre;
    }

    public List<Genre> findAll() {
        TypedQuery<Genre> query1 = entityManager.createNamedQuery("getallgenre", Genre.class);
        List<Genre> genres =query1.getResultList();
        return genres;

    }
}
