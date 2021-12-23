package com.khoirullatif.katalogfilm.ui.favorite.favmovies;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.khoirullatif.katalogfilm.R;
import com.khoirullatif.katalogfilm.data.source.local.entity.FavoriteMoviesEntity;
import com.khoirullatif.katalogfilm.databinding.FragmentFavoriteMoviesBinding;
import com.khoirullatif.katalogfilm.ui.detail.DetailActivity;
import com.khoirullatif.katalogfilm.ui.detail.FavoriteAddUpdateViewModel;
import com.khoirullatif.katalogfilm.utils.SortUtils;
import com.khoirullatif.katalogfilm.viewmodel.ViewModelFactory;

public class FavoriteMoviesFragment extends Fragment implements FavoriteMoviesFragmentCallback {

    private FragmentFavoriteMoviesBinding fragmentFavoriteMoviesBinding;
    private FavoriteMoviesViewModel favoriteMoviesViewModel;
    private FavoriteMoviesAdapter adapter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        setHasOptionsMenu(true);
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        fragmentFavoriteMoviesBinding = FragmentFavoriteMoviesBinding.inflate(inflater, container, false);
        return fragmentFavoriteMoviesBinding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        if (getActivity() != null) {
            ViewModelFactory factory = ViewModelFactory.getInstance(getActivity());
            favoriteMoviesViewModel = new ViewModelProvider(this, factory).get(FavoriteMoviesViewModel.class);

            adapter = new FavoriteMoviesAdapter(this);

            fragmentFavoriteMoviesBinding.progressBar.setVisibility(View.VISIBLE);
            favoriteMoviesViewModel.getFavoriteMovies(SortUtils.NEWEST).observe(getViewLifecycleOwner(), favoriteMoviesEntities -> {
                fragmentFavoriteMoviesBinding.progressBar.setVisibility(View.GONE);
                if (favoriteMoviesEntities.isEmpty()) {
                    fragmentFavoriteMoviesBinding.tvNotYetAddmovie.setVisibility(View.VISIBLE);
                }
                adapter.submitList(favoriteMoviesEntities);
                adapter.notifyDataSetChanged();
            });

            fragmentFavoriteMoviesBinding.rvMoviesFav.setHasFixedSize(true);
            fragmentFavoriteMoviesBinding.rvMoviesFav.setLayoutManager(new LinearLayoutManager(getContext()));
            fragmentFavoriteMoviesBinding.rvMoviesFav.setAdapter(adapter);
        }
    }

    @Override
    public void onCreateOptionsMenu(@NonNull Menu menu, @NonNull MenuInflater inflater) {
        inflater.inflate(R.menu.menu_favorite, menu);

        super.onCreateOptionsMenu(menu, inflater);
    }

    @SuppressLint("NonConstantResourceId")
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        String sort = "";

        switch (item.getItemId()) {
            case R.id.action_newest:
                sort = SortUtils.NEWEST;
                break;
            case R.id.action_oldest:
                sort = SortUtils.OLDEST;
                break;
            case R.id.action_random:
                sort = SortUtils.RANDOM;
                break;
        }

        fragmentFavoriteMoviesBinding.progressBar.setVisibility(View.VISIBLE);
        favoriteMoviesViewModel.getFavoriteMovies(sort).observe(getViewLifecycleOwner(), favoriteMoviesEntities -> {
            fragmentFavoriteMoviesBinding.progressBar.setVisibility(View.GONE);
            adapter.submitList(favoriteMoviesEntities);
            adapter.notifyDataSetChanged();
        });

        item.setChecked(true);
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onFloatingActionClick(FavoriteMoviesEntity favoriteMoviesEntity) {
        if (getActivity() != null) {
            ViewModelFactory factory = ViewModelFactory.getInstance(getActivity());
            FavoriteAddUpdateViewModel favoriteAddUpdateViewModel = new ViewModelProvider(this, factory).get(FavoriteAddUpdateViewModel.class);

            favoriteAddUpdateViewModel.deleteFavoriteMovies(favoriteMoviesEntity);
            Toast.makeText(getContext(), R.string.toast_hapus, Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onItemClicked(FavoriteMoviesEntity data) {
        Intent intent = new Intent(getContext(), DetailActivity.class);
        intent.putExtra(DetailActivity.EXTRA_MOVIE_ID, data.getId());
        intent.putExtra(DetailActivity.EXTRA_TITLE, getResources().getString(R.string.detail_movie));
        startActivity(intent);
    }
}