package com.khoirullatif.katalogfilm.data.source.local.entity;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "tvshowentities")
public class TvShowsEntity {
    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "idTv")
    private String idTv;

    @ColumnInfo(name = "posterTv")
    private String posterTv;

    @ColumnInfo(name = "releaseDateTv")
    private String releaseDateTv;

    @ColumnInfo(name = "titleTv")
    private String titleTv;

    @ColumnInfo(name = "ratingTv")
    private String ratingTv;

    public TvShowsEntity(String idTv, String titleTv, String posterTv, String releaseDateTv, String ratingTv) {
        this.idTv = idTv;
        this.titleTv = titleTv;
        this.posterTv = posterTv;
        this.releaseDateTv = releaseDateTv;
        this.ratingTv = ratingTv;
    }

    @NonNull
    public String getIdTv() {
        return idTv;
    }

    public String getPosterTv() {
        return posterTv;
    }

    public String getReleaseDateTv() {
        return releaseDateTv;
    }

    public String getTitleTv() {
        return titleTv;
    }

    public String getRatingTv() {
        return ratingTv;
    }

}
