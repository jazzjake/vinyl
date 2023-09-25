package com.jacobs.vinyl.dto;

import com.jacobs.vinyl.repository.Release;

public class GenreDTO {

    private int genreId;
    private String genreName;
    private Release release;


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

    public Release getRelease() {
        return release;
    }

    public void setRelease(Release release) {
        this.release = release;
    }
}
