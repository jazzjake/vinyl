package com.jacobs.vinyl.dto;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.jacobs.vinyl.repository.Genre;
import com.jacobs.vinyl.repository.Label;
import com.jacobs.vinyl.repository.Release;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ReleaseDTO {

    private int releaseId;
    private String artist;
    private String title;
    private int noOfDiscs;
    private LabelDTO label;
    private String releaseYear;
    //@JsonManagedReference
//    @JsonBackReference
    private List<GenreDTO> genres = new ArrayList<>();
    @JsonManagedReference
    //@JsonBackReference
    private List<TrackDTO> tracks = new ArrayList<>();



    public ReleaseDTO(int id, String artist, String title, String year) {
        this.releaseId = id;
        this.artist = artist;
        this.title = title;
        this.releaseYear = year;
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

    public LabelDTO getLabel() {
        return label;
    }

    public void setLabel(LabelDTO label) {
        this.label = label;
    }

    public String getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(String year) {
        this.releaseYear = year;
    }

    public List<GenreDTO> getGenres() {
        return genres;
    }

    public void setGenres(List<GenreDTO> genres) {
        this.genres = genres;
    }

    public int getNoOfDiscs() {
        return noOfDiscs;
    }

    public void setNoOfDiscs(int noOfDiscs) {
        this.noOfDiscs = noOfDiscs;
    }

    public List<TrackDTO> getTracks() {
        return tracks;
    }

    public void setTracks(List<TrackDTO> tracks) {
        this.tracks = tracks;
    }

    @Override
    public String toString() {
        return "ReleaseDTO{" +
                "id=" + releaseId +
                ", artist='" + artist + '\'' +
                ", title='" + title + '\'' +
                ", label='" + label + '\'' +
                ", year='" + releaseYear + '\'' +
                '}';
    }
}
