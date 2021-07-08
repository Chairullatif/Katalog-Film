package com.khoirullatif.katalogfilm.utils;

import androidx.sqlite.db.SimpleSQLiteQuery;

public class SortUtils {
    public static final String NEWEST = "Newest";
    public static final String OLDEST = "Oldest";
    public static final String RANDOM = "Random";

    public static SimpleSQLiteQuery getMoviesSortedQuery(String filter) {
        StringBuilder simpleQuery = new StringBuilder().append("SELECT * FROM favoritemovies ");
        switch (filter) {
            case NEWEST:
                simpleQuery.append("ORDER BY date DESC");
                break;
            case OLDEST:
                simpleQuery.append("ORDER BY date ASC");
                break;
            case RANDOM:
                simpleQuery.append("ORDER BY RANDOM()");
                break;
        }
        return new SimpleSQLiteQuery(simpleQuery.toString());
    }

    public static SimpleSQLiteQuery getTvShowsSortedQuery(String filter) {
        StringBuilder simpleQuery = new StringBuilder().append("SELECT * FROM favoritetvshows ");
        switch (filter) {
            case NEWEST:
                simpleQuery.append("ORDER BY date DESC");
                break;
            case OLDEST:
                simpleQuery.append("ORDER BY date ASC");
                break;
            case RANDOM:
                simpleQuery.append("ORDER BY RANDOM()");
                break;
        }
        return new SimpleSQLiteQuery(simpleQuery.toString());
    }
}
