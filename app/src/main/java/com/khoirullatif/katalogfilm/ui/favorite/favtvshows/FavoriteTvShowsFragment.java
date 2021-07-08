package com.khoirullatif.katalogfilm.ui.favorite.favtvshows;

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
import com.khoirullatif.katalogfilm.data.source.local.entity.FavoriteTvShowsEntity;
import com.khoirullatif.katalogfilm.databinding.FragmentFavoriteTvShowsBinding;
import com.khoirullatif.katalogfilm.ui.detail.DetailActivity;
import com.khoirullatif.katalogfilm.ui.detail.FavoriteAddUpdateViewModel;
import com.khoirullatif.katalogfilm.utils.SortUtils;
import com.khoirullatif.katalogfilm.viewmodel.ViewModelFactory;

public class FavoriteTvShowsFragment extends Fragment implements FavoriteTvShowFragmentCallback{

    private FragmentFavoriteTvShowsBinding fragmentFavoriteTvShowsBinding;
    private FavoriteTvShowsViewModel favoriteTvShowsViewModel;
    private FavoriteTvShowsAdapter adapter;


    public FavoriteTvShowsFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        setHasOptionsMenu(true);
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        fragmentFavoriteTvShowsBinding = FragmentFavoriteTvShowsBinding.inflate(inflater, container, false);
        return fragmentFavoriteTvShowsBinding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        if (getActivity() != null) {
            ViewModelFactory factory = ViewModelFactory.getInstance(getActivity());
            favoriteTvShowsViewModel = new ViewModelProvider(this, factory).get(FavoriteTvShowsViewModel.class);

            adapter = new FavoriteTvShowsAdapter(this);

            fragmentFavoriteTvShowsBinding.progressBar.setVisibility(View.VISIBLE);

            favoriteTvShowsViewModel.getFavoriteTvShows(SortUtils.NEWEST).observe(getViewLifecycleOwner(), favoriteTvShowsEnitities -> {
                fragmentFavoriteTvShowsBinding.progressBar.setVisibility(View.GONE);
                adapter.submitList(favoriteTvShowsEnitities);
                adapter.notifyDataSetChanged();
            });

            fragmentFavoriteTvShowsBinding.rvTvShowsFav.setHasFixedSize(true);
            fragmentFavoriteTvShowsBinding.rvTvShowsFav.setLayoutManager(new LinearLayoutManager(getContext()));
            fragmentFavoriteTvShowsBinding.rvTvShowsFav.setAdapter(adapter);
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

        fragmentFavoriteTvShowsBinding.progressBar.setVisibility(View.VISIBLE);
        favoriteTvShowsViewModel.getFavoriteTvShows(sort).observe(getViewLifecycleOwner(), favoriteTvShowsEnitities -> {
            fragmentFavoriteTvShowsBinding.progressBar.setVisibility(View.GONE);
            adapter.submitList(favoriteTvShowsEnitities);
            adapter.notifyDataSetChanged();
        });

        item.setChecked(true);
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onFloatingActionClick(FavoriteTvShowsEntity favoriteTvShowsEntity) {
        if (getActivity() != null) {
            ViewModelFactory factory = ViewModelFactory.getInstance(getActivity());
            FavoriteAddUpdateViewModel favoriteAddUpdateViewModel = new ViewModelProvider(this, factory).get(FavoriteAddUpdateViewModel.class);

            favoriteAddUpdateViewModel.deleteFavoriteTvShows(favoriteTvShowsEntity);
            Toast.makeText(getContext(), R.string.toast_hapus, Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onItemClicked(FavoriteTvShowsEntity data) {
        Intent intent = new Intent(getContext(), DetailActivity.class);
        intent.putExtra(DetailActivity.EXTRA_MOVIE_ID, data.getId());
        intent.putExtra(DetailActivity.EXTRA_TITLE, getResources().getString(R.string.detail_tv));
        startActivity(intent);
    }
}