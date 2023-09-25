package com.jacobs.vinyl.dto;

import com.jacobs.vinyl.repository.Genre;
import com.jacobs.vinyl.repository.Release;

import java.util.List;

public class ReleaseDTO {

    private int releaseId;
    private String artist;
    private String title;
    private String label;
    private String year;
    private List<Genre> genres;

    public ReleaseDTO(int id, String artist, String title, String label, String year) {
        this.releaseId = id;
        this.artist = artist;
        this.title = title;
        this.label = label;
        this.year = year;
    }

    public ReleaseDTO() {
    }

    public int getReleaseId() {
        return releaseId;
    }

    public void setReleaseId(int releaseId) {
        this.releaseId = releaseId;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public List<Genre> getGenres() {
        return genres;
    }

    public void setGenres(List<Genre> genres) {
        this.genres = genres;
    }

    @Override
    public String toString() {
        return "ReleaseDTO{" +
                "id=" + releaseId +
                ", artist='" + artist + '\'' +
                ", title='" + title + '\'' +
                ", label='" + label + '\'' +
                ", year='" + year + '\'' +
                '}';
    }
}
