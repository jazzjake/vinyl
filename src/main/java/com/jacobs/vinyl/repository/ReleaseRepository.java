package com.jacobs.vinyl.repository;

import com.jacobs.vinyl.model.Release;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReleaseRepository extends JpaRepository<Release, Integer> {

    Release findByArtist(String artist);
}
