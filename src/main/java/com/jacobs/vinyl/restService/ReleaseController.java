package com.jacobs.vinyl.restService;

import com.jacobs.vinyl.repository.Release;
import com.jacobs.vinyl.dto.ReleaseDTO;
import com.jacobs.vinyl.service.ReleaseService;
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

//    @PutMapping(value = "/release/{releaseID}")
//    Release updateRelease (@RequestBody ReleaseDTO updatedRelease) {
//        return releaseService.updateRelease(updatedRelease);
//
//    }
    @DeleteMapping(value = "/release/{releaseId}")
    public void deleteRelease(@PathVariable int releaseId) {
        releaseService.deleteRelease(releaseId);
    }
}
