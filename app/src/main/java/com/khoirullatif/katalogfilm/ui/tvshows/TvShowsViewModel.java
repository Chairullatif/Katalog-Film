package com.khoirullatif.katalogfilm.ui.tvshows;


import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.khoirullatif.katalogfilm.data.CatalogRepository;
import com.khoirullatif.katalogfilm.data.source.local.entity.TvShowsEntity;
import com.khoirullatif.katalogfilm.vo.Resource;

import java.util.List;

public class TvShowsViewModel extends ViewModel {

    private final CatalogRepository catalogRepository;

    public TvShowsViewModel(CatalogRepository catalogRepository) {
        this.catalogRepository = catalogRepository;
    }

    public LiveData<Resource<List<TvShowsEntity>>> getTvShows() {
        return catalogRepository.getTvShows();
    }

}
