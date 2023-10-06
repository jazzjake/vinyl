package com.jacobs.vinyl.service;

import com.jacobs.vinyl.model.Genre;
import com.jacobs.vinyl.repository.GenreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GenreService {

    @Autowired
    GenreRepository genreRepository;

    public List<Genre> getAllGenres() {

        return (List<Genre>) genreRepository.findAll();
    }
    //@Transactional
    public Genre createGenre(String genreName) {
        return (Genre) genreRepository.save(new Genre(genreName));
    }

    public Genre updateGenre(Genre genre) {
        return genreRepository.save(genre);
    }
}
