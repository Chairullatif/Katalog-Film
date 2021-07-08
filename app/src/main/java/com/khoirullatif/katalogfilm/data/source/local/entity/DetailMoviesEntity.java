package com.khoirullatif.katalogfilm.data.source.local.entity;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "detailMovies")
public class DetailMoviesEntity {
    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "id")
    private String id;

    @ColumnInfo(name = "poster")
    private String poster;

    @ColumnInfo(name = "backdrop")
    private String backdrop;

    @ColumnInfo(name = "releaseDate")
    private String releaseDate;

    @ColumnInfo(name = "title")
    private String title;

    @ColumnInfo(name = "rating")
    private String rating;

    @ColumnInfo(name = "tagline")
    private String tagline;

    @ColumnInfo(name = "overview")
    private String overview;

    public String getPoster() {
        return poster;
    }

    public DetailMoviesEntity(String id, String poster, String backdrop, String releaseDate, String title, String rating, String tagline, String overview) {
        this.id = id;
        this.poster = poster;
        this.backdrop = backdrop;
        this.releaseDate = releaseDate;
        this.title = title;
        this.rating = rating;
        this.tagline = tagline;
        this.overview = overview;
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

    @NonNull
    public String getId() {
        return id;
    }
}
