package com.khoirullatif.katalogfilm.ui.favorite.favmovies;

import com.khoirullatif.katalogfilm.data.source.local.entity.FavoriteMoviesEntity;

interface FavoriteMoviesFragmentCallback {
    void onFloatingActionClick(FavoriteMoviesEntity favoriteMoviesEntity);

    void onItemClicked(FavoriteMoviesEntity data);
}
