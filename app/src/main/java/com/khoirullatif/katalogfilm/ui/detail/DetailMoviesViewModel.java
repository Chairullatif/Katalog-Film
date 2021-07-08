package com.khoirullatif.katalogfilm.ui.detail;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.khoirullatif.katalogfilm.data.CatalogRepository;
import com.khoirullatif.katalogfilm.data.source.local.entity.DetailMoviesEntity;
import com.khoirullatif.katalogfilm.vo.Resource;


public class DetailMoviesViewModel extends ViewModel {

    private final CatalogRepository catalogRepository;

    public DetailMoviesViewModel(CatalogRepository catalogRepository) {
        this.catalogRepository = catalogRepository;
    }

    public LiveData<Resource<DetailMoviesEntity>> getDetailMovies(String movieId) {
        return catalogRepository.getDetailMovies(movieId);
    }

}
