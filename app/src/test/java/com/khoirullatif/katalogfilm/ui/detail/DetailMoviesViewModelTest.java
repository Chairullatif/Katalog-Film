package com.khoirullatif.katalogfilm.ui.detail;

import androidx.arch.core.executor.testing.InstantTaskExecutorRule;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;

import com.khoirullatif.katalogfilm.data.CatalogRepository;
import com.khoirullatif.katalogfilm.data.source.local.entity.DetailMoviesEntity;
import com.khoirullatif.katalogfilm.utils.DataDummy;
import com.khoirullatif.katalogfilm.vo.Resource;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class DetailMoviesViewModelTest {

    private DetailMoviesViewModel viewModel;
    private final DetailMoviesEntity dummy = DataDummy.generateDummyDetailMovies();
    private final String movieId = DataDummy.generateDummyMovies().get(0).getId();

    @Rule
    public InstantTaskExecutorRule instantTaskExecutorRule = new InstantTaskExecutorRule();

    @Mock
    private CatalogRepository catalogRepository;

    @Mock
    private Observer<Resource<DetailMoviesEntity>> observer;

    @Before
    public void setUp() {
        viewModel = new DetailMoviesViewModel(catalogRepository);
    }

    @Test
    public void getDetailMovies() {
        Resource<DetailMoviesEntity> dummyDetailMovie = Resource.success(DataDummy.generateDummyDetailMovies());
        MutableLiveData<Resource<DetailMoviesEntity>> detailMovie = new MutableLiveData<>();
        detailMovie.setValue(dummyDetailMovie);

        when(catalogRepository.getDetailMovies(movieId)).thenReturn(detailMovie);
        DetailMoviesEntity detailMoviesEntity = viewModel.getDetailMovies(movieId).getValue().data;
        verify(catalogRepository).getDetailMovies(movieId);
        assertNotNull(detailMoviesEntity);
        assertEquals(dummy.getId(), detailMoviesEntity.getId());
        assertEquals(dummy.getBackdrop(), detailMoviesEntity.getBackdrop());
        assertEquals(dummy.getOverview(), detailMoviesEntity.getOverview());
        assertEquals(dummy.getPoster(), detailMoviesEntity.getPoster());
        assertEquals(dummy.getRating(), detailMoviesEntity.getRating());
        assertEquals(dummy.getReleaseDate(), detailMoviesEntity.getReleaseDate());
        assertEquals(dummy.getTagline(), detailMoviesEntity.getTagline());
        assertEquals(dummy.getTitle(), detailMoviesEntity.getTitle());

        viewModel.getDetailMovies(movieId).observeForever(observer);
        verify(observer).onChanged(dummyDetailMovie);

//        MutableLiveData<DetailMoviesEntity> detailMovie = new MutableLiveData<>();
//        detailMovie.setValue(dummyDetailMovie);
//
//        when(catalogRepository.getDetailMovies(movieId)).thenReturn(detailMovie);
//        DetailMoviesEntity detailMoviesEntity = viewModel.getDetailMovies().getValue();
//        verify(catalogRepository).getDetailMovies(movieId);
//        assertNotNull(detailMoviesEntity);

//
//        viewModel.getDetailMovies().observeForever(observer);
//        verify(observer).onChanged(dummyDetailMovie);
    }
}