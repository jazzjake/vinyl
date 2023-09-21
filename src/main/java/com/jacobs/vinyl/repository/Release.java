package com.jacobs.vinyl.repository;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Release {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String artist;
    private String title;
    private String label;
    private String releaseYear;

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

    public int getId() {
        return id;
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
