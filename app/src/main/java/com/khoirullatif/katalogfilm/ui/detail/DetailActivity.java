package com.khoirullatif.katalogfilm.ui.detail;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.khoirullatif.katalogfilm.R;
import com.khoirullatif.katalogfilm.data.source.local.entity.FavoriteMoviesEntity;
import com.khoirullatif.katalogfilm.data.source.local.entity.FavoriteTvShowsEntity;
import com.khoirullatif.katalogfilm.databinding.ActivityDetailBinding;

import com.khoirullatif.katalogfilm.databinding.ContentDetailMoviesBinding;
import com.khoirullatif.katalogfilm.ui.home.MainActivity;
import com.khoirullatif.katalogfilm.utils.DateHelper;
import com.khoirullatif.katalogfilm.viewmodel.ViewModelFactory;


public class DetailActivity extends AppCompatActivity {

    public static final String EXTRA_MOVIE_ID = "extra_id";
    public static final String EXTRA_TITLE = "extra_title";
    private ContentDetailMoviesBinding contentDetailMoviesBinding;
    private ActivityDetailBinding activityDetailBinding;

    private FavoriteAddUpdateViewModel favoriteAddUpdateViewModel;

    private FavoriteMoviesEntity favoriteMoviesEntity;
    private FavoriteTvShowsEntity favoriteTvShowsEntity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        activityDetailBinding = ActivityDetailBinding.inflate(getLayoutInflater());
        contentDetailMoviesBinding = activityDetailBinding.detailContent;
        setContentView(activityDetailBinding.getRoot());

        favoriteAddUpdateViewModel = obtainViewModel(DetailActivity.this);

        String id = getIntent().getStringExtra(EXTRA_MOVIE_ID);
        String title = getIntent().getStringExtra(EXTRA_TITLE);
        assert id != null;
        Log.d("onDetail", id);

        ViewModelFactory factory = ViewModelFactory.getInstance(getApplicationContext());

        activityDetailBinding.progressBar.setVisibility(View.VISIBLE);
        assert title != null;
        if (title.equals(getString(R.string.detail_movie))) {
            detailMovies(id, factory);
        } else if (title.equals(getString(R.string.detail_tv))) {
            detailTvshows(id, factory);
        }

        contentDetailMoviesBinding.ratingBar.setNumStars(5);
//
//        contentDetailMoviesBinding.fabAdd.setOnClickListener(view -> {
//            if (title.equals(getString(R.string.detail_movie))) {
//                insertFavMovies(id, factory);
//            } else if (title.equals(getString(R.string.detail_tv))) {
//                insertFavTvShows(id, factory);
//            }
//            contentDetailMoviesBinding.fabAdd.setVisibility(View.GONE);
//            Toast.makeText(this, getString(R.string.toast_tambah), Toast.LENGTH_SHORT).show();
//        });

        contentDetailMoviesBinding.ibBack.setOnClickListener(view -> {
//            Intent intent = new Intent(this, MainActivity.class);
//            startActivity(intent);
            finish();
        });
    }

    private void detailMovies(String id, ViewModelFactory factory) {
        DetailMoviesViewModel detailMoviesViewModel = new ViewModelProvider(this, factory).get(DetailMoviesViewModel.class);
        detailMoviesViewModel.getDetailMovies(id).observe(this, detailMoviesEntity -> {
            if (detailMoviesEntity != null) {
                switch (detailMoviesEntity.status) {
                    case LOADING:
                        activityDetailBinding.progressBar.setVisibility(View.VISIBLE);
//                        contentDetailMoviesBinding.fabAdd.setVisibility(View.GONE);
                        break;
                    case SUCCESS:
                        activityDetailBinding.progressBar.setVisibility(View.GONE);
                        Glide.with(this)
                                .load(detailMoviesEntity.data.getPoster())
                                .placeholder(R.drawable.ic_photo_load)
                                .error(R.drawable.ic_broken_image_error)
                                .transform(new RoundedCorners(10))
                                .into(contentDetailMoviesBinding.ivPosterDetail);
                        Glide.with(this)
                                .load(detailMoviesEntity.data.getBackdrop())
                                .placeholder(R.drawable.ic_photo_load)
                                .error(R.drawable.ic_broken_image_error)
                                .into(contentDetailMoviesBinding.ivBackdropDetail);
                        contentDetailMoviesBinding.tvRatingDetail.setText(detailMoviesEntity.data.getRating());
                        contentDetailMoviesBinding.tvReleaseDateDetail.setText(detailMoviesEntity.data.getReleaseDate());
                        contentDetailMoviesBinding.tvTitleDetail.setText(detailMoviesEntity.data.getTitle());
                        contentDetailMoviesBinding.tvTaglineDetail.setText(detailMoviesEntity.data.getTagline());
                        contentDetailMoviesBinding.tvOverviewDetail.setText(detailMoviesEntity.data.getOverview());

                        float rating = Float.parseFloat(detailMoviesEntity.data.getRating());
                        contentDetailMoviesBinding.ratingBar.setRating(rating/2);

                        favoriteAddUpdateViewModel.findMovieById(id).observe(this, favoriteMoviesEntities -> {
                            if (!favoriteMoviesEntities.isEmpty()) {
//                                contentDetailMoviesBinding.fabAdd.setVisibility(View.GONE);
                                contentDetailMoviesBinding.ibFavorite.setImageResource(R.drawable.ic_baseline_favorite_24);
                                contentDetailMoviesBinding.ibFavorite.setOnClickListener(view -> {
                                    favoriteAddUpdateViewModel.deleteFavoriteMoviesById(id);
                                    Toast.makeText(this, R.string.toast_hapus, Toast.LENGTH_SHORT).show();
                                });
                            } else {
                                favoriteMoviesEntity = new FavoriteMoviesEntity();
//                                contentDetailMoviesBinding.fabAdd.setVisibility(View.VISIBLE);
                                contentDetailMoviesBinding.ibFavorite.setImageResource(R.drawable.ic_outline_favorite_border_24);
                                contentDetailMoviesBinding.ibFavorite.setOnClickListener(view -> {
                                    insertFavMovies(id, factory);
                                    Toast.makeText(this, R.string.toast_tambah, Toast.LENGTH_SHORT).show();
                                });
                            }
                        });
                        break;
                    case ERROR:
                        activityDetailBinding.progressBar.setVisibility(View.GONE);
                        Toast.makeText(this, getString(R.string.kesalahan), Toast.LENGTH_SHORT).show();
                        break;
                }
            }
        });
    }

    private void detailTvshows(String id, ViewModelFactory factory) {
        DetailTvShowsViewModel detailTvShowsViewModel = new ViewModelProvider(this, factory).get(DetailTvShowsViewModel.class);

        detailTvShowsViewModel.getDetailTvShows(id).observe(this, detailTvShowsEntity -> {
            if (detailTvShowsEntity != null) {
                switch (detailTvShowsEntity.status) {
                    case LOADING:
                        activityDetailBinding.progressBar.setVisibility(View.VISIBLE);
                        break;
                    case SUCCESS:
                        activityDetailBinding.progressBar.setVisibility(View.GONE);
                        Glide.with(this)
                                .load(detailTvShowsEntity.data.getPoster())
                                .placeholder(R.drawable.ic_photo_load)
                                .error(R.drawable.ic_broken_image_error)
                                .transform(new RoundedCorners(10))
                                .into(contentDetailMoviesBinding.ivPosterDetail);
                        Glide.with(this)
                                .load(detailTvShowsEntity.data.getBackdrop())
                                .placeholder(R.drawable.ic_photo_load)
                                .error(R.drawable.ic_broken_image_error)
                                .into(contentDetailMoviesBinding.ivBackdropDetail);
                        contentDetailMoviesBinding.tvRatingDetail.setText(detailTvShowsEntity.data.getRating());
                        contentDetailMoviesBinding.tvReleaseDateDetail.setText(detailTvShowsEntity.data.getReleaseDate());
                        contentDetailMoviesBinding.tvTitleDetail.setText(detailTvShowsEntity.data.getTitle());
                        contentDetailMoviesBinding.tvTaglineDetail.setText(detailTvShowsEntity.data.getTagline());
                        contentDetailMoviesBinding.tvOverviewDetail.setText(detailTvShowsEntity.data.getOverview());

                        float rating = Float.parseFloat(detailTvShowsEntity.data.getRating());
                        contentDetailMoviesBinding.ratingBar.setRating(rating/2);

                        favoriteAddUpdateViewModel.findTvShowById(id).observe(this, favoriteTvShowsEnitities -> {
                            if (!favoriteTvShowsEnitities.isEmpty()) {
//                                contentDetailMoviesBinding.fabAdd.setVisibility(View.GONE);
                                contentDetailMoviesBinding.ibFavorite.setImageResource(R.drawable.ic_baseline_favorite_24);
                                contentDetailMoviesBinding.ibFavorite.setOnClickListener(view -> {
                                    favoriteAddUpdateViewModel.deleteFavoriteTvShowsById(id);
                                    Toast.makeText(this, R.string.toast_hapus, Toast.LENGTH_SHORT).show();
                                });
                            } else {
                                favoriteTvShowsEntity = new FavoriteTvShowsEntity();
//                                contentDetailMoviesBinding.fabAdd.setVisibility(View.VISIBLE);
                                contentDetailMoviesBinding.ibFavorite.setImageResource(R.drawable.ic_outline_favorite_border_24);
                                contentDetailMoviesBinding.ibFavorite.setOnClickListener(view -> {
                                    insertFavTvShows(id, factory);
                                    Toast.makeText(this, R.string.toast_tambah, Toast.LENGTH_SHORT).show();
                                });
                            }
                        });
                        break;
                    case ERROR:
                        activityDetailBinding.progressBar.setVisibility(View.GONE);
                        Toast.makeText(this, getString(R.string.kesalahan), Toast.LENGTH_SHORT).show();
                        break;
                }
            }
        });
    }

    private void insertFavMovies(String id, ViewModelFactory factory) {
        DetailMoviesViewModel detailMoviesViewModel = new ViewModelProvider(this, factory).get(DetailMoviesViewModel.class);

        detailMoviesViewModel.getDetailMovies(id).observe(this, detailMoviesEntity -> {
            if (detailMoviesEntity != null) {
                switch (detailMoviesEntity.status) {
                    case LOADING:
                        activityDetailBinding.progressBar.setVisibility(View.VISIBLE);
//                        contentDetailMoviesBinding.fabAdd.setVisibility(View.GONE);
                        break;
                    case SUCCESS:
                        activityDetailBinding.progressBar.setVisibility(View.GONE);
                        favoriteMoviesEntity.setId(id);
                        favoriteMoviesEntity.setTitle(detailMoviesEntity.data.getTitle());
                        favoriteMoviesEntity.setPoster(detailMoviesEntity.data.getPoster());
                        favoriteMoviesEntity.setBackdrop(detailMoviesEntity.data.getBackdrop());
                        favoriteMoviesEntity.setReleaseDate(detailMoviesEntity.data.getReleaseDate());
                        favoriteMoviesEntity.setRating(detailMoviesEntity.data.getRating());
                        favoriteMoviesEntity.setTagline(detailMoviesEntity.data.getTagline());
                        favoriteMoviesEntity.setOverview(detailMoviesEntity.data.getOverview());
                        favoriteMoviesEntity.setDate(DateHelper.getCurrentDate());

                        favoriteAddUpdateViewModel.insertFavoriteMovies(favoriteMoviesEntity);
                        break;
                    case ERROR:
                        activityDetailBinding.progressBar.setVisibility(View.GONE);
                        Toast.makeText(this, getString(R.string.kesalahan), Toast.LENGTH_SHORT).show();
                        break;
                }
            }
        });
    }

    private void insertFavTvShows(String id, ViewModelFactory factory) {
        DetailTvShowsViewModel detailTvShowsViewModel = new ViewModelProvider(this, factory).get(DetailTvShowsViewModel.class);

        detailTvShowsViewModel.getDetailTvShows(id).observe(this, detailTvShowsEntity -> {
            if (detailTvShowsEntity != null) {
                switch (detailTvShowsEntity.status) {
                    case LOADING:
                        activityDetailBinding.progressBar.setVisibility(View.VISIBLE);
//                        contentDetailMoviesBinding.fabAdd.setVisibility(View.GONE);
                        break;
                    case SUCCESS:
                        activityDetailBinding.progressBar.setVisibility(View.GONE);
                        favoriteTvShowsEntity.setId(id);
                        favoriteTvShowsEntity.setTitle(detailTvShowsEntity.data.getTitle());
                        favoriteTvShowsEntity.setPoster(detailTvShowsEntity.data.getPoster());
                        favoriteTvShowsEntity.setBackdrop(detailTvShowsEntity.data.getBackdrop());
                        favoriteTvShowsEntity.setReleaseDate(detailTvShowsEntity.data.getReleaseDate());
                        favoriteTvShowsEntity.setRating(detailTvShowsEntity.data.getRating());
                        favoriteTvShowsEntity.setTagline(detailTvShowsEntity.data.getTagline());
                        favoriteTvShowsEntity.setOverview(detailTvShowsEntity.data.getOverview());
                        favoriteTvShowsEntity.setDate(DateHelper.getCurrentDate());

                        favoriteAddUpdateViewModel.insertFavoriteTvShows(favoriteTvShowsEntity);
                        break;
                    case ERROR:
                        activityDetailBinding.progressBar.setVisibility(View.GONE);
                        Toast.makeText(this, getString(R.string.kesalahan), Toast.LENGTH_SHORT).show();
                        break;
                }
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        activityDetailBinding = null;
    }

    @NonNull
    private static FavoriteAddUpdateViewModel obtainViewModel(AppCompatActivity activity) {
        ViewModelFactory factory = ViewModelFactory.getInstance(activity);

        return  new ViewModelProvider(activity, factory).get(FavoriteAddUpdateViewModel.class);
    }
}