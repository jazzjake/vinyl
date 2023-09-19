package com.jacobs.vinyl.dao;

import org.springframework.data.repository.CrudRepository;

public interface ReleaseRepository extends CrudRepository<Release, Integer> {

    Release findByArtist(String artist);
}
