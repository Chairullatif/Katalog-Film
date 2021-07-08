package com.khoirullatif.katalogfilm.ui.favorite.favtvshows;


import androidx.arch.core.executor.testing.InstantTaskExecutorRule;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.paging.PagedList;

import com.khoirullatif.katalogfilm.data.CatalogRepository;
import com.khoirullatif.katalogfilm.data.source.local.entity.FavoriteTvShowsEntity;
import com.khoirullatif.katalogfilm.utils.SortUtils;

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
public class FavoriteTvShowsViewModelTest {
    private FavoriteTvShowsViewModel viewModel;

    @Rule
    public InstantTaskExecutorRule instantTaskExecutorRule = new InstantTaskExecutorRule();

    @Mock
    private CatalogRepository catalogRepository;

    @Mock
    private Observer<PagedList<FavoriteTvShowsEntity>> observer;

    @Mock
    private PagedList<FavoriteTvShowsEntity> pagedList;

    @Before
    public void setUp() {
        viewModel = new FavoriteTvShowsViewModel(catalogRepository);
    }

    @Test
    public void getFavoriteMovies() {
        PagedList<FavoriteTvShowsEntity> dummyFavoriteTvShows = pagedList;
        when(dummyFavoriteTvShows.size()).thenReturn(5);
        MutableLiveData<PagedList<FavoriteTvShowsEntity>> movies = new MutableLiveData<>();
        movies.setValue(dummyFavoriteTvShows);

        String sort = SortUtils.NEWEST;
        when(catalogRepository.getFavoriteTvShows(sort)).thenReturn(movies);
        List<FavoriteTvShowsEntity> favoriteTvShowsEntities = viewModel.getFavoriteTvShows(sort).getValue();
        verify(catalogRepository).getFavoriteTvShows(sort);
        assertNotNull(favoriteTvShowsEntities);
        assertEquals(5, favoriteTvShowsEntities.size());

        viewModel.getFavoriteTvShows(sort).observeForever(observer);
        verify(observer).onChanged(dummyFavoriteTvShows);
    }
}