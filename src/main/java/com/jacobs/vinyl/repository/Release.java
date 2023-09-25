package com.jacobs.vinyl.repository;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="releases")  //name of table in db
public class Release {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    //@Column(name = "releaseId", nullable = false ) use to specify db column name & other properties
    private int releaseId;
    private String artist;
    private String title;
    private String label;
    private String releaseYear;

    // mappedBy refers to property in Genre class
    @OneToMany(mappedBy = "release", cascade = CascadeType.ALL)
    private List<Genre> genres = new ArrayList<>();

    public Release() {
    }

    public Release(String artist, String title, String label) {
        this.artist = artist;
        this.title = title;
        this.label = label;
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

    public String getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(String releaseYear) {
        this.releaseYear = releaseYear;
    }

    public int getReleaseId() {
        return releaseId;
    }

    public List<Genre> getGenres() {
        return genres;
    }

    public void setGenres(List<Genre> genres) {
        this.genres = genres;
    }

    @Override
    public String toString() {
        return "Release{" +
                "artist='" + artist + '\'' +
                ", title='" + title + '\'' +
                ", label='" + label + '\'' +
                ", releaseYear='" + releaseYear + '\'' +
                '}';
    }
}
