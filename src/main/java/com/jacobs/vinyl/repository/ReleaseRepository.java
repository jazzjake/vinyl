package com.jacobs.vinyl.repository;

import com.jacobs.vinyl.repository.Release;
import org.springframework.data.repository.CrudRepository;

public interface ReleaseRepository extends CrudRepository<Release, Integer> {

    Release findByArtist(String artist);
}
