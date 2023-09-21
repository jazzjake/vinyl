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

    public Release createRelease(String artist, String title, String label) {
        return releaseRepository.save(new Release(artist, title, label));
    }

    public List<Release> getAllReleases() {
        return StreamSupport.stream(releaseRepository.findAll().spliterator(), false)
                .collect(Collectors.toList());
    }

        //    public Release updateRelease() {
        //        releaseRepository.save()
        //    }
    public void deleteRelease(int releaseId) {
        releaseRepository.deleteById(releaseId);
    }
}
