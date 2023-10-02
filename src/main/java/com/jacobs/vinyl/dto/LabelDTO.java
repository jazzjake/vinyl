package com.jacobs.vinyl.dto;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class LabelDTO {

    private int id;

    private String labelName;

    private List<ReleaseDTO> releases = new ArrayList<>();

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

    public List<ReleaseDTO> getReleases() {
        return releases;
    }

    public void setReleases(List<ReleaseDTO> releases) {
        this.releases = releases;
    }
}
