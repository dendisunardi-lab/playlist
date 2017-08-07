package com.dendi.playlist;

/**
 * Created by dendisunardi on 8/2/17.
 */

public class Song {
    private String artist;
    private String title;
    private String image;
    private String url;

    public Song(String artist, String title, String image, String url) {
        this.artist = artist;
        this.title = title;
        this.image = image;
        this.url = url;
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

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
