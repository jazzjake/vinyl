package com.jacobs.vinyl.repository;

import com.jacobs.vinyl.model.Track;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TrackRepository extends JpaRepository<Track, Integer> {
}
