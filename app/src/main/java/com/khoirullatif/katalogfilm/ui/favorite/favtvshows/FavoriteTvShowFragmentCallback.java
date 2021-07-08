package com.khoirullatif.katalogfilm.ui.favorite.favtvshows;

import com.khoirullatif.katalogfilm.data.source.local.entity.FavoriteTvShowsEntity;

interface FavoriteTvShowFragmentCallback {
    void onFloatingActionClick(FavoriteTvShowsEntity favoriteTvShowsEntity);

    void onItemClicked(FavoriteTvShowsEntity data);
}
