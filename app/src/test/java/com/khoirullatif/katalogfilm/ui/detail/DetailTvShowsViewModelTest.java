package com.khoirullatif.katalogfilm.ui.detail;

import androidx.arch.core.executor.testing.InstantTaskExecutorRule;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;

import com.khoirullatif.katalogfilm.data.CatalogRepository;
import com.khoirullatif.katalogfilm.data.source.local.entity.DetailTvShowsEntity;
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
public class DetailTvShowsViewModelTest {

    private DetailTvShowsViewModel viewModel;
    private final DetailTvShowsEntity dummy = DataDummy.generateDummyDetailTvShows();
    private final String tvShowId = DataDummy.generateDummyTvShows().get(0).getIdTv();

    @Rule
    public InstantTaskExecutorRule instantTaskExecutorRule = new InstantTaskExecutorRule();

    @Mock
    private CatalogRepository catalogRepository;

    @Mock
    private Observer<Resource<DetailTvShowsEntity>> observer;

    @Before
    public void setUp() {
        viewModel = new DetailTvShowsViewModel(catalogRepository);
    }

    @Test
    public void getDetailTvShows() {
        Resource<DetailTvShowsEntity> dummyDetailTvShow = Resource.success(DataDummy.generateDummyDetailTvShows());
        MutableLiveData<Resource<DetailTvShowsEntity>> detailTvShow = new MutableLiveData<>();
        detailTvShow.setValue(dummyDetailTvShow);

        when(catalogRepository.getDetailTvShows(tvShowId)).thenReturn(detailTvShow);
        DetailTvShowsEntity detailTvShowsEntity = viewModel.getDetailTvShows(tvShowId).getValue().data;
        verify(catalogRepository).getDetailTvShows(tvShowId);
        assertNotNull(detailTvShowsEntity);
        assertEquals(dummy.getId(), detailTvShowsEntity.getId());
        assertEquals(dummy.getBackdrop(), detailTvShowsEntity.getBackdrop());
        assertEquals(dummy.getOverview(), detailTvShowsEntity.getOverview());
        assertEquals(dummy.getPoster(), detailTvShowsEntity.getPoster());
        assertEquals(dummy.getRating(), detailTvShowsEntity.getRating());
        assertEquals(dummy.getReleaseDate(), detailTvShowsEntity.getReleaseDate());
        assertEquals(dummy.getTagline(), detailTvShowsEntity.getTagline());
        assertEquals(dummy.getTitle(), detailTvShowsEntity.getTitle());

        viewModel.getDetailTvShows(tvShowId).observeForever(observer);
        verify(observer).onChanged(dummyDetailTvShow);
    }
}