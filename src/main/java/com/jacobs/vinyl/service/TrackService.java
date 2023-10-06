package com.jacobs.vinyl.service;

import com.jacobs.vinyl.model.Track;
import com.jacobs.vinyl.repository.TrackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.StreamSupport;

@Service
public class TrackService {

    private final TrackRepository trackRepository;

    @Autowired
    public TrackService(TrackRepository trackRepository) { this.trackRepository = trackRepository;}

    public List<Track> getAllTracks() {
        return StreamSupport.stream(trackRepository.findAll().spliterator(), false).toList();

    }
}
