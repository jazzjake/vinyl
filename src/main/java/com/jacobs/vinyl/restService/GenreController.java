package com.jacobs.vinyl.restService;

import com.jacobs.vinyl.dto.GenreDTO;
import com.jacobs.vinyl.model.Genre;
import com.jacobs.vinyl.service.GenreService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
        List<GenreDTO> genreDTOS = genres.stream()
                .map(this::toGenreDTO)
                .collect(Collectors.toList());
        return genreDTOS;
    }

    @PutMapping(value = "/genre")
    public GenreDTO updateGenre(@RequestBody GenreDTO genreDTO) {
        Genre genre = genreService.updateGenre(toGenre(genreDTO));
        return toGenreDTO(genre);

    }

    @PostMapping(value = "/genre")
    public GenreDTO createGenre(@RequestBody GenreDTO newGenre) {
        Genre genre = genreService.createGenre(newGenre.getGenreName());
        return toGenreDTO(genre);
    }

    private GenreDTO toGenreDTO(Genre genre) {
        GenreDTO genreDTO = new GenreDTO();
        BeanUtils.copyProperties(genre, genreDTO);
        //Release release = genre.getRelease();
       // genreDTO.setReleases(genre.getReleases());
        return genreDTO;
    }

    private Genre toGenre(GenreDTO genreDTO) {
        Genre genre = new Genre();
        BeanUtils.copyProperties(genreDTO, genre);
        return genre;
    }
}
