package com.khoirullatif.katalogfilm.viewmodel;

import android.annotation.SuppressLint;
import android.content.Context;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import com.khoirullatif.katalogfilm.data.CatalogRepository;
import com.khoirullatif.katalogfilm.di.Injection;
import com.khoirullatif.katalogfilm.ui.detail.DetailMoviesViewModel;
import com.khoirullatif.katalogfilm.ui.detail.DetailTvShowsViewModel;
import com.khoirullatif.katalogfilm.ui.detail.FavoriteAddUpdateViewModel;
import com.khoirullatif.katalogfilm.ui.favorite.favmovies.FavoriteMoviesViewModel;
import com.khoirullatif.katalogfilm.ui.favorite.favtvshows.FavoriteTvShowsViewModel;
import com.khoirullatif.katalogfilm.ui.movies.MoviesViewModel;
import com.khoirullatif.katalogfilm.ui.tvshows.TvShowsViewModel;

public class ViewModelFactory extends ViewModelProvider.NewInstanceFactory {

    @SuppressLint("StaticFieldLeak")
    private static volatile ViewModelFactory INSTANCE;

    private final CatalogRepository mCatalogRepository;

    private ViewModelFactory(CatalogRepository catalogRepository) {
        this.mCatalogRepository = catalogRepository;
    }

    public static ViewModelFactory getInstance(Context context) {
        if (INSTANCE == null) {
            synchronized (ViewModelFactory.class) {
                if (INSTANCE == null) {
                    INSTANCE = new ViewModelFactory(Injection.provideRepository(context));
                }
            }
        }
        return INSTANCE;
    }

    @SuppressWarnings("unchecked")
    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {

        if (modelClass.isAssignableFrom(MoviesViewModel.class)) {
            return (T) new MoviesViewModel(mCatalogRepository);
        } else if (modelClass.isAssignableFrom(TvShowsViewModel.class)) {
            return (T) new TvShowsViewModel(mCatalogRepository);
        } else if (modelClass.isAssignableFrom(DetailMoviesViewModel.class)) {
            return (T) new DetailMoviesViewModel(mCatalogRepository);
        } else if (modelClass.isAssignableFrom(DetailTvShowsViewModel.class)) {
            return (T) new DetailTvShowsViewModel(mCatalogRepository);
        } else if (modelClass.isAssignableFrom(FavoriteAddUpdateViewModel.class)) {
            return (T) new FavoriteAddUpdateViewModel(mCatalogRepository);
        } else if (modelClass.isAssignableFrom(FavoriteMoviesViewModel.class)) {
            return (T) new FavoriteMoviesViewModel(mCatalogRepository);
        } else if (modelClass.isAssignableFrom(FavoriteTvShowsViewModel.class)) {
            return (T) new FavoriteTvShowsViewModel(mCatalogRepository);
        }

        throw new IllegalArgumentException("Unknown ViewModel class: " + modelClass.getName());
    }
}
