package com.khoirullatif.katalogfilm.ui.detail;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.khoirullatif.katalogfilm.data.CatalogRepository;
import com.khoirullatif.katalogfilm.data.source.local.entity.DetailTvShowsEntity;
import com.khoirullatif.katalogfilm.vo.Resource;

public class DetailTvShowsViewModel extends ViewModel {

    private final CatalogRepository catalogRepository;

    public DetailTvShowsViewModel(CatalogRepository repository) {
        this.catalogRepository = repository;
    }

    public LiveData<Resource<DetailTvShowsEntity>> getDetailTvShows(String tvShowId) {
        return catalogRepository.getDetailTvShows(tvShowId);
    }
}
