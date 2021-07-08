package com.khoirullatif.katalogfilm.data.source.remote.response;

public class DetailTvShowsResponse {
    private final String id;
    private final String poster;
    private final String backdrop;
    private final String releaseDate;
    private final String title;
    private final String rating;
    private final String tagline;
    private final String overview;

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

    public String getBackdrop() {
        return backdrop;
    }

    public String getOverview() {
        return overview;
    }

    public String getTagline() {
        return tagline;
    }

    public String getId() {
        return id;
    }

    public DetailTvShowsResponse(String id, String poster, String backdrop, String releaseDate, String title, String rating, String tagline, String overview) {
        this.id = id;
        this.poster = poster;
        this.backdrop = backdrop;
        this.releaseDate = releaseDate;
        this.title = title;
        this.rating = rating;
        this.tagline = tagline;
        this.overview = overview;
    }
}
