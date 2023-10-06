package com.jacobs.vinyl.model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Entity
@NamedQuery(name="getallgenre", query="select g from Genre g")
public class Genre {

    @Id
    //@GeneratedValue(strategy = GenerationType.AUTO)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int genreId;
    private String genreName;

    //@JsonBackReference
    //@JsonManagedReference
    @ManyToMany(mappedBy = "genres")
    private List<Release> releases = new ArrayList<>();

    public Genre() {
    }

    public Genre(String genreName) {
        this.genreName = genreName;
    }

    public List<Release> getReleases() {
        return Collections.unmodifiableList(releases);
    }
    public void addRelease(Release release) {
        releases.add(release);
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


}
