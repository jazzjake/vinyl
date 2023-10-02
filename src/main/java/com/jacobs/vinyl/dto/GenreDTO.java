package com.jacobs.vinyl.dto;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.jacobs.vinyl.repository.Release;

import java.util.List;

public class GenreDTO {

    private int genreId;
    private String genreName;
    //@JsonBackReference
//    @JsonManagedReference
//    private List<Release> releases;


    public int getGenreId() {
        return genreId;
    }

    public void setGenreId(int genreId) {
        this.genreId = genreId;
    }

    public String getGenreName() {
        return genreName;
    }

    public void setGenreName(String genreName) {
        this.genreName = genreName;
    }

//    public List<Release> getReleases() {
//        return releases;
//    }
//
//    public void setReleases(List<Release> releases) {
//        this.releases = releases;
//    }
}
