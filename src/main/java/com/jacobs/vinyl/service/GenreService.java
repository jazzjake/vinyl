package com.jacobs.vinyl.service;

import com.jacobs.vinyl.repository.Genre;
import com.jacobs.vinyl.repository.GenreRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GenreService {

    @Autowired
    GenreRepository genreRepository;

    public List<Genre> getAllGenres() {
        return genreRepository.findAll();
    }
    @Transactional
    public Genre createGenre(String genreName) {
        return genreRepository.save(new Genre(genreName));
    }
}
