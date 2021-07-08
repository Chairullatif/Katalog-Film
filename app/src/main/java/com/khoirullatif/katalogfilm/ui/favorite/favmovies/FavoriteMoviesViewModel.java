package com.khoirullatif.katalogfilm.ui.favorite.favmovies;


import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;
import androidx.paging.PagedList;

import com.khoirullatif.katalogfilm.data.CatalogRepository;
import com.khoirullatif.katalogfilm.data.source.local.entity.FavoriteMoviesEntity;


public class FavoriteMoviesViewModel extends ViewModel {
    private final CatalogRepository catalogRepository;

    public FavoriteMoviesViewModel(CatalogRepository catalogRepository) {
        this.catalogRepository = catalogRepository;
    }

    LiveData<PagedList<FavoriteMoviesEntity>> getFavoriteMovies(String sort) {
        return catalogRepository.getFavoriteMovies(sort);
    }
}
