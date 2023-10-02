package com.jacobs.vinyl.repository;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Entity
public class Label {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "label_id")
    private int id;

    private String labelName;

    @OneToMany(mappedBy = "label")
    public List<Release> releases = new ArrayList<>();

    public Label() {
    }

    public List<Release> getReleases() {
        return Collections.unmodifiableList(releases);
    }

    public void addRelease(Release release) {
        releases.add(release);
    }

    public Label(String labelName) {
        this.labelName = labelName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLabelName() {
        return labelName;
    }

    public void setLabelName(String labelName) {
        this.labelName = labelName;
    }
}
