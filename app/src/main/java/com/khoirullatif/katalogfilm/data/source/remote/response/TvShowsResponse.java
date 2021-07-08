package com.khoirullatif.katalogfilm.data.source.remote.response;

public class TvShowsResponse {
    private final String idTv;
    private final String posterTv;
    private final String releaseDateTv;
    private final String titleTv;
    private final String ratingTv;


    public TvShowsResponse(String idTv, String titleTv, String posterTv, String releaseDateTv, String ratingTv) {
        this.idTv = idTv;
        this.titleTv = titleTv;
        this.posterTv = posterTv;
        this.releaseDateTv = releaseDateTv;
        this.ratingTv = ratingTv;
    }

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
