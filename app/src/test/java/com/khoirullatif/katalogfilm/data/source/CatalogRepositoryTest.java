package com.khoirullatif.katalogfilm.data.source;



import androidx.arch.core.executor.testing.InstantTaskExecutorRule;
import androidx.lifecycle.MutableLiveData;
import androidx.paging.DataSource;
import androidx.paging.PagedList;


import com.khoirullatif.katalogfilm.data.source.local.LocalDataSource;
import com.khoirullatif.katalogfilm.data.source.local.entity.DetailMoviesEntity;
import com.khoirullatif.katalogfilm.data.source.local.entity.DetailTvShowsEntity;
import com.khoirullatif.katalogfilm.data.source.local.entity.FavoriteMoviesEntity;
import com.khoirullatif.katalogfilm.data.source.local.entity.FavoriteTvShowsEntity;
import com.khoirullatif.katalogfilm.data.source.local.entity.MoviesEntity;
import com.khoirullatif.katalogfilm.data.source.local.entity.TvShowsEntity;
import com.khoirullatif.katalogfilm.data.source.remote.RemoteDataSource;
import com.khoirullatif.katalogfilm.data.source.remote.response.DetailMoviesResponse;
import com.khoirullatif.katalogfilm.data.source.remote.response.DetailTvShowsResponse;
import com.khoirullatif.katalogfilm.data.source.remote.response.MoviesResponse;
import com.khoirullatif.katalogfilm.data.source.remote.response.TvShowsResponse;


import com.khoirullatif.katalogfilm.utils.AppExecutors;
import com.khoirullatif.katalogfilm.utils.DataDummy;
import com.khoirullatif.katalogfilm.utils.LiveDataTestUtil;
import com.khoirullatif.katalogfilm.utils.PagedListUtil;
import com.khoirullatif.katalogfilm.utils.SortUtils;
import com.khoirullatif.katalogfilm.vo.Resource;


import org.junit.Rule;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class CatalogRepositoryTest {

    @Rule
    public InstantTaskExecutorRule instantTaskExecutorRule = new InstantTaskExecutorRule();

    private final RemoteDataSource remote = mock(RemoteDataSource.class);
    private final LocalDataSource local = mock(LocalDataSource.class);
    private final AppExecutors appExecutors = mock(AppExecutors.class);
    private final FakeCatalogRepository catalogRepository = new FakeCatalogRepository(remote, local, appExecutors);

    private final ArrayList<MoviesResponse> moviesResponses = (ArrayList<MoviesResponse>) DataDummy.generateRemoteDummyMovies();
    private final String movieId = moviesResponses.get(0).getId();
    private final ArrayList<TvShowsResponse> tvShowsResponses = (ArrayList<TvShowsResponse>) DataDummy.generateRemoteDummyTvShows();
    private final String tvShowId = tvShowsResponses.get(0).getIdTv();

    private final ArrayList<FavoriteMoviesEntity> favMoviesResponse = (ArrayList<FavoriteMoviesEntity>) DataDummy.generateRemoteFavoriteDummyMovies();
    private final ArrayList<FavoriteTvShowsEntity> favTvShowsResponse = (ArrayList<FavoriteTvShowsEntity>) DataDummy.generateRemoteFavoriteDummyTvShows();

    private final String sort = SortUtils.NEWEST;
    private final DetailMoviesResponse detailMoviesResponse = DataDummy.generateRemoteDummyDetailMovies();
    private final DetailTvShowsResponse detailTvShowsResponse = DataDummy.generateRemoteDummyDetailTvShows();

    @Test
    public void getFavoriteMovies() {
        DataSource.Factory<Integer, FavoriteMoviesEntity> dataSourceFactory = mock(DataSource.Factory.class);
        when(local.getFavoriteMovies(sort)).thenReturn(dataSourceFactory);
        catalogRepository.getFavoriteMovies(sort);

        Resource<PagedList<FavoriteMoviesEntity>> favoriteMovies = Resource.success(PagedListUtil.mockPagedList(DataDummy.generateFavoriteDummyMovies()));
        verify(local).getFavoriteMovies(sort);
        assertNotNull(favoriteMovies.data);
        assertEquals(favMoviesResponse.size(), favoriteMovies.data.size());
    }

    @Test
    public void findMovieById() {
        DataSource.Factory<Integer, FavoriteMoviesEntity> dataSourceFactory = mock(DataSource.Factory.class);
        when(local.findMovieById(movieId)).thenReturn(dataSourceFactory);
        catalogRepository.findMovieById(movieId);

        Resource<PagedList<FavoriteMoviesEntity>> favoriteMovies = Resource.success(PagedListUtil.mockPagedList(DataDummy.generateFavoriteDummyMovies()));
        verify(local).findMovieById(movieId);
        assertNotNull(favoriteMovies.data);
        assertEquals(favMoviesResponse.size(), favoriteMovies.data.size());
    }

    @Test
    public void getFavoriteTvShows() {
        DataSource.Factory<Integer, FavoriteTvShowsEntity> dataSourceFactory = mock(DataSource.Factory.class);
        when(local.getFavoriteTvShows(sort)).thenReturn(dataSourceFactory);
        catalogRepository.getFavoriteTvShows(sort);

        Resource<PagedList<FavoriteTvShowsEntity>> favoriteTvShows = Resource.success(PagedListUtil.mockPagedList(DataDummy.generateFavoriteDummyTvShows()));
        verify(local).getFavoriteTvShows(sort);
        assertNotNull(favoriteTvShows.data);
        assertEquals(favTvShowsResponse.size(), favoriteTvShows.data.size());
    }

    @Test
    public void findTvShowById() {
        DataSource.Factory<Integer, FavoriteTvShowsEntity> dataSourceFactory = mock(DataSource.Factory.class);
        when(local.findTvShowById(tvShowId)).thenReturn(dataSourceFactory);
        catalogRepository.findTvShowById(tvShowId);

        Resource<PagedList<FavoriteTvShowsEntity>> favoriteTvShows = Resource.success(PagedListUtil.mockPagedList(DataDummy.generateFavoriteDummyTvShows()));
        verify(local).findTvShowById(tvShowId);
        assertNotNull(favoriteTvShows.data);
        assertEquals(favTvShowsResponse.size(), favoriteTvShows.data.size());
    }

    @Test
    public void getMovies() {
        MutableLiveData<List<MoviesEntity>> dummyMovies = new MutableLiveData<>();
        dummyMovies.setValue(DataDummy.generateDummyMovies());
        when(local.getMovies()).thenReturn(dummyMovies);

        Resource<List<MoviesEntity>> moviesEntities = LiveDataTestUtil.getValue(catalogRepository.getMovies());
        verify(local).getMovies();
        assertNotNull(moviesEntities.data);
        assertEquals(moviesResponses.size(), moviesEntities.data.size());
    }

    @Test
    public void getTvShows() {
        MutableLiveData<List<TvShowsEntity>> dummyTvShows = new MutableLiveData<>();
        dummyTvShows.setValue(DataDummy.generateDummyTvShows());
        when(local.getTvShows()).thenReturn(dummyTvShows);

        Resource<List<TvShowsEntity>> tvShowsEntities = LiveDataTestUtil.getValue(catalogRepository.getTvShows());
        verify(local).getTvShows();
        assertNotNull(tvShowsEntities.data);
        assertEquals(tvShowsResponses.size(), tvShowsEntities.data.size());
    }

    @Test
    public void getDetailMovies() {
        MutableLiveData<DetailMoviesEntity> dummyDetailMovie = new MutableLiveData<>();
        dummyDetailMovie.setValue(DataDummy.generateDummyDetailMovies());
        when(local.getDetailMovies(movieId)).thenReturn(dummyDetailMovie);

        Resource<DetailMoviesEntity> detailMoviesEntity = LiveDataTestUtil.getValue(catalogRepository.getDetailMovies(movieId));
        verify(local).getDetailMovies(movieId);
        assertNotNull(detailMoviesEntity.data);
        assertEquals(detailMoviesResponse.getId(), detailMoviesEntity.data.getId());
        assertEquals(detailMoviesResponse.getBackdrop(), detailMoviesEntity.data.getBackdrop());
        assertEquals(detailMoviesResponse.getOverview(), detailMoviesEntity.data.getOverview());
        assertEquals(detailMoviesResponse.getPoster(), detailMoviesEntity.data.getPoster());
        assertEquals(detailMoviesResponse.getRating(), detailMoviesEntity.data.getRating());
        assertEquals(detailMoviesResponse.getReleaseDate(), detailMoviesEntity.data.getReleaseDate());
        assertEquals(detailMoviesResponse.getTagline(), detailMoviesEntity.data.getTagline());
        assertEquals(detailMoviesResponse.getTitle(), detailMoviesEntity.data.getTitle());
    }

    @Test
    public void getDetailTvShows() {
        MutableLiveData<DetailTvShowsEntity> dummyDetailTvShow = new MutableLiveData<>();
        dummyDetailTvShow.setValue(DataDummy.generateDummyDetailTvShows());
        when(local.getDetailTvShow(tvShowId)).thenReturn(dummyDetailTvShow);

        Resource<DetailTvShowsEntity> detailTvShowsEntity = LiveDataTestUtil.getValue(catalogRepository.getDetailTvShows(tvShowId));
        verify(local).getDetailTvShow(tvShowId);
        assertNotNull(detailTvShowsEntity.data);
        assertEquals(detailTvShowsResponse.getBackdrop(), detailTvShowsEntity.data.getBackdrop());
        assertEquals(detailTvShowsResponse.getOverview(), detailTvShowsEntity.data.getOverview());
        assertEquals(detailTvShowsResponse.getPoster(), detailTvShowsEntity.data.getPoster());
        assertEquals(detailTvShowsResponse.getRating(), detailTvShowsEntity.data.getRating());
        assertEquals(detailTvShowsResponse.getReleaseDate(), detailTvShowsEntity.data.getReleaseDate());
        assertEquals(detailTvShowsResponse.getTagline(), detailTvShowsEntity.data.getTagline());
        assertEquals(detailTvShowsResponse.getTitle(), detailTvShowsEntity.data.getTitle());
    }
}