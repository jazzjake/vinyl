package com.jacobs.vinyl.restService;

import com.jacobs.vinyl.dto.GenreDTO;
import com.jacobs.vinyl.dto.LabelDTO;
import com.jacobs.vinyl.repository.Genre;
import com.jacobs.vinyl.repository.Label;
import com.jacobs.vinyl.repository.Release;
import com.jacobs.vinyl.dto.ReleaseDTO;
import com.jacobs.vinyl.service.ReleaseService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class ReleaseController {

    private ReleaseService releaseService;

    @Autowired
    public ReleaseController(ReleaseService releaseService) {
        this.releaseService = releaseService;
    }

    @PostMapping(value = "/release")
    public ReleaseDTO createRelease(@RequestBody ReleaseDTO newRelease) {
        Release release =releaseService.createRelease(toRelease(newRelease));
        release = releaseService.getRelease(release.getReleaseId());
        return toReleaseDTO(release);
    }

    @GetMapping(value = "/release/{releaseId}")
    public ReleaseDTO getRelease(@PathVariable int releaseId) {
        return toReleaseDTO(releaseService.getRelease(releaseId));
    }
    @GetMapping(value = "/releases")
    public List<ReleaseDTO> getAllReleases() {
        List<Release> releases = releaseService.getAllReleases();
        return releases.stream()
                .map(this::toReleaseDTO)
                .collect(Collectors.toList());
    }

    @PutMapping(value = "/release")
    ReleaseDTO updateRelease (@RequestBody ReleaseDTO updatedRelease) {
        Release release = toRelease(updatedRelease);
        return toReleaseDTO(releaseService.updateRelease(release));

    }
    @DeleteMapping(value = "/release/{releaseId}")
    public void deleteRelease(@PathVariable int releaseId) {
        releaseService.deleteRelease(releaseId);
    }

    private Release toRelease(ReleaseDTO releaseDTO) {
        Release release = new Release();
        BeanUtils.copyProperties(releaseDTO, release);
        Label label = new Label();
        label.setId(releaseDTO.getLabel().getId());
        release.setLabel(label);
        for(GenreDTO genreDTO : releaseDTO.getGenres()){
            Genre genre = new Genre();
            BeanUtils.copyProperties(genreDTO, genre);
            release.getGenres().add(genre);
        }
        Genre genre = new Genre();

        return release;
    }

    public ReleaseDTO toReleaseDTO(Release release) {
        ReleaseDTO releaseDTO = new ReleaseDTO();
        BeanUtils.copyProperties(release, releaseDTO);
        LabelDTO labelDTO = new LabelDTO();
        labelDTO.setId(release.getLabel().getId());
        labelDTO.setLabelName(release.getLabel().getLabelName());
        releaseDTO.setLabel(labelDTO);
        for(Genre genre : release.getGenres()){
            GenreDTO genreDTO = new GenreDTO();
            BeanUtils.copyProperties(genre, genreDTO);
            releaseDTO.getGenres().add(genreDTO);
        }
        return releaseDTO;
    }
}
