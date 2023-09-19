package com.jacobs.vinyl.restService;

import com.jacobs.vinyl.dao.Release;
import com.jacobs.vinyl.dao.ReleaseDTO;
import com.jacobs.vinyl.service.ReleaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

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
        Release release =releaseService.createRelease(newRelease.getArtist(), newRelease.getTitle(), newRelease.getLabel());
        return ReleaseDTO.toReleaseDTO(release);
    }

    @GetMapping(value = "/releases")
    public List<ReleaseDTO> getAllReleases() {
        return releaseService.getAllReleases()
                .stream()
                .map(ReleaseDTO::toReleaseDTO)
                .collect(Collectors.toList());
    }
}
