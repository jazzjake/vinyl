package com.jacobs.vinyl.restService;

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

//    @PutMapping(value = "/release/{releaseID}")
//    Release updateRelease (@RequestBody ReleaseDTO updatedRelease) {
//        return releaseService.updateRelease(updatedRelease);
//
//    }
    @DeleteMapping(value = "/release/{releaseId}")
    public void deleteRelease(@PathVariable int releaseId) {
        releaseService.deleteRelease(releaseId);
    }

    private Release toRelease(ReleaseDTO releaseDTO) {
        Release release = new Release();
        BeanUtils.copyProperties(releaseDTO, release);
        return release;
    }

    public ReleaseDTO toReleaseDTO(Release release) {
        ReleaseDTO releaseDTO = new ReleaseDTO();
        BeanUtils.copyProperties(release, releaseDTO);
        return releaseDTO;
    }
}
