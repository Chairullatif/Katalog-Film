package com.khoirullatif.katalogfilm.ui.tvshows;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.khoirullatif.katalogfilm.R;
import com.khoirullatif.katalogfilm.data.source.local.entity.TvShowsEntity;
import com.khoirullatif.katalogfilm.databinding.FragmentTvShowsBinding;
import com.khoirullatif.katalogfilm.ui.detail.DetailActivity;
import com.khoirullatif.katalogfilm.viewmodel.ViewModelFactory;

import java.util.ArrayList;

public class TvShowsFragment extends Fragment {

    private FragmentTvShowsBinding fragmentTvShowsBinding;
    private TvShowsAdapter tvShowsAdapter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        fragmentTvShowsBinding = FragmentTvShowsBinding.inflate(inflater, container, false);
        return fragmentTvShowsBinding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        if (getActivity() != null) {
            ViewModelFactory factory = ViewModelFactory.getInstance(getContext());
            TvShowsViewModel tvShowsViewModel = new ViewModelProvider(this, factory).get(TvShowsViewModel.class);

            tvShowsAdapter = new TvShowsAdapter();

            tvShowsViewModel.getTvShows().observe(getViewLifecycleOwner(), tvShows -> {
                if (tvShows != null) {
                    switch (tvShows.status) {
                        case LOADING:
                            fragmentTvShowsBinding.progressBar.setVisibility(View.VISIBLE);
                            break;
                        case SUCCESS:
                            fragmentTvShowsBinding.progressBar.setVisibility(View.GONE);
                            tvShowsAdapter.setTvShows((ArrayList<TvShowsEntity>) tvShows.data);
                            tvShowsAdapter.notifyDataSetChanged();
                            break;
                        case ERROR:
                            fragmentTvShowsBinding.progressBar.setVisibility(View.GONE);
                            Toast.makeText(getContext(), getString(R.string.kesalahan), Toast.LENGTH_SHORT).show();
                            break;
                    }
                }
            });

            fragmentTvShowsBinding.rvTvShows.setHasFixedSize(true);
            fragmentTvShowsBinding.rvTvShows.setLayoutManager(new GridLayoutManager(getContext(), 2));
            fragmentTvShowsBinding.rvTvShows.setAdapter(tvShowsAdapter);

            tvShowsAdapter.setOnItemClickCallback(this::showSelectedTvShow);
        }

    }

    private void showSelectedTvShow(TvShowsEntity tvShowsEntity) {
        Intent intent = new Intent(getContext(), DetailActivity.class);
        intent.putExtra(DetailActivity.EXTRA_MOVIE_ID, tvShowsEntity.getIdTv());
        intent.putExtra(DetailActivity.EXTRA_TITLE, getResources().getString(R.string.detail_tv));
        startActivity(intent);
    }
}