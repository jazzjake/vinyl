package com.jacobs.vinyl.restService;

import com.jacobs.vinyl.dto.GenreDTO;
import com.jacobs.vinyl.dto.LabelDTO;
import com.jacobs.vinyl.repository.Genre;
import com.jacobs.vinyl.repository.Label;
import com.jacobs.vinyl.service.GenreService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class GenreController {

    private GenreService genreService;

    @Autowired
    public GenreController(GenreService genreService) {
        this.genreService = genreService;
    }

    @GetMapping(value = "/genres")
    public List<GenreDTO> getAllGenres() {
        List<Genre> genres = genreService.getAllGenres();
        return genres.stream()
                .map(this::toGenreDTO)
                .collect(Collectors.toList());
    }
    @PostMapping(value = "/genre")
    public GenreDTO createGenre(@RequestBody GenreDTO newGenre) {
        Genre genre = genreService.createGenre(newGenre.getGenreName());
        return toGenreDTO(genre);
    }

    private GenreDTO toGenreDTO(Genre genre) {
        GenreDTO genreDTO = new GenreDTO();
        BeanUtils.copyProperties(genre, genreDTO);
        return genreDTO;
    }


}
