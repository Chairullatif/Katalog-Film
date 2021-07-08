package com.khoirullatif.katalogfilm.ui.movies;


import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.khoirullatif.katalogfilm.data.CatalogRepository;
import com.khoirullatif.katalogfilm.data.source.local.entity.MoviesEntity;
import com.khoirullatif.katalogfilm.vo.Resource;

import java.util.List;

public class MoviesViewModel extends ViewModel {

    private final CatalogRepository catalogRepository;

    public MoviesViewModel(CatalogRepository catalogRepository) {
        this.catalogRepository = catalogRepository;
    }

    public LiveData<Resource<List<MoviesEntity>>> getMovies() {
        return catalogRepository.getMovies();
    }
}
