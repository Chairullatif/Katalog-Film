package com.khoirullatif.katalogfilm.data.source.remote;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.khoirullatif.katalogfilm.BuildConfig;
import com.khoirullatif.katalogfilm.data.source.remote.response.DetailMoviesResponse;
import com.khoirullatif.katalogfilm.data.source.remote.response.DetailTvShowsResponse;
import com.khoirullatif.katalogfilm.data.source.remote.response.MoviesResponse;
import com.khoirullatif.katalogfilm.data.source.remote.response.TvShowsResponse;
import com.khoirullatif.katalogfilm.utils.EspressoIdlingResources;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import cz.msebera.android.httpclient.Header;

public class RemoteDataSource {

    private static RemoteDataSource INSTANCE;

    public static RemoteDataSource getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new RemoteDataSource();
        }
        return INSTANCE;
    }

    public LiveData<ApiResponse<List<MoviesResponse>>> getMovies() {
        EspressoIdlingResources.increment();
        MutableLiveData<ApiResponse<List<MoviesResponse>>> resultMovies = new MutableLiveData<>();
        final ArrayList<MoviesResponse> data = new ArrayList<>();

        String url = BuildConfig.THEMOVIEDB_POPULAR_MOVIES + BuildConfig.THEMOVIEDB_KEY;
        AsyncHttpClient client = new AsyncHttpClient();
        client.get(url, new AsyncHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
                Log.d("onSuccess", "lanjut");
                try {
                    String result = new String(responseBody);
                    JSONObject responObject = new JSONObject(result);
                    JSONArray movieResult = responObject.getJSONArray("results");

                    for (int i = 0; i < movieResult.length(); i++) {

                        String id = String.valueOf(movieResult.getJSONObject(i).getInt("id"));
                        String poster = BuildConfig.THEMOVIEDB_IMAGE + movieResult.getJSONObject(i).getString("poster_path");
                        String title = movieResult.getJSONObject(i).getString("original_title");
                        String releaseDate = movieResult.getJSONObject(i).getString("release_date");
                        String rating = String.valueOf(movieResult.getJSONObject(i).getInt("vote_average"));

                        MoviesResponse moviesResponse = new MoviesResponse(id, title, poster, releaseDate, rating);
                        data.add(moviesResponse);
                    }

                    resultMovies.setValue(ApiResponse.success(data));

                } catch (Exception e) {
                    Log.d("Exception GetMovie", Objects.requireNonNull(e.getMessage()));
                }

            }

            @Override
            public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {
                Log.d("onFailure GetMovie", Objects.requireNonNull(error.getMessage()));
            }

            @Override
            public void onFinish() {
                EspressoIdlingResources.decrement();
                super.onFinish();
            }
        });

        return resultMovies;
    }

    public LiveData<ApiResponse<List<TvShowsResponse>>> getTvShows() {
        EspressoIdlingResources.increment();
        MutableLiveData<ApiResponse<List<TvShowsResponse>>> resultTvShows = new MutableLiveData<>();
        final ArrayList<TvShowsResponse> data = new ArrayList<>();

        String url = BuildConfig.THEMOVIEDB_POPULAR_TV + BuildConfig.THEMOVIEDB_KEY;
        AsyncHttpClient client = new AsyncHttpClient();
        client.get(url, new AsyncHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
                try {
                    String result = new String(responseBody);
                    JSONObject responObject = new JSONObject(result);
                    JSONArray tvResult = responObject.getJSONArray("results");

                    for (int i = 0; i < tvResult.length(); i++) {

                        String id = String.valueOf(tvResult.getJSONObject(i).getInt("id"));
                        String poster = BuildConfig.THEMOVIEDB_IMAGE + tvResult.getJSONObject(i).getString("poster_path");
                        String title = tvResult.getJSONObject(i).getString("name");
                        String releaseDate = tvResult.getJSONObject(i).getString("first_air_date");
                        String rating = String.valueOf(tvResult.getJSONObject(i).getInt("vote_average"));

                        TvShowsResponse tvShowsResponse = new TvShowsResponse(id, title, poster, releaseDate, rating);
                        data.add(tvShowsResponse);
                    }

                    resultTvShows.setValue(ApiResponse.success(data));

                } catch (Exception e) {
                    Log.d("Exception TvVM", Objects.requireNonNull(e.getMessage()));
                }
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {
                Log.d("onFailure TvVM", Objects.requireNonNull(error.getMessage()));
            }

            @Override
            public void onFinish() {
                EspressoIdlingResources.decrement();
                super.onFinish();
            }
        });

        return resultTvShows;
    }

    public MutableLiveData<ApiResponse<DetailMoviesResponse>> getDetailMovie(String movieId) {
        EspressoIdlingResources.increment();
        MutableLiveData<ApiResponse<DetailMoviesResponse>> resultDetailMovie = new MutableLiveData<>();

        String url = String.format(BuildConfig.THEMOVIEDB_DETAIL_MOVIES, movieId) + BuildConfig.THEMOVIEDB_KEY;
        AsyncHttpClient client = new AsyncHttpClient();

        client.get(url, new AsyncHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
                Log.d("DetMovonSucces", "jalan");
                try {
                    String result = new String(responseBody);
                    JSONObject responObject = new JSONObject(result);

                    String backdrop = BuildConfig.THEMOVIEDB_IMAGE + responObject.getString("backdrop_path");
                    String poster = BuildConfig.THEMOVIEDB_IMAGE + responObject.getString("poster_path");
                    String rating = String.valueOf(responObject.getInt("vote_average"));
                    String releaseDate = responObject.getString("release_date");
                    String title = responObject.getString("title");
                    String tagline = responObject.getString("tagline");
                    String overview = responObject.getString("overview");
                    String id = String.valueOf(responObject.getInt("id"));

                    DetailMoviesResponse detailMoviesResponse = new DetailMoviesResponse(
                            id,
                            poster,
                            backdrop,
                            releaseDate,
                            title,
                            rating,
                            tagline,
                            overview
                    );

                    Log.d("cekBackDropMov", detailMoviesResponse.getBackdrop());

                    resultDetailMovie.setValue(ApiResponse.success(detailMoviesResponse));

                } catch (Exception e) {
                    Log.d("onDetailMov", Objects.requireNonNull(e.getMessage()));
                }
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {
                Log.d("DetMovonFail", "not run");
            }

            @Override
            public void onFinish() {
                EspressoIdlingResources.decrement();
                super.onFinish();
            }

        });

        return resultDetailMovie;
    }

    public MutableLiveData<ApiResponse<DetailTvShowsResponse>> getDetailTvShow(String tvShowId) {
        EspressoIdlingResources.increment();
        MutableLiveData<ApiResponse<DetailTvShowsResponse>> resultDetailTvShows = new MutableLiveData<>();

        String url = String.format(BuildConfig.THEMOVIEDB_DETAIL_TV, tvShowId) + BuildConfig.THEMOVIEDB_KEY;
        AsyncHttpClient client = new AsyncHttpClient();

        client.get(url, new AsyncHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
                try {
                    String result = new String(responseBody);
                    JSONObject responObject = new JSONObject(result);

                    String backdrop = BuildConfig.THEMOVIEDB_IMAGE + responObject.getString("backdrop_path");
                    String poster = BuildConfig.THEMOVIEDB_IMAGE + responObject.getString("poster_path");
                    String rating = String.valueOf(responObject.getInt("vote_average"));
                    String releaseDate = responObject.getString("first_air_date");
                    String title = responObject.getString("name");
                    String tagline = responObject.getString("tagline");
                    String overview = responObject.getString("overview");
                    String id = String.valueOf(responObject.getInt("id"));

                    DetailTvShowsResponse detailTvShowsResponse = new DetailTvShowsResponse(
                            id,
                            poster,
                            backdrop,
                            releaseDate,
                            title,
                            rating,
                            tagline,
                            overview
                    );

                    Log.d("cekBackDropTv", detailTvShowsResponse.getBackdrop());

                    resultDetailTvShows.setValue(ApiResponse.success(detailTvShowsResponse));

                } catch (Exception e) {
                    Log.d("onDetailTv", Objects.requireNonNull(e.getMessage()));
                }
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {
                Log.d("DetTvonFail", "not run");
            }

            @Override
            public void onFinish() {
                EspressoIdlingResources.decrement();
                super.onFinish();
            }

        });

        return resultDetailTvShows;
    }
}
