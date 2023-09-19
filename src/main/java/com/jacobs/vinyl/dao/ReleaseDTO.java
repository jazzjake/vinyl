package com.jacobs.vinyl.dao;

public class ReleaseDTO {

    private int id;
    private String artist;
    private String title;
    private String label;
    private String year;

    public ReleaseDTO(int id, String artist, String title, String label, String year) {
        this.id = id;
        this.artist = artist;
        this.title = title;
        this.label = label;
        this.year = year;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public static ReleaseDTO toReleaseDTO(Release release) {
        return new ReleaseDTO(
                release.getId(),
                release.getArtist(),
                release.getTitle(),
                release.getLabel(),
                release.getReleaseYear()
        );
    }

    @Override
    public String toString() {
        return "ReleaseDTO{" +
                "id=" + id +
                ", artist='" + artist + '\'' +
                ", title='" + title + '\'' +
                ", label='" + label + '\'' +
                ", year='" + year + '\'' +
                '}';
    }
}
