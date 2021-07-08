package com.khoirullatif.katalogfilm.data.source.local.entity;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

@Entity(tableName = "favoritetvshows")
public class FavoriteTvShowsEntity {
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

    @ColumnInfo(name = "date")
    private String date;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @NonNull
    public String getId() {
        return id;
    }

    public void setId(@NonNull String id) {
        this.id = id;
    }

    public String getPoster() {
        return poster;
    }

    public void setPoster(String poster) {
        this.poster = poster;
    }

    public String getBackdrop() {
        return backdrop;
    }

    public void setBackdrop(String backdrop) {
        this.backdrop = backdrop;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public String getTagline() {
        return tagline;
    }

    public void setTagline(String tagline) {
        this.tagline = tagline;
    }

    public String getOverview() {
        return overview;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }

    @Ignore
    public FavoriteTvShowsEntity() {
    }

    public FavoriteTvShowsEntity(@NonNull String id, String poster, String backdrop, String releaseDate, String title, String rating, String tagline, String overview, String date) {
        this.id = id;
        this.poster = poster;
        this.backdrop = backdrop;
        this.releaseDate = releaseDate;
        this.title = title;
        this.rating = rating;
        this.tagline = tagline;
        this.overview = overview;
        this.date = date;
    }
}
