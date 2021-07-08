package com.khoirullatif.katalogfilm.data.source.remote.response;

public class MoviesResponse {
    private String id;
    private String poster;
    private String releaseDate;
    private String title;
    private String rating;

    public MoviesResponse(String id, String title, String poster, String releaseDate, String rating) {
        this.id = id;
        this.poster = poster;
        this.releaseDate = releaseDate;
        this.title = title;
        this.rating = rating;
    }

    public String getId() {
        return id;
    }

    public String getPoster() {
        return poster;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public String getTitle() {
        return title;
    }

    public String getRating() {
        return rating;
    }

}
