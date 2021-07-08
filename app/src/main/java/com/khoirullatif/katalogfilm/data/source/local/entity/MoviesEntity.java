package com.khoirullatif.katalogfilm.data.source.local.entity;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "movieentities")
public class MoviesEntity {
    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "id")
    private String id;

    @ColumnInfo(name = "poster")
    private String poster;

    @ColumnInfo(name = "releasedate")
    private String releaseDate;

    @ColumnInfo(name = "title")
    private String title;

    @ColumnInfo(name = "rating")
    private String rating;

    public MoviesEntity(String id, String title, String poster, String releaseDate, String rating) {
        this.id = id;
        this.poster = poster;
        this.releaseDate = releaseDate;
        this.title = title;
        this.rating = rating;
    }

    public String getPoster() {
        return poster;
    }

    public String getTitle() {
        return title;
    }

    public String getRating() {
        return rating;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    @NonNull
    public String getId() {
        return id;
    }

}

