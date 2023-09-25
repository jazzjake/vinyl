package com.jacobs.vinyl.repository;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

@Entity
@NamedQuery(name="getallgenre", query="select g from Genre g")
public class Genre {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int genreId;
    private String genreName;
    @JsonIgnore
    @ManyToOne
    private Release release;

    public Genre() {
    }

    public Genre(String genreName) {
        this.genreName = genreName;
    }

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
