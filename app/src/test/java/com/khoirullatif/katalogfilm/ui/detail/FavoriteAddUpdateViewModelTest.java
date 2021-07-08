package com.khoirullatif.katalogfilm.ui.detail;


import androidx.arch.core.executor.testing.InstantTaskExecutorRule;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.paging.PagedList;

import com.khoirullatif.katalogfilm.data.CatalogRepository;
import com.khoirullatif.katalogfilm.data.source.local.entity.FavoriteMoviesEntity;
import com.khoirullatif.katalogfilm.data.source.local.entity.FavoriteTvShowsEntity;
import com.khoirullatif.katalogfilm.utils.DataDummy;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;


import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class FavoriteAddUpdateViewModelTest {
    private FavoriteAddUpdateViewModel viewModel;
    private final String movieId = DataDummy.generateFavoriteDummyMovies().get(0).getId();
    private final String tvShowId = DataDummy.generateFavoriteDummyTvShows().get(0).getId();

    @Rule
    public InstantTaskExecutorRule instantTaskExecutorRule = new InstantTaskExecutorRule();

    @Mock
    private CatalogRepository catalogRepository;

    @Mock
    private Observer<PagedList<FavoriteMoviesEntity>> observerMovie;

    @Mock
    private Observer<PagedList<FavoriteTvShowsEntity>> observerTv;

    @Mock
    private PagedList<FavoriteMoviesEntity> pagedListMovie;

    @Mock
    private PagedList<FavoriteTvShowsEntity> pagedListTv;

    @Before
    public void setUp() {
        viewModel = new FavoriteAddUpdateViewModel(catalogRepository);
    }

    @Test
    public void findMovieById() {
        PagedList<FavoriteMoviesEntity> dummyFavoriteMovies = pagedListMovie;
        when(dummyFavoriteMovies.size()).thenReturn(1);
        MutableLiveData<PagedList<FavoriteMoviesEntity>> movies = new MutableLiveData<>();
        movies.setValue(dummyFavoriteMovies);

        when(catalogRepository.findMovieById(movieId)).thenReturn(movies);
        List<FavoriteMoviesEntity> favoriteMoviesEntities = viewModel.findMovieById(movieId).getValue();
        verify(catalogRepository).findMovieById(movieId);
        assertNotNull(favoriteMoviesEntities);
        assertEquals(1, favoriteMoviesEntities.size());

        viewModel.findMovieById(movieId).observeForever(observerMovie);
        verify(observerMovie).onChanged(dummyFavoriteMovies);

//        DataSource.Factory<Integer, FavoriteMoviesEntity> dataSourceFactory = mock(DataSource.Factory.class);
//        when(repository.findMovieById(movieId)).thenReturn(dataSourceFactory);
//        catalogRepository.findMovieById(movieId);
//
//        assertNotNull(repository.findMovieById(movieId));
    }

    @Test
    public void findTvShowById() {
        PagedList<FavoriteTvShowsEntity> dummyFavoriteTvShow = pagedListTv;
        when(dummyFavoriteTvShow.size()).thenReturn(1);
        MutableLiveData<PagedList<FavoriteTvShowsEntity>> tvShow = new MutableLiveData<>();
        tvShow.setValue(dummyFavoriteTvShow);

        when(catalogRepository.findTvShowById(tvShowId)).thenReturn(tvShow);
        List<FavoriteTvShowsEntity> favoriteTvShowEntities = viewModel.findTvShowById(tvShowId).getValue();
        verify(catalogRepository).findTvShowById(tvShowId);
        assertNotNull(favoriteTvShowEntities);
        assertEquals(1, favoriteTvShowEntities.size());

        viewModel.findTvShowById(tvShowId).observeForever(observerTv);
        verify(observerTv).onChanged(dummyFavoriteTvShow);

//        DataSource.Factory<Integer, FavoriteTvShowsEntity> dataSourceFactory = mock(DataSource.Factory.class);
//        when(repository.findTvShowById(tvShowId)).thenReturn(dataSourceFactory);
//        catalogRepository.findTvShowById(tvShowId);
//
//        assertNotNull(repository.findTvShowById(tvShowId));
    }

}