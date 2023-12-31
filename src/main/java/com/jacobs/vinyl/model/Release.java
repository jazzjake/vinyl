package com.jacobs.vinyl.model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="releases")  //name of table in db
public class Release {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //@Column(name = "releaseId"  ) //use to specify db column name & other properties
    private int releaseId;
    private String artist;
    private String title;
    @Column(nullable = false)
    private int noOfDiscs;
    @Column(nullable = false)
    private boolean mono;
    private String catalogNumber;

    @ManyToOne
    @JoinColumn(name="label_id", nullable = false)
    private Label label;
    private String releaseYear;

    // mappedBy refers to property in Genre class
    //@JsonManagedReference
    //@JsonBackReference
    @ManyToMany()
    private List<Genre> genres = new ArrayList<>();

    @OneToMany(mappedBy = "release", cascade=CascadeType.PERSIST)
    private List<Track> tracks = new ArrayList<>();

    public Release() {
    }

    public Release(String artist, String title) {
        this.artist = artist;
        this.title = title;

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

    public Label getLabel() {
        return label;
    }

    public void setLabel(Label label) {
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

    public int getNoOfDiscs() {
        return noOfDiscs;
    }

    public void setNoOfDiscs(int noOfDiscs) {
        this.noOfDiscs = noOfDiscs;
    }

    public List<Track> getTracks() {
        return tracks;
    }

    public void setTracks(List<Track> tracks) {
        this.tracks = tracks;
    }

    public boolean getMono() {
        return mono;
    }

    public void setMono(boolean mono) {
        this.mono = mono;
    }

    public String getCatalogNumber() {
        return catalogNumber;
    }

    public void setCatalogNumber(String catalogNumber) {
        this.catalogNumber = catalogNumber;
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
