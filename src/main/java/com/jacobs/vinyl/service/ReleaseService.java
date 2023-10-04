package com.jacobs.vinyl.service;

import com.jacobs.vinyl.repository.GenreRepository;
import com.jacobs.vinyl.repository.Release;
import com.jacobs.vinyl.repository.ReleaseRepository;
import com.jacobs.vinyl.repository.TrackRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class ReleaseService {

    private final ReleaseRepository releaseRepository;
    //private final GenreRepository genreRepository;
    private final TrackRepository trackRepository;

    @Autowired
    public ReleaseService(ReleaseRepository releaseRepository, TrackRepository trackRepository) {

        this.releaseRepository = releaseRepository;
        this.trackRepository = trackRepository;
    }

    @Transactional
    public Release createRelease(Release release) {
        Release savedRelease = releaseRepository.saveAndFlush(release);
       // savedRelease = releaseRepository.findById(release.getReleaseId()).get();
        //savedRelease = getRelease(savedRelease.getReleaseId());
       //release.getGenres().forEach(g -> {g.addRelease(savedRelease); genreRepository.save(g);});
        release.getTracks().forEach(track -> {
            track.setRelease(release); trackRepository.save(track);});
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
