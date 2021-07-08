package com.khoirullatif.katalogfilm.ui.favorite.favtvshows;


import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;
import androidx.paging.PagedList;

import com.khoirullatif.katalogfilm.data.CatalogRepository;
import com.khoirullatif.katalogfilm.data.source.local.entity.FavoriteTvShowsEntity;

public class FavoriteTvShowsViewModel extends ViewModel {

    private final CatalogRepository catalogRepository;

    public FavoriteTvShowsViewModel(CatalogRepository catalogRepository) {
        this.catalogRepository = catalogRepository;
    }

    LiveData<PagedList<FavoriteTvShowsEntity>> getFavoriteTvShows(String sort) {
        return catalogRepository.getFavoriteTvShows(sort);
    }
}
