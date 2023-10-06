package com.jacobs.vinyl.repository;

import com.jacobs.vinyl.model.Genre;
import org.springframework.data.repository.CrudRepository;

public interface GenreRepository extends CrudRepository<Genre, Integer> {
}
