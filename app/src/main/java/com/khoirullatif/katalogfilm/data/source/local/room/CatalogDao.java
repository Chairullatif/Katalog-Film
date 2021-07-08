package com.khoirullatif.katalogfilm.data.source.local.room;

import androidx.lifecycle.LiveData;
import androidx.paging.DataSource;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.RawQuery;
import androidx.sqlite.db.SupportSQLiteQuery;

import com.khoirullatif.katalogfilm.data.source.local.entity.DetailMoviesEntity;
import com.khoirullatif.katalogfilm.data.source.local.entity.DetailTvShowsEntity;
import com.khoirullatif.katalogfilm.data.source.local.entity.FavoriteMoviesEntity;
import com.khoirullatif.katalogfilm.data.source.local.entity.FavoriteTvShowsEntity;
import com.khoirullatif.katalogfilm.data.source.local.entity.MoviesEntity;
import com.khoirullatif.katalogfilm.data.source.local.entity.TvShowsEntity;

import java.util.ArrayList;
import java.util.List;


@Dao
public interface CatalogDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insertFavoriteMovies(FavoriteMoviesEntity favoriteMoviesEntity);

    @Delete()
    void deleteFavoriteMovies(FavoriteMoviesEntity favoriteMoviesEntity);

    @RawQuery(observedEntities = FavoriteMoviesEntity.class)
    DataSource.Factory<Integer, FavoriteMoviesEntity> getFavoriteMovies(SupportSQLiteQuery query);

    @Query("SELECT * FROM favoritemovies WHERE id LIKE :id")
    DataSource.Factory<Integer, FavoriteMoviesEntity> findMovieById(String id);

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insertFavoriteTvShows(FavoriteTvShowsEntity favoriteTvShowsEntity);

    @Delete()
    void deleteFavoriteTvShows(FavoriteTvShowsEntity favoriteTvShowsEntity);

    @RawQuery(observedEntities = FavoriteTvShowsEntity.class)
    DataSource.Factory<Integer, FavoriteTvShowsEntity> getFavoriteTvShows(SupportSQLiteQuery query);

    @Query("SELECT * FROM favoritetvshows WHERE id LIKE :id")
    DataSource.Factory<Integer, FavoriteTvShowsEntity> findTvShowById(String id);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertMovies(ArrayList<MoviesEntity> moviesEntity);

    @Query("SELECT * FROM movieentities")
    LiveData<List<MoviesEntity>> getMoives();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertTvShows(ArrayList<TvShowsEntity> tvShowsEntity);

    @Query("SELECT * FROM tvshowentities")
    LiveData<List<TvShowsEntity>> getTvShows();

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insertDetailMovie(DetailMoviesEntity detailMoviesEntity);

    @Query("SELECT * FROM detailMovies WHERE id LIKE :id")
    LiveData<DetailMoviesEntity> getDetailMovie(String id);

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insertDetailTvShow(DetailTvShowsEntity detailTvShowsEntity);

    @Query("SELECT * FROM detailTvShows WHERE id LIKE :id")
    LiveData<DetailTvShowsEntity> getDetailTvShow(String id);

}
