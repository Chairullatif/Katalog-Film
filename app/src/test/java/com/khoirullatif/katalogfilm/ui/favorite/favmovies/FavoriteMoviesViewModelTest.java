package com.khoirullatif.katalogfilm.ui.favorite.favmovies;


import androidx.arch.core.executor.testing.InstantTaskExecutorRule;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.paging.PagedList;

import com.khoirullatif.katalogfilm.data.CatalogRepository;
import com.khoirullatif.katalogfilm.data.source.local.entity.FavoriteMoviesEntity;
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
public class FavoriteMoviesViewModelTest {

    private FavoriteMoviesViewModel viewModel;

    @Rule
    public InstantTaskExecutorRule instantTaskExecutorRule = new InstantTaskExecutorRule();

    @Mock
    private CatalogRepository catalogRepository;

    @Mock
    private Observer<PagedList<FavoriteMoviesEntity>> observer;

    @Mock
    private PagedList<FavoriteMoviesEntity> pagedList;

    @Before
    public void setUp() {
        viewModel = new FavoriteMoviesViewModel(catalogRepository);
    }

    @Test
    public void getFavoriteMovies() {
        PagedList<FavoriteMoviesEntity> dummyFavoriteMovies = pagedList;
        when(dummyFavoriteMovies.size()).thenReturn(5);
        MutableLiveData<PagedList<FavoriteMoviesEntity>> movies = new MutableLiveData<>();
        movies.setValue(dummyFavoriteMovies);

        String sort = SortUtils.NEWEST;
        when(catalogRepository.getFavoriteMovies(sort)).thenReturn(movies);
        List<FavoriteMoviesEntity> favoriteMoviesEntities = viewModel.getFavoriteMovies(sort).getValue();
        verify(catalogRepository).getFavoriteMovies(sort);
        assertNotNull(favoriteMoviesEntities);
        assertEquals(5, favoriteMoviesEntities.size());

        viewModel.getFavoriteMovies(sort).observeForever(observer);
        verify(observer).onChanged(dummyFavoriteMovies);
    }
}