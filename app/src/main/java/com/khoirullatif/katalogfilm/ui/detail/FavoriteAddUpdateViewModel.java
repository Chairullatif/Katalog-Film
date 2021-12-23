package com.khoirullatif.katalogfilm.ui.detail;


import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;
import androidx.paging.PagedList;

import com.khoirullatif.katalogfilm.data.CatalogRepository;
import com.khoirullatif.katalogfilm.data.source.local.entity.FavoriteMoviesEntity;
import com.khoirullatif.katalogfilm.data.source.local.entity.FavoriteTvShowsEntity;

public class FavoriteAddUpdateViewModel extends ViewModel {
    private final CatalogRepository catalogRepository;

    public FavoriteAddUpdateViewModel(CatalogRepository mCatalogRepository) {
        this.catalogRepository = mCatalogRepository;
    }

    public void insertFavoriteMovies(FavoriteMoviesEntity favoriteMoviesEntity) {
        catalogRepository.insertFavoriteMovies(favoriteMoviesEntity);
    }

    public LiveData<PagedList<FavoriteMoviesEntity>> findMovieById(String id) {
        return catalogRepository.findMovieById(id);
    }

    public void deleteFavoriteMovies(FavoriteMoviesEntity favoriteMoviesEntity) {
        catalogRepository.deleteFavoriteMovies(favoriteMoviesEntity);
    }

    public void deleteFavoriteMoviesById(String id) {
        catalogRepository.deleteFavoriteMoviewById(id);
    }

    public void insertFavoriteTvShows(FavoriteTvShowsEntity favoriteTvShowsEntity) {
        catalogRepository.insertFavoriteTvShows(favoriteTvShowsEntity);
    }

    public LiveData<PagedList<FavoriteTvShowsEntity>> findTvShowById(String id) {
        return catalogRepository.findTvShowById(id);
    }

    public void deleteFavoriteTvShows(FavoriteTvShowsEntity favoriteTvShowsEntity) {
        catalogRepository.deleteFavoriteTvShows(favoriteTvShowsEntity);
    }

    public void deleteFavoriteTvShowsById(String id) {
        catalogRepository.deleteFavoriteTvShowsById(id);
    }
}
