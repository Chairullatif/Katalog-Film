package com.khoirullatif.katalogfilm.data.source.local;

import androidx.lifecycle.LiveData;
import androidx.paging.DataSource;
import androidx.sqlite.db.SimpleSQLiteQuery;

import com.khoirullatif.katalogfilm.data.source.local.entity.DetailMoviesEntity;
import com.khoirullatif.katalogfilm.data.source.local.entity.DetailTvShowsEntity;
import com.khoirullatif.katalogfilm.data.source.local.entity.FavoriteMoviesEntity;
import com.khoirullatif.katalogfilm.data.source.local.entity.FavoriteTvShowsEntity;
import com.khoirullatif.katalogfilm.data.source.local.entity.MoviesEntity;
import com.khoirullatif.katalogfilm.data.source.local.entity.TvShowsEntity;
import com.khoirullatif.katalogfilm.data.source.local.room.CatalogDao;
import com.khoirullatif.katalogfilm.utils.SortUtils;

import java.util.ArrayList;
import java.util.List;

public class LocalDataSource {

    private static LocalDataSource INSTANCE;
    private final CatalogDao mCatalogDao;

    private LocalDataSource(CatalogDao catalogDao) {
        this.mCatalogDao = catalogDao;
    }

    public static LocalDataSource getInstance(CatalogDao catalogDao) {
        if (INSTANCE == null) {
            INSTANCE = new LocalDataSource(catalogDao);
        }
        return INSTANCE;
    }

    public void insertFavoriteMovies(final FavoriteMoviesEntity favoriteMoviesEntity) {
        mCatalogDao.insertFavoriteMovies(favoriteMoviesEntity);
    }

    public void deleteFavoriteMovies(final FavoriteMoviesEntity favoriteMoviesEntity) {
        mCatalogDao.deleteFavoriteMovies(favoriteMoviesEntity);
    }

    public DataSource.Factory<Integer, FavoriteMoviesEntity> getFavoriteMovies(String sort) {
        SimpleSQLiteQuery query = SortUtils.getMoviesSortedQuery(sort);
        return mCatalogDao.getFavoriteMovies(query);
    }

    public DataSource.Factory<Integer, FavoriteMoviesEntity> findMovieById(String id) {
        return mCatalogDao.findMovieById(id);
    }

    public void insertFavoriteTvShows(final FavoriteTvShowsEntity favoriteTvShowsEntity) {
        mCatalogDao.insertFavoriteTvShows(favoriteTvShowsEntity);
    }

    public void deleteFavoriteTvShows(final FavoriteTvShowsEntity favoriteTvShowsEntity) {
        mCatalogDao.deleteFavoriteTvShows(favoriteTvShowsEntity);
    }

    public DataSource.Factory<Integer, FavoriteTvShowsEntity> getFavoriteTvShows(String sort) {
        SimpleSQLiteQuery query = SortUtils.getTvShowsSortedQuery(sort);
        return mCatalogDao.getFavoriteTvShows(query);
    }

    public DataSource.Factory<Integer, FavoriteTvShowsEntity> findTvShowById(String id) {
        return mCatalogDao.findTvShowById(id);
    }

    public void insertMovies(final ArrayList<MoviesEntity> moviesEntity) {
        mCatalogDao.insertMovies(moviesEntity);
    }

    public LiveData<List<MoviesEntity>> getMovies() {
        return mCatalogDao.getMoives();
    }

    public void insertTvShows(final ArrayList<TvShowsEntity> tvShowsEntity) {
        mCatalogDao.insertTvShows(tvShowsEntity);
    }

    public LiveData<List<TvShowsEntity>> getTvShows() {
        return mCatalogDao.getTvShows();
    }

    public void insertDetailMovie(DetailMoviesEntity detailMoviesEntity) {
        mCatalogDao.insertDetailMovie(detailMoviesEntity);
    }

    public LiveData<DetailMoviesEntity> getDetailMovies(String movieId) {
        return mCatalogDao.getDetailMovie(movieId);
    }

    public void insertDetailTvShow(DetailTvShowsEntity detailTvShowsEntity) {
        mCatalogDao.insertDetailTvShow(detailTvShowsEntity);
    }

    public LiveData<DetailTvShowsEntity> getDetailTvShow(String tvShowId) {
        return mCatalogDao.getDetailTvShow(tvShowId);
    }
}
