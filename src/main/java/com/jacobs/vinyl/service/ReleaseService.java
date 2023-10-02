package com.jacobs.vinyl.service;

import com.jacobs.vinyl.repository.GenreRepository;
import com.jacobs.vinyl.repository.Release;
import com.jacobs.vinyl.repository.ReleaseRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class ReleaseService {

    private final ReleaseRepository releaseRepository;
    private final GenreRepository genreRepository;

    @Autowired
    public ReleaseService(ReleaseRepository releaseRepository, GenreRepository genreRepository) {

        this.releaseRepository = releaseRepository;
        this.genreRepository = genreRepository;
    }

    @Transactional
    public Release createRelease(Release release) {
        Release savedRelease = releaseRepository.saveAndFlush(release);
       // savedRelease = releaseRepository.findById(release.getReleaseId()).get();
        //savedRelease = getRelease(savedRelease.getReleaseId());
       //release.getGenres().forEach(g -> {g.addRelease(savedRelease); genreRepository.save(g);});
        return savedRelease;
    }

    public List<Release> getAllReleases() {
        return StreamSupport.stream(releaseRepository.findAll().spliterator(), false)
                .collect(Collectors.toList());
    }

    @Transactional
    public Release getRelease(int releaseId) {
        Release foundRelease = releaseRepository.findById(releaseId).orElse(new Release());
        return foundRelease;
    }

    public Release updateRelease(Release release) {
        Release savedRelease = releaseRepository.save(release);
        return savedRelease;
    }

    public void deleteRelease(int releaseId) {
        releaseRepository.deleteById(releaseId);
    }
}
