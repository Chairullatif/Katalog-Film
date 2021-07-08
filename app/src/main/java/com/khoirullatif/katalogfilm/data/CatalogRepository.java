package com.khoirullatif.katalogfilm.data;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.paging.LivePagedListBuilder;
import androidx.paging.PagedList;

import com.khoirullatif.katalogfilm.data.source.local.LocalDataSource;
import com.khoirullatif.katalogfilm.data.source.local.entity.DetailMoviesEntity;
import com.khoirullatif.katalogfilm.data.source.local.entity.DetailTvShowsEntity;
import com.khoirullatif.katalogfilm.data.source.local.entity.FavoriteMoviesEntity;
import com.khoirullatif.katalogfilm.data.source.local.entity.FavoriteTvShowsEntity;
import com.khoirullatif.katalogfilm.data.source.local.entity.MoviesEntity;
import com.khoirullatif.katalogfilm.data.source.local.entity.TvShowsEntity;
import com.khoirullatif.katalogfilm.data.source.remote.ApiResponse;
import com.khoirullatif.katalogfilm.data.source.remote.RemoteDataSource;
import com.khoirullatif.katalogfilm.data.source.remote.response.DetailMoviesResponse;
import com.khoirullatif.katalogfilm.data.source.remote.response.DetailTvShowsResponse;
import com.khoirullatif.katalogfilm.data.source.remote.response.MoviesResponse;
import com.khoirullatif.katalogfilm.data.source.remote.response.TvShowsResponse;
import com.khoirullatif.katalogfilm.utils.AppExecutors;
import com.khoirullatif.katalogfilm.vo.Resource;

import java.util.ArrayList;
import java.util.List;

public class CatalogRepository implements CatalogDataSource{

    private volatile static CatalogRepository INSTANCE = null;

    private final RemoteDataSource remoteDataSource;

    private final LocalDataSource localDataSource;
    private final AppExecutors appExecutors;

    private CatalogRepository(@NonNull RemoteDataSource remoteDataSource, @NonNull LocalDataSource localDataSource, AppExecutors appExecutors) {
        this.remoteDataSource = remoteDataSource;
        this.localDataSource = localDataSource;
        this.appExecutors = appExecutors;
    }

    public static CatalogRepository getInstance(RemoteDataSource remoteDataSource, LocalDataSource localDataSource, AppExecutors appExecutors) {
        if (INSTANCE == null) {
            synchronized (CatalogRepository.class) {
                if (INSTANCE == null) {
                    INSTANCE = new CatalogRepository(remoteDataSource, localDataSource, appExecutors);
                }
            }
        }
        return INSTANCE;
    }

    @Override
    public void insertFavoriteMovies(final FavoriteMoviesEntity favoriteMoviesEntity) {
        appExecutors.diskIO().execute(() -> localDataSource.insertFavoriteMovies(favoriteMoviesEntity));

    }

    @Override
    public void deleteFavoriteMovies(final FavoriteMoviesEntity favoriteMoviesEntity) {
        appExecutors.diskIO().execute(() -> localDataSource.deleteFavoriteMovies(favoriteMoviesEntity));
    }

    @Override
    public LiveData<PagedList<FavoriteMoviesEntity>> getFavoriteMovies(String sort) {
        PagedList.Config config = new PagedList.Config.Builder()
                .setEnablePlaceholders(false)
                .setInitialLoadSizeHint(4)
                .setPageSize(4)
                .build();
        return new LivePagedListBuilder<>(localDataSource.getFavoriteMovies(sort), config).build();
    }

    @Override
    public LiveData<PagedList<FavoriteMoviesEntity>> findMovieById(String id) {
        PagedList.Config config = new PagedList.Config.Builder()
                .setEnablePlaceholders(false)
                .setInitialLoadSizeHint(4)
                .setPageSize(4)
                .build();
        return new LivePagedListBuilder<>(localDataSource.findMovieById(id), config).build();
    }

    @Override
    public void insertFavoriteTvShows(final FavoriteTvShowsEntity favoriteTvShowsEntity) {
        appExecutors.diskIO().execute(() -> localDataSource.insertFavoriteTvShows(favoriteTvShowsEntity));
    }

    @Override
    public void deleteFavoriteTvShows(final FavoriteTvShowsEntity favoriteTvShowsEntity) {
        appExecutors.diskIO().execute(() -> localDataSource.deleteFavoriteTvShows(favoriteTvShowsEntity));
    }

    @Override
    public LiveData<PagedList<FavoriteTvShowsEntity>> getFavoriteTvShows(String sort) {
        PagedList.Config config = new PagedList.Config.Builder()
                .setEnablePlaceholders(false)
                .setInitialLoadSizeHint(4)
                .setPageSize(4)
                .build();
        return new LivePagedListBuilder<>(localDataSource.getFavoriteTvShows(sort), config).build();
    }

    @Override
    public LiveData<PagedList<FavoriteTvShowsEntity>> findTvShowById(String id) {
        PagedList.Config config = new PagedList.Config.Builder()
                .setEnablePlaceholders(false)
                .setInitialLoadSizeHint(4)
                .setPageSize(4)
                .build();
        return new LivePagedListBuilder<>(localDataSource.findTvShowById(id), config).build();
    }

    @Override
    public LiveData<Resource<List<MoviesEntity>>> getMovies() {

        return new NetworkBoundResource<List<MoviesEntity>, List<MoviesResponse>>(appExecutors){

            @Override
            protected LiveData<List<MoviesEntity>> loadFromDB() {
                return localDataSource.getMovies();
            }

            @Override
            protected Boolean shouldFetch(List<MoviesEntity> data) {
                return (data == null) || (data.size() == 0);
            }

            @Override
            protected LiveData<ApiResponse<List<MoviesResponse>>> createCall() {
                return remoteDataSource.getMovies();
            }

            @Override
            protected void saveCallResult(List<MoviesResponse> moviesResponses) {
                ArrayList<MoviesEntity> movieList = new ArrayList<>();
                for (MoviesResponse response : moviesResponses) {
                    MoviesEntity movie = new MoviesEntity(
                            response.getId(),
                            response.getTitle(),
                            response.getPoster(),
                            response.getReleaseDate(),
                            response.getRating());

                    movieList.add(movie);
                }

                localDataSource.insertMovies(movieList);
            }
        }.asLiveData();
    }

    @Override
    public LiveData<Resource<List<TvShowsEntity>>> getTvShows() {

        return new NetworkBoundResource<List<TvShowsEntity>, List<TvShowsResponse>>(appExecutors){

            @Override
            protected LiveData<List<TvShowsEntity>> loadFromDB() {
                return localDataSource.getTvShows();
            }

            @Override
            protected Boolean shouldFetch(List<TvShowsEntity> data) {
                return (data == null) || (data.size() == 0);
            }

            @Override
            protected LiveData<ApiResponse<List<TvShowsResponse>>> createCall() {
                return remoteDataSource.getTvShows();
            }

            @Override
            protected void saveCallResult(List<TvShowsResponse> tvShowsResponses) {
                ArrayList<TvShowsEntity> tvShowsList = new ArrayList<>();
                for (TvShowsResponse response : tvShowsResponses) {
                    TvShowsEntity tvShow = new TvShowsEntity(response.getIdTv(),
                            response.getTitleTv(),
                            response.getPosterTv(),
                            response.getReleaseDateTv(),
                            response.getRatingTv());

                    tvShowsList.add(tvShow);
                }
                localDataSource.insertTvShows(tvShowsList);
            }
        }.asLiveData();
    }

    @Override
    public LiveData<Resource<DetailMoviesEntity>> getDetailMovies(String movieId) {
        return new NetworkBoundResource<DetailMoviesEntity, DetailMoviesResponse>(appExecutors){

            @Override
            protected LiveData<DetailMoviesEntity> loadFromDB() {
                return localDataSource.getDetailMovies(movieId);
            }

            @Override
            protected Boolean shouldFetch(DetailMoviesEntity data) {
                return (data == null);
            }

            @Override
            protected LiveData<ApiResponse<DetailMoviesResponse>> createCall() {
                return remoteDataSource.getDetailMovie(movieId);
            }

            @Override
            protected void saveCallResult(DetailMoviesResponse response) {
                    DetailMoviesEntity detailMovie = new DetailMoviesEntity(response.getId(),
                            response.getPoster(),
                            response.getBackdrop(),
                            response.getReleaseDate(),
                            response.getTitle(),
                            response.getRating(),
                            response.getTagline(),
                            response.getOverview());

                localDataSource.insertDetailMovie(detailMovie);
            }
        }.asLiveData();
    }

    @Override
    public LiveData<Resource<DetailTvShowsEntity>> getDetailTvShows(String tvShowId) {
        return new NetworkBoundResource<DetailTvShowsEntity, DetailTvShowsResponse>(appExecutors) {

            @Override
            protected LiveData<DetailTvShowsEntity> loadFromDB() {
                return localDataSource.getDetailTvShow(tvShowId);
            }

            @Override
            protected Boolean shouldFetch(DetailTvShowsEntity data) {
                return (data == null);
            }

            @Override
            protected LiveData<ApiResponse<DetailTvShowsResponse>> createCall() {
                return remoteDataSource.getDetailTvShow(tvShowId);
            }

            @Override
            protected void saveCallResult(DetailTvShowsResponse response) {

                    DetailTvShowsEntity detailMovie = new DetailTvShowsEntity(response.getId(),
                            response.getPoster(),
                            response.getBackdrop(),
                            response.getReleaseDate(),
                            response.getTitle(),
                            response.getRating(),
                            response.getTagline(),
                            response.getOverview());

                localDataSource.insertDetailTvShow(detailMovie);
            }
        }.asLiveData();

    }
}
