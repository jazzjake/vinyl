package com.jacobs.vinyl.repository;

import com.jacobs.vinyl.repository.Release;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface ReleaseRepository extends JpaRepository<Release, Integer> {

    Release findByArtist(String artist);
}
