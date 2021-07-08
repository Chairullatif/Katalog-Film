package com.khoirullatif.katalogfilm.data;

import androidx.lifecycle.LiveData;
import androidx.paging.PagedList;

import com.khoirullatif.katalogfilm.data.source.local.entity.DetailMoviesEntity;
import com.khoirullatif.katalogfilm.data.source.local.entity.DetailTvShowsEntity;
import com.khoirullatif.katalogfilm.data.source.local.entity.FavoriteMoviesEntity;
import com.khoirullatif.katalogfilm.data.source.local.entity.FavoriteTvShowsEntity;
import com.khoirullatif.katalogfilm.data.source.local.entity.MoviesEntity;
import com.khoirullatif.katalogfilm.data.source.local.entity.TvShowsEntity;
import com.khoirullatif.katalogfilm.vo.Resource;

import java.util.List;

public interface CatalogDataSource {

    void insertFavoriteMovies(FavoriteMoviesEntity favoriteMoviesEntity);

    void deleteFavoriteMovies(FavoriteMoviesEntity favoriteMoviesEntity);

    LiveData<PagedList<FavoriteMoviesEntity>> getFavoriteMovies(String sort);

    LiveData<PagedList<FavoriteMoviesEntity>> findMovieById(String id);

    void insertFavoriteTvShows(FavoriteTvShowsEntity favoriteTvShowsEntity);

    void deleteFavoriteTvShows(FavoriteTvShowsEntity favoriteTvShowsEntity);

    LiveData<PagedList<FavoriteTvShowsEntity>> getFavoriteTvShows(String sort);

    LiveData<PagedList<FavoriteTvShowsEntity>> findTvShowById(String id);

    LiveData<Resource<List<MoviesEntity>>> getMovies();

    LiveData<Resource<List<TvShowsEntity>>> getTvShows();

    LiveData<Resource<DetailMoviesEntity>> getDetailMovies(String movieId);

    LiveData<Resource<DetailTvShowsEntity>> getDetailTvShows(String tvShowId);

}
