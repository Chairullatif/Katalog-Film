package com.khoirullatif.katalogfilm.ui.movies;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.khoirullatif.katalogfilm.R;
import com.khoirullatif.katalogfilm.ui.detail.DetailActivity;
import com.khoirullatif.katalogfilm.data.source.local.entity.MoviesEntity;
import com.khoirullatif.katalogfilm.databinding.FragmentMoviesBinding;
import com.khoirullatif.katalogfilm.viewmodel.ViewModelFactory;

import java.util.ArrayList;

public class MoviesFragment extends Fragment {

    private FragmentMoviesBinding fragmentMoviesBinding;
    private MoviesAdapter moviesAdapter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        fragmentMoviesBinding = FragmentMoviesBinding.inflate(inflater, container, false);
        return fragmentMoviesBinding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        if (getActivity() != null) {
            ViewModelFactory factory = ViewModelFactory.getInstance(getContext());
            MoviesViewModel moviesViewModel = new ViewModelProvider(this, factory).get(MoviesViewModel.class);
            moviesAdapter = new MoviesAdapter();

            moviesViewModel.getMovies().observe(getViewLifecycleOwner(), movies -> {
                if (movies != null) {
                    switch (movies.status) {
                        case LOADING:
                            fragmentMoviesBinding.progressBar.setVisibility(View.VISIBLE);
                            break;
                        case SUCCESS:
                            fragmentMoviesBinding.progressBar.setVisibility(View.GONE);
                            moviesAdapter.setMovies((ArrayList<MoviesEntity>) movies.data);
                            moviesAdapter.notifyDataSetChanged();
                            break;
                        case ERROR:
                            fragmentMoviesBinding.progressBar.setVisibility(View.GONE);
                            Toast.makeText(getContext(), getString(R.string.kesalahan), Toast.LENGTH_SHORT).show();
                            break;
                    }
                }
            });

            fragmentMoviesBinding.rvMovies.setHasFixedSize(true);
            fragmentMoviesBinding.rvMovies.setLayoutManager(new LinearLayoutManager(getContext()));
            fragmentMoviesBinding.rvMovies.setAdapter(moviesAdapter);

            moviesAdapter.setOnItemClickCallback(this::showSelectedMovie);
        }
    }

    private void showSelectedMovie(MoviesEntity moviesEntity) {
        Intent intent = new Intent(getContext(), DetailActivity.class);
        intent.putExtra(DetailActivity.EXTRA_MOVIE_ID, moviesEntity.getId());
        intent.putExtra(DetailActivity.EXTRA_TITLE, getResources().getString(R.string.detail_movie));
        startActivity(intent);
    }
}