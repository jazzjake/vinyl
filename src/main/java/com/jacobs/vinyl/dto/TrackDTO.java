package com.jacobs.vinyl.dto;

import com.fasterxml.jackson.annotation.JsonBackReference;

public class TrackDTO {
    private int trackId;
    private String trackTitle;
    private String side;
    private int trackNumber;
    private String trackLength;
    //@JsonManagedReference
    @JsonBackReference
    private ReleaseDTO release;

    public TrackDTO() {
    }

    public int getTrackId() {
        return trackId;
    }

    public void setTrackId(int trackId) {
        this.trackId = trackId;
    }

    public String getTrackTitle() {
        return trackTitle;
    }

    public void setTrackTitle(String trackTitle) {
        this.trackTitle = trackTitle;
    }

    public String getSide() {
        return side;
    }

    public void setSide(String side) {
        this.side = side;
    }

    public int getTrackNumber() {
        return trackNumber;
    }

    public void setTrackNumber(int trackNumber) {
        this.trackNumber = trackNumber;
    }

    public String getTrackLength() {
        return trackLength;
    }

    public void setTrackLength(String trackLength) {
        this.trackLength = trackLength;
    }

    public ReleaseDTO getRelease() {
        return release;
    }

    public void setRelease(ReleaseDTO release) {
        this.release = release;
    }
}
