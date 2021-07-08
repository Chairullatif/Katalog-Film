package com.khoirullatif.katalogfilm.ui.movies;

import androidx.arch.core.executor.testing.InstantTaskExecutorRule;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;

import com.khoirullatif.katalogfilm.data.CatalogRepository;
import com.khoirullatif.katalogfilm.data.source.local.entity.MoviesEntity;
import com.khoirullatif.katalogfilm.utils.DataDummy;
import com.khoirullatif.katalogfilm.vo.Resource;

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
public class MoviesViewModelTest {
    private MoviesViewModel viewModel;

    @Rule
    public InstantTaskExecutorRule instantExecutorRule = new InstantTaskExecutorRule();

    @Mock
    private CatalogRepository catalogRepository;

    @Mock
    private Observer<Resource<List<MoviesEntity>>> observer;

    @Before
    public void setUp() {
        viewModel = new MoviesViewModel(catalogRepository);
    }

    @Test
    public void getMovies() {
        Resource<List<MoviesEntity>> dummyMovies = Resource.success(DataDummy.generateDummyMovies());

        MutableLiveData<Resource<List<MoviesEntity>>> movies = new MutableLiveData<>();
        movies.setValue(dummyMovies);

        when(catalogRepository.getMovies()).thenReturn(movies);
        List<MoviesEntity> moviesEntities = viewModel.getMovies().getValue().data;
        verify(catalogRepository).getMovies();
        assertNotNull(moviesEntities);
        assertEquals(12, moviesEntities.size());

        viewModel.getMovies().observeForever(observer);
        verify(observer).onChanged(dummyMovies);
    }
}