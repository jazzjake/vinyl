package com.jacobs.vinyl.service;

import com.jacobs.vinyl.repository.Release;
import com.jacobs.vinyl.repository.ReleaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class ReleaseService {

    private final ReleaseRepository releaseRepository;

    @Autowired
    public ReleaseService(ReleaseRepository releaseRepository) {
        this.releaseRepository = releaseRepository;
    }

    public Release createRelease(Release release) {
        Release savedRelease = releaseRepository.save(release);
        release.getGenres().forEach(g -> g.setRelease(savedRelease));
        return releaseRepository.save(savedRelease);
    }

    public List<Release> getAllReleases() {
        return StreamSupport.stream(releaseRepository.findAll().spliterator(), false)
                .collect(Collectors.toList());
    }

    public Release getRelease(int releaseId) {
        return releaseRepository.findById(releaseId).orElse(new Release());
    }

        //    public Release updateRelease() {
        //        releaseRepository.save()
        //    }
    public void deleteRelease(int releaseId) {
        releaseRepository.deleteById(releaseId);
    }
}
