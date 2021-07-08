package com.khoirullatif.katalogfilm.ui.tvshows;

import androidx.arch.core.executor.testing.InstantTaskExecutorRule;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;

import com.khoirullatif.katalogfilm.data.CatalogRepository;
import com.khoirullatif.katalogfilm.data.source.local.entity.TvShowsEntity;
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
public class TvShowsViewModelTest {
    private TvShowsViewModel viewModel;

    @Rule
    public InstantTaskExecutorRule instantTaskExecutorRule = new InstantTaskExecutorRule();

    @Mock
    private CatalogRepository catalogRepository;

    @Mock
    private Observer<Resource<List<TvShowsEntity>>> observer;

    @Before
    public void setUp() {
        viewModel = new TvShowsViewModel(catalogRepository);
    }

    @Test
    public void getTvShows() {
        Resource<List<TvShowsEntity>> dummyTvShows = Resource.success(DataDummy.generateDummyTvShows());
        MutableLiveData<Resource<List<TvShowsEntity>>> tvShows = new MutableLiveData<>();
        tvShows.setValue(dummyTvShows);

        when(catalogRepository.getTvShows()).thenReturn(tvShows);
        List<TvShowsEntity> tvShowsEntities = viewModel.getTvShows().getValue().data;
        verify(catalogRepository).getTvShows();
        assertNotNull(tvShowsEntities);
        assertEquals(12, tvShowsEntities.size());

        viewModel.getTvShows().observeForever(observer);
        verify(observer).onChanged(dummyTvShows);
    }
}