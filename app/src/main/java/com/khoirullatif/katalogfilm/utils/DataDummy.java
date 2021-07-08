package com.khoirullatif.katalogfilm.utils;


import com.khoirullatif.katalogfilm.data.source.local.entity.DetailMoviesEntity;
import com.khoirullatif.katalogfilm.data.source.local.entity.DetailTvShowsEntity;
import com.khoirullatif.katalogfilm.data.source.local.entity.FavoriteMoviesEntity;
import com.khoirullatif.katalogfilm.data.source.local.entity.FavoriteTvShowsEntity;
import com.khoirullatif.katalogfilm.data.source.local.entity.MoviesEntity;
import com.khoirullatif.katalogfilm.data.source.local.entity.TvShowsEntity;
import com.khoirullatif.katalogfilm.data.source.remote.response.DetailMoviesResponse;
import com.khoirullatif.katalogfilm.data.source.remote.response.DetailTvShowsResponse;
import com.khoirullatif.katalogfilm.data.source.remote.response.MoviesResponse;
import com.khoirullatif.katalogfilm.data.source.remote.response.TvShowsResponse;

import java.util.ArrayList;
import java.util.List;

public class DataDummy {

    public static List<MoviesEntity> generateDummyMovies() {

        ArrayList<MoviesEntity> movies = new ArrayList<>();

        movies.add(new MoviesEntity("560144",
                "Skylines",
                "/2W4ZvACURDyhiNnSIaFPHfNbny3.jpg",
                "2020-12-18",
                "5.8"
        ));
        movies.add(new MoviesEntity("464052",
                "Wonder Woman 1984",
                "/8UlWHLMpgZm9bx6QYh0NFoq67TZ.jpg",
                "2020-12-16",
                "7.1"
        ));
        movies.add(new MoviesEntity("508442",
                "Soul",
                "/hm58Jw4Lw8OIeECIq5qyPYhAeRJ.jpg",
                "2020-12-25",
                "8.3"
        ));
        movies.add(new MoviesEntity("651571",
                "Breach",
                "/13B6onhL6FzSN2KaNeQeMML05pS.jpg",
                "2020-12-17",
                "4.1"
        ));
        movies.add(new MoviesEntity("553604",
                "Honest Thief",
                "/zeD4PabP6099gpE0STWJrJrCBCs.jpg",
                "2020-09-03",
                "6.6"
        ));
        movies.add(new MoviesEntity("737568",
                "The Doorman",
                "/pklyUbh4k1DbHdnsOMASyw7C6NH.jpg",
                "2020-10-01",
                "6"
        ));
        movies.add(new MoviesEntity("577922",
                "Tenet",
                "/k68nPLbIST6NP96JmTxmZijEvCA.jpg",
                "2020-08-22",
                "7.3"
        ));
        movies.add(new MoviesEntity("755812",
                "Miraculous World: New York, United HeroeZ",
                "/50AlM1eAqXHEG8Z5lzrTbWyiew9.jpg",
                "2020-10-10",
                "8.5"
        ));
        movies.add(new MoviesEntity("775996",
                "Outside the Wire",
                "/e6SK2CAbO3ENy52UTzP3lv32peC.jpg",
                "2021-01-15",
                "6.5"
        ));
        movies.add(new MoviesEntity("732450",
                "Batman: Soul of the Dragon",
                "/jzhbZZWHMOxVF9uz8lNilDEx8dl.jpg",
                "2021-01-12",
                "7.5"
        ));
        movies.add(new MoviesEntity("529203",
                "The Croods: A New Age",
                "/tK1zy5BsCt1J4OzoDicXmr0UTFH.jpg",
                "2020-11-25",
                "7.7"
        ));
        movies.add(new MoviesEntity("539885", "Ava",
                "/qzA87Wf4jo1h8JMk9GilyIYvwsA.jpg",
                "2020-07-02",
                "5.6"
        ));

        return movies;
    }

    public static DetailMoviesEntity generateDummyDetailMovies() {

        return new DetailMoviesEntity(
                "560144",
                "/2W4ZvACURDyhiNnSIaFPHfNbny3.jpg",
                "/3ombg55JQiIpoPnXYb2oYdr6DtP.jpg",
                "2020-12-18",
                "Skylines",
                "5.8",
                "To save our world she must invade theirs.",
                "When a virus threatens to turn the now earth-dwelling friendly alien hybrids against humans, Captain Rose Corley must lead a team of elite mercenaries on a mission to the alien world in order to save what's left of humanity."
                );
    }

    public static List<TvShowsEntity> generateDummyTvShows() {

        ArrayList<TvShowsEntity> tvShows = new ArrayList<>();

        tvShows.add(new TvShowsEntity("85271",
                "WandaVision",
                "/glKDfE6btIRcVB5zrjspRIs4r52.jpg",
                "2021-01-15",
                "8.5"
        ));
        tvShows.add(new TvShowsEntity("69050",
                "Riverdale",
                "/wRbjVBdDo5qHAEOVYoMWpM58FSA.jpg",
                "2021-01-20",
                "8.6"
        ));
        tvShows.add(new TvShowsEntity("77169",
                "Cobra Kai",
                "/obLBdhLxheKg8Li1qO11r2SwmYO.jpg",
                "2018-05-02",
                "8.1"
        ));
        tvShows.add(new TvShowsEntity("82856",
                "The Mandalorian",
                "/sWgBv7LV2PRoQgkxwlibdGXKz1S.jpg",
                "2019-11-12",
                "8.5"
        ));
        tvShows.add(new TvShowsEntity("71712",
                "The Good Doctor",
                "/6tfT03sGp9k4c0J3dypjrI8TSAI.jpg",
                "2017-09-25",
                "8.6"
        ));
        tvShows.add(new TvShowsEntity("44217",
                "Vikings",
                "/bQLrHIRNEkE3PdIWQrZHynQZazu.jpg",
                "2013-03-03",
                "8"
        ));
        tvShows.add(new TvShowsEntity("96677",
                "Lupin",
                "/sgxawbFB5Vi5OkPWQLNfl3dvkNJ.jpg",
                "2021-01-08",
                "8"
        ));
        tvShows.add(new TvShowsEntity("1416",
                "Grey's Anatomy",
                "/clnyhPqj1SNgpAdeSS6a6fwE6Bo.jpg",
                "2005-03-27",
                "8.2"
        ));
        tvShows.add(new TvShowsEntity("79242",
                "Chilling Adventures of Sabrina",
                "/yxMpoHO0CXP5o9gB7IfsciilQS4.jpg",
                "2018-10-26",
                "8.4"
        ));
        tvShows.add(new TvShowsEntity("91239",
                "Bridgerton",
                "/qaewZKBKmXjb4ZfFBb1LCug6BE8.jpg",
                "2020-12-25",
                "8.3"
        ));
        tvShows.add(new TvShowsEntity("63174",
                "Lucifer",
                "/4EYPN5mVIhKLfxGruy7Dy41dTVn.jpg",
                "2016-01-25",
                "8.5"
        ));
        tvShows.add(new TvShowsEntity("88055",
                "Servant",
                "/8yfkkAeoI77opqAvB9fyf4knftS.jpg",
                "2019-11-28",
                "7.7"
        ));

        return tvShows;
    }

    public static DetailTvShowsEntity generateDummyDetailTvShows() {

        return new DetailTvShowsEntity(
                "85271",
                "/glKDfE6btIRcVB5zrjspRIs4r52.jpg",
                "/57vVjteucIF3bGnZj6PmaoJRScw.jpg",
                "2021-01-15",
                "WandaVision",
                "8.5",
                "Experience a new vision of reality.",
                "Wanda Maximoff and Vision—two super-powered beings living idealized suburban lives—begin to suspect that everything is not as it seems."
                );
    }

    public static List<MoviesResponse> generateRemoteDummyMovies() {

        ArrayList<MoviesResponse> movies = new ArrayList<>();

        movies.add(new MoviesResponse("560144",
                "Skylines",
                "/2W4ZvACURDyhiNnSIaFPHfNbny3.jpg",
                "2020-12-18",
                "5.8"
        ));
        movies.add(new MoviesResponse("464052",
                "Wonder Woman 1984",
                "/8UlWHLMpgZm9bx6QYh0NFoq67TZ.jpg",
                "2020-12-16",
                "7.1"
        ));
        movies.add(new MoviesResponse("508442",
                "Soul",
                "/hm58Jw4Lw8OIeECIq5qyPYhAeRJ.jpg",
                "2020-12-25",
                "8.3"
        ));
        movies.add(new MoviesResponse("651571",
                "Breach",
                "/13B6onhL6FzSN2KaNeQeMML05pS.jpg",
                "2020-12-17",
                "4.1"
        ));
        movies.add(new MoviesResponse("553604",
                "Honest Thief",
                "/zeD4PabP6099gpE0STWJrJrCBCs.jpg",
                "2020-09-03",
                "6.6"
        ));
        movies.add(new MoviesResponse("737568",
                "The Doorman",
                "/pklyUbh4k1DbHdnsOMASyw7C6NH.jpg",
                "2020-10-01",
                "6"
        ));
        movies.add(new MoviesResponse("577922",
                "Tenet",
                "/k68nPLbIST6NP96JmTxmZijEvCA.jpg",
                "2020-08-22",
                "7.3"
        ));
        movies.add(new MoviesResponse("755812",
                "Miraculous World: New York, United HeroeZ",
                "/50AlM1eAqXHEG8Z5lzrTbWyiew9.jpg",
                "2020-10-10",
                "8.5"
        ));
        movies.add(new MoviesResponse("775996",
                "Outside the Wire",
                "/e6SK2CAbO3ENy52UTzP3lv32peC.jpg",
                "2021-01-15",
                "6.5"
        ));
        movies.add(new MoviesResponse("732450",
                "Batman: Soul of the Dragon",
                "/jzhbZZWHMOxVF9uz8lNilDEx8dl.jpg",
                "2021-01-12",
                "7.5"
        ));
        movies.add(new MoviesResponse("529203",
                "The Croods: A New Age",
                "/tK1zy5BsCt1J4OzoDicXmr0UTFH.jpg",
                "2020-11-25",
                "7.7"
        ));
        movies.add(new MoviesResponse("539885", "Ava",
                "/qzA87Wf4jo1h8JMk9GilyIYvwsA.jpg",
                "2020-07-02",
                "5.6"
        ));

        return movies;
    }

    public static DetailMoviesResponse generateRemoteDummyDetailMovies() {

        DetailMoviesResponse movie = new DetailMoviesResponse("560144",
                "/2W4ZvACURDyhiNnSIaFPHfNbny3.jpg",
                "/3ombg55JQiIpoPnXYb2oYdr6DtP.jpg",
                "2020-12-18",
                "Skylines",
                "5.8",
                "To save our world she must invade theirs.",
                "When a virus threatens to turn the now earth-dwelling friendly alien hybrids against humans, Captain Rose Corley must lead a team of elite mercenaries on a mission to the alien world in order to save what's left of humanity.");
        return movie;
    }

    public static List<TvShowsResponse> generateRemoteDummyTvShows() {

        ArrayList<TvShowsResponse> tvShows = new ArrayList<>();

        tvShows.add(new TvShowsResponse("85271",
                "WandaVision",
                "/glKDfE6btIRcVB5zrjspRIs4r52.jpg",
                "2021-01-15",
                "8.5"
        ));
        tvShows.add(new TvShowsResponse("69050",
                "Riverdale",
                "/wRbjVBdDo5qHAEOVYoMWpM58FSA.jpg",
                "2021-01-20",
                "8.6"
        ));
        tvShows.add(new TvShowsResponse("77169",
                "Cobra Kai",
                "/obLBdhLxheKg8Li1qO11r2SwmYO.jpg",
                "2018-05-02",
                "8.1"
        ));
        tvShows.add(new TvShowsResponse("82856",
                "The Mandalorian",
                "/sWgBv7LV2PRoQgkxwlibdGXKz1S.jpg",
                "2019-11-12",
                "8.5"
        ));
        tvShows.add(new TvShowsResponse("71712",
                "The Good Doctor",
                "/6tfT03sGp9k4c0J3dypjrI8TSAI.jpg",
                "2017-09-25",
                "8.6"
        ));
        tvShows.add(new TvShowsResponse("44217",
                "Vikings",
                "/bQLrHIRNEkE3PdIWQrZHynQZazu.jpg",
                "2013-03-03",
                "8"
        ));
        tvShows.add(new TvShowsResponse("96677",
                "Lupin",
                "/sgxawbFB5Vi5OkPWQLNfl3dvkNJ.jpg",
                "2021-01-08",
                "8"
        ));
        tvShows.add(new TvShowsResponse("1416",
                "Grey's Anatomy",
                "/clnyhPqj1SNgpAdeSS6a6fwE6Bo.jpg",
                "2005-03-27",
                "8.2"
        ));
        tvShows.add(new TvShowsResponse("79242",
                "Chilling Adventures of Sabrina",
                "/yxMpoHO0CXP5o9gB7IfsciilQS4.jpg",
                "2018-10-26",
                "8.4"
        ));
        tvShows.add(new TvShowsResponse("91239",
                "Bridgerton",
                "/qaewZKBKmXjb4ZfFBb1LCug6BE8.jpg",
                "2020-12-25",
                "8.3"
        ));
        tvShows.add(new TvShowsResponse("63174",
                "Lucifer",
                "/4EYPN5mVIhKLfxGruy7Dy41dTVn.jpg",
                "2016-01-25",
                "8.5"
        ));
        tvShows.add(new TvShowsResponse("88055",
                "Servant",
                "/8yfkkAeoI77opqAvB9fyf4knftS.jpg",
                "2019-11-28",
                "7.7"
        ));

        return tvShows;
    }

    public static DetailTvShowsResponse generateRemoteDummyDetailTvShows() {

        DetailTvShowsResponse tvShow = new DetailTvShowsResponse("85271",
                "/glKDfE6btIRcVB5zrjspRIs4r52.jpg",
                "/57vVjteucIF3bGnZj6PmaoJRScw.jpg",
                "2021-01-15",
                "WandaVision",
                "8.5",
                "Experience a new vision of reality.",
                "Wanda Maximoff and Vision—two super-powered beings living idealized suburban lives—begin to suspect that everything is not as it seems.");

//        tvShow.setPoster("/glKDfE6btIRcVB5zrjspRIs4r52.jpg");
//        tvShow.setBackdrop("/57vVjteucIF3bGnZj6PmaoJRScw.jpg");
//        tvShow.setReleaseDate("2021-01-15");
//        tvShow.setTitle("WandaVision");
//        tvShow.setRating("8.5");
//        tvShow.setTagline("Experience a new vision of reality.");
//        tvShow.setOverview( "Wanda Maximoff and Vision—two super-powered beings living idealized suburban lives—begin to suspect that everything is not as it seems.");

        return tvShow;
    }

    public static List<FavoriteMoviesEntity> generateFavoriteDummyMovies() {

        ArrayList<FavoriteMoviesEntity> favoriteMovies = new ArrayList<>();

        favoriteMovies.add(new FavoriteMoviesEntity("85271",
                "/2W4ZvACURDyhiNnSIaFPHfNbny3.jpg",
                "/3ombg55JQiIpoPnXYb2oYdr6DtP.jpg",
                "2020-12-18",
                "Skylines",
                "5.8",
                "To save our world she must invade theirs.",
                "When a virus threatens to turn the now earth-dwelling friendly alien hybrids against humans, Captain Rose Corley must lead a team of elite mercenaries on a mission to the alien world in order to save what's left of humanity.",
                "10/20/2021"
        ));
        favoriteMovies.add(new FavoriteMoviesEntity("85272",
                "/2W4ZvACURDyhiNnSIaFPHfNbny3.jpg",
                "/3ombg55JQiIpoPnXYb2oYdr6DtP.jpg",
                "2020-12-18",
                "Skylines",
                "5.8",
                "To save our world she must invade theirs.",
                "When a virus threatens to turn the now earth-dwelling friendly alien hybrids against humans, Captain Rose Corley must lead a team of elite mercenaries on a mission to the alien world in order to save what's left of humanity.",
                "10/20/2021"
        ));
        favoriteMovies.add(new FavoriteMoviesEntity("85273",
                "/2W4ZvACURDyhiNnSIaFPHfNbny3.jpg",
                "/3ombg55JQiIpoPnXYb2oYdr6DtP.jpg",
                "2020-12-18",
                "Skylines",
                "5.8",
                "To save our world she must invade theirs.",
                "When a virus threatens to turn the now earth-dwelling friendly alien hybrids against humans, Captain Rose Corley must lead a team of elite mercenaries on a mission to the alien world in order to save what's left of humanity.",
                "10/20/2021"
        ));
        favoriteMovies.add(new FavoriteMoviesEntity("85274",
                "/2W4ZvACURDyhiNnSIaFPHfNbny3.jpg",
                "/3ombg55JQiIpoPnXYb2oYdr6DtP.jpg",
                "2020-12-18",
                "Skylines",
                "5.8",
                "To save our world she must invade theirs.",
                "When a virus threatens to turn the now earth-dwelling friendly alien hybrids against humans, Captain Rose Corley must lead a team of elite mercenaries on a mission to the alien world in order to save what's left of humanity.",
                "10/20/2021"
        ));
        favoriteMovies.add(new FavoriteMoviesEntity("85275",
                "/2W4ZvACURDyhiNnSIaFPHfNbny3.jpg",
                "/3ombg55JQiIpoPnXYb2oYdr6DtP.jpg",
                "2020-12-18",
                "Skylines",
                "5.8",
                "To save our world she must invade theirs.",
                "When a virus threatens to turn the now earth-dwelling friendly alien hybrids against humans, Captain Rose Corley must lead a team of elite mercenaries on a mission to the alien world in order to save what's left of humanity.",
                "10/20/2021"
        ));

        return favoriteMovies;
    }
    public static List<FavoriteMoviesEntity> generateRemoteFavoriteDummyMovies() {

        ArrayList<FavoriteMoviesEntity> favoriteMovies = new ArrayList<>();

        favoriteMovies.add(new FavoriteMoviesEntity("85271",
                "/2W4ZvACURDyhiNnSIaFPHfNbny3.jpg",
                "/3ombg55JQiIpoPnXYb2oYdr6DtP.jpg",
                "2020-12-18",
                "Skylines",
                "5.8",
                "To save our world she must invade theirs.",
                "When a virus threatens to turn the now earth-dwelling friendly alien hybrids against humans, Captain Rose Corley must lead a team of elite mercenaries on a mission to the alien world in order to save what's left of humanity.",
                "10/20/2021"
        ));
        favoriteMovies.add(new FavoriteMoviesEntity("85272",
                "/2W4ZvACURDyhiNnSIaFPHfNbny3.jpg",
                "/3ombg55JQiIpoPnXYb2oYdr6DtP.jpg",
                "2020-12-18",
                "Skylines",
                "5.8",
                "To save our world she must invade theirs.",
                "When a virus threatens to turn the now earth-dwelling friendly alien hybrids against humans, Captain Rose Corley must lead a team of elite mercenaries on a mission to the alien world in order to save what's left of humanity.",
                "10/20/2021"
        ));
        favoriteMovies.add(new FavoriteMoviesEntity("85273",
                "/2W4ZvACURDyhiNnSIaFPHfNbny3.jpg",
                "/3ombg55JQiIpoPnXYb2oYdr6DtP.jpg",
                "2020-12-18",
                "Skylines",
                "5.8",
                "To save our world she must invade theirs.",
                "When a virus threatens to turn the now earth-dwelling friendly alien hybrids against humans, Captain Rose Corley must lead a team of elite mercenaries on a mission to the alien world in order to save what's left of humanity.",
                "10/20/2021"
        ));
        favoriteMovies.add(new FavoriteMoviesEntity("85274",
                "/2W4ZvACURDyhiNnSIaFPHfNbny3.jpg",
                "/3ombg55JQiIpoPnXYb2oYdr6DtP.jpg",
                "2020-12-18",
                "Skylines",
                "5.8",
                "To save our world she must invade theirs.",
                "When a virus threatens to turn the now earth-dwelling friendly alien hybrids against humans, Captain Rose Corley must lead a team of elite mercenaries on a mission to the alien world in order to save what's left of humanity.",
                "10/20/2021"
        ));
        favoriteMovies.add(new FavoriteMoviesEntity("85275",
                "/2W4ZvACURDyhiNnSIaFPHfNbny3.jpg",
                "/3ombg55JQiIpoPnXYb2oYdr6DtP.jpg",
                "2020-12-18",
                "Skylines",
                "5.8",
                "To save our world she must invade theirs.",
                "When a virus threatens to turn the now earth-dwelling friendly alien hybrids against humans, Captain Rose Corley must lead a team of elite mercenaries on a mission to the alien world in order to save what's left of humanity.",
                "10/20/2021"
        ));

        return favoriteMovies;
    }

    public static List<FavoriteTvShowsEntity> generateFavoriteDummyTvShows() {

        ArrayList<FavoriteTvShowsEntity> favoriteTvShows = new ArrayList<>();

        favoriteTvShows.add(new FavoriteTvShowsEntity("2285271",
                "/2W4ZvACURDyhiNnSIaFPHfNbny3.jpg",
                "/3ombg55JQiIpoPnXYb2oYdr6DtP.jpg",
                "2020-12-18",
                "Skylines",
                "5.8",
                "To save our world she must invade theirs.",
                "When a virus threatens to turn the now earth-dwelling friendly alien hybrids against humans, Captain Rose Corley must lead a team of elite mercenaries on a mission to the alien world in order to save what's left of humanity.",
                "10/20/2021"
        ));
        favoriteTvShows.add(new FavoriteTvShowsEntity("2285272",
                "/2W4ZvACURDyhiNnSIaFPHfNbny3.jpg",
                "/3ombg55JQiIpoPnXYb2oYdr6DtP.jpg",
                "2020-12-18",
                "Skylines",
                "5.8",
                "To save our world she must invade theirs.",
                "When a virus threatens to turn the now earth-dwelling friendly alien hybrids against humans, Captain Rose Corley must lead a team of elite mercenaries on a mission to the alien world in order to save what's left of humanity.",
                "10/20/2021"
        ));
        favoriteTvShows.add(new FavoriteTvShowsEntity("2285273",
                "/2W4ZvACURDyhiNnSIaFPHfNbny3.jpg",
                "/3ombg55JQiIpoPnXYb2oYdr6DtP.jpg",
                "2020-12-18",
                "Skylines",
                "5.8",
                "To save our world she must invade theirs.",
                "When a virus threatens to turn the now earth-dwelling friendly alien hybrids against humans, Captain Rose Corley must lead a team of elite mercenaries on a mission to the alien world in order to save what's left of humanity.",
                "10/20/2021"
        ));
        favoriteTvShows.add(new FavoriteTvShowsEntity("2285273",
                "/2W4ZvACURDyhiNnSIaFPHfNbny3.jpg",
                "/3ombg55JQiIpoPnXYb2oYdr6DtP.jpg",
                "2020-12-18",
                "Skylines",
                "5.8",
                "To save our world she must invade theirs.",
                "When a virus threatens to turn the now earth-dwelling friendly alien hybrids against humans, Captain Rose Corley must lead a team of elite mercenaries on a mission to the alien world in order to save what's left of humanity.",
                "10/20/2021"
        ));
        favoriteTvShows.add(new FavoriteTvShowsEntity("2285274",
                "/2W4ZvACURDyhiNnSIaFPHfNbny3.jpg",
                "/3ombg55JQiIpoPnXYb2oYdr6DtP.jpg",
                "2020-12-18",
                "Skylines",
                "5.8",
                "To save our world she must invade theirs.",
                "When a virus threatens to turn the now earth-dwelling friendly alien hybrids against humans, Captain Rose Corley must lead a team of elite mercenaries on a mission to the alien world in order to save what's left of humanity.",
                "10/20/2021"
        ));

        return favoriteTvShows;
    }
    public static List<FavoriteTvShowsEntity> generateRemoteFavoriteDummyTvShows() {

        ArrayList<FavoriteTvShowsEntity> favoriteTvShows = new ArrayList<>();

        favoriteTvShows.add(new FavoriteTvShowsEntity("2285271",
                "/2W4ZvACURDyhiNnSIaFPHfNbny3.jpg",
                "/3ombg55JQiIpoPnXYb2oYdr6DtP.jpg",
                "2020-12-18",
                "Skylines",
                "5.8",
                "To save our world she must invade theirs.",
                "When a virus threatens to turn the now earth-dwelling friendly alien hybrids against humans, Captain Rose Corley must lead a team of elite mercenaries on a mission to the alien world in order to save what's left of humanity.",
                "10/20/2021"
        ));
        favoriteTvShows.add(new FavoriteTvShowsEntity("2285272",
                "/2W4ZvACURDyhiNnSIaFPHfNbny3.jpg",
                "/3ombg55JQiIpoPnXYb2oYdr6DtP.jpg",
                "2020-12-18",
                "Skylines",
                "5.8",
                "To save our world she must invade theirs.",
                "When a virus threatens to turn the now earth-dwelling friendly alien hybrids against humans, Captain Rose Corley must lead a team of elite mercenaries on a mission to the alien world in order to save what's left of humanity.",
                "10/20/2021"
        ));
        favoriteTvShows.add(new FavoriteTvShowsEntity("2285273",
                "/2W4ZvACURDyhiNnSIaFPHfNbny3.jpg",
                "/3ombg55JQiIpoPnXYb2oYdr6DtP.jpg",
                "2020-12-18",
                "Skylines",
                "5.8",
                "To save our world she must invade theirs.",
                "When a virus threatens to turn the now earth-dwelling friendly alien hybrids against humans, Captain Rose Corley must lead a team of elite mercenaries on a mission to the alien world in order to save what's left of humanity.",
                "10/20/2021"
        ));
        favoriteTvShows.add(new FavoriteTvShowsEntity("2285273",
                "/2W4ZvACURDyhiNnSIaFPHfNbny3.jpg",
                "/3ombg55JQiIpoPnXYb2oYdr6DtP.jpg",
                "2020-12-18",
                "Skylines",
                "5.8",
                "To save our world she must invade theirs.",
                "When a virus threatens to turn the now earth-dwelling friendly alien hybrids against humans, Captain Rose Corley must lead a team of elite mercenaries on a mission to the alien world in order to save what's left of humanity.",
                "10/20/2021"
        ));
        favoriteTvShows.add(new FavoriteTvShowsEntity("2285274",
                "/2W4ZvACURDyhiNnSIaFPHfNbny3.jpg",
                "/3ombg55JQiIpoPnXYb2oYdr6DtP.jpg",
                "2020-12-18",
                "Skylines",
                "5.8",
                "To save our world she must invade theirs.",
                "When a virus threatens to turn the now earth-dwelling friendly alien hybrids against humans, Captain Rose Corley must lead a team of elite mercenaries on a mission to the alien world in order to save what's left of humanity.",
                "10/20/2021"
        ));

        return favoriteTvShows;
    }

}