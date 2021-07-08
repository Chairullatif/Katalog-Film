package com.khoirullatif.katalogfilm.ui.home;

import android.view.View;

import androidx.test.core.app.ActivityScenario;
import androidx.test.espresso.IdlingRegistry;
import androidx.test.espresso.UiController;
import androidx.test.espresso.ViewAction;
import androidx.test.espresso.contrib.RecyclerViewActions;
import androidx.test.platform.app.InstrumentationRegistry;

import com.khoirullatif.katalogfilm.R;
import com.khoirullatif.katalogfilm.utils.EspressoIdlingResources;

import org.hamcrest.Matcher;
import org.junit.After;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.Espresso.openActionBarOverflowOrOptionsMenu;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.swipeLeft;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class MainActivityTest {

    @Before
    public void setUp() {
        ActivityScenario.launch(MainActivity.class);
        IdlingRegistry.getInstance().register(EspressoIdlingResources.getEspressoIdlingResource());
    }

    @After
    public void tearDown() {
        IdlingRegistry.getInstance().unregister(EspressoIdlingResources.getEspressoIdlingResource());
    }

    @Test
    public void aloadMovies() {
        onView(withId(R.id.nav_movies)).perform(click());
        onView(withId(R.id.rv_movies)).check(matches(isDisplayed()));
    }

    @Test
    public void bloadDetailMovies() {
        onView(withId(R.id.nav_movies)).perform(click());
        onView(withId(R.id.rv_movies)).perform(RecyclerViewActions.actionOnItemAtPosition(0, click()));
        onView(withId(R.id.iv_poster_detail)).check(matches(isDisplayed()));
        onView(withId(R.id.iv_backdrop_detail)).check(matches(isDisplayed()));
        onView(withId(R.id.tv_rating_detail)).check(matches(isDisplayed()));
        onView(withId(R.id.tv_release_date_detail)).check(matches(isDisplayed()));
        onView(withId(R.id.tv_title_detail)).check(matches(isDisplayed()));
        onView(withId(R.id.tv_tagline_detail)).check(matches(isDisplayed()));
        onView(withId(R.id.tv_overview_detail)).check(matches(isDisplayed()));
        onView(withId(R.id.fab_add)).check(matches(isDisplayed()));
    }

    @Test
    public void cloadTvShows() {
        onView(withId(R.id.nav_tv_show)).perform(click());
        onView(withId(R.id.rv_tvShows)).check(matches(isDisplayed()));
    }

    @Test
    public void dloadDetailTvShow() {
        onView(withId(R.id.nav_tv_show)).perform(click());
        onView(withId(R.id.rv_tvShows)).perform(RecyclerViewActions.actionOnItemAtPosition(0, click()));
        onView(withId(R.id.iv_poster_detail)).check(matches(isDisplayed()));
        onView(withId(R.id.iv_backdrop_detail)).check(matches(isDisplayed()));
        onView(withId(R.id.tv_rating_detail)).check(matches(isDisplayed()));
        onView(withId(R.id.tv_release_date_detail)).check(matches(isDisplayed()));
        onView(withId(R.id.tv_title_detail)).check(matches(isDisplayed()));
        onView(withId(R.id.tv_tagline_detail)).check(matches(isDisplayed()));
        onView(withId(R.id.tv_overview_detail)).check(matches(isDisplayed()));
        onView(withId(R.id.fab_add)).check(matches(isDisplayed()));
    }

    @Test
    public void eaddMoviesFavorite() {
        onView(withId(R.id.nav_movies)).perform(click());
        onView(withId(R.id.rv_movies)).perform(RecyclerViewActions.actionOnItemAtPosition(1, click()));
        onView(withId(R.id.iv_poster_detail)).check(matches(isDisplayed()));
        onView(withId(R.id.iv_backdrop_detail)).check(matches(isDisplayed()));
        onView(withId(R.id.tv_rating_detail)).check(matches(isDisplayed()));
        onView(withId(R.id.tv_release_date_detail)).check(matches(isDisplayed()));
        onView(withId(R.id.tv_title_detail)).check(matches(isDisplayed()));
        onView(withId(R.id.tv_tagline_detail)).check(matches(isDisplayed()));
        onView(withId(R.id.tv_overview_detail)).check(matches(isDisplayed()));

        onView(withId(R.id.fab_add)).check(matches(isDisplayed()));
        onView(withId(R.id.fab_add)).perform(click());
    }

    @Test
    public void faddTvShowFavorite() {
        onView(withId(R.id.nav_tv_show)).perform(click());
        onView(withId(R.id.rv_tvShows)).perform(RecyclerViewActions.actionOnItemAtPosition(1, click()));
        onView(withId(R.id.iv_poster_detail)).check(matches(isDisplayed()));
        onView(withId(R.id.iv_backdrop_detail)).check(matches(isDisplayed()));
        onView(withId(R.id.tv_rating_detail)).check(matches(isDisplayed()));
        onView(withId(R.id.tv_release_date_detail)).check(matches(isDisplayed()));
        onView(withId(R.id.tv_title_detail)).check(matches(isDisplayed()));
        onView(withId(R.id.tv_tagline_detail)).check(matches(isDisplayed()));
        onView(withId(R.id.tv_overview_detail)).check(matches(isDisplayed()));

        onView(withId(R.id.fab_add)).check(matches(isDisplayed()));
        onView(withId(R.id.fab_add)).perform(click());
    }

    @Test
    public void gloadDetailFavoriteMovies() {
        onView(withId(R.id.nav_favorite)).perform(click());
        onView(withId(R.id.rv_movies_fav)).perform(RecyclerViewActions.actionOnItemAtPosition(0, click()));

        onView(withId(R.id.iv_poster_detail)).check(matches(isDisplayed()));
        onView(withId(R.id.iv_backdrop_detail)).check(matches(isDisplayed()));
        onView(withId(R.id.tv_rating_detail)).check(matches(isDisplayed()));
        onView(withId(R.id.tv_release_date_detail)).check(matches(isDisplayed()));
        onView(withId(R.id.tv_title_detail)).check(matches(isDisplayed()));
        onView(withId(R.id.tv_tagline_detail)).check(matches(isDisplayed()));
        onView(withId(R.id.tv_overview_detail)).check(matches(isDisplayed()));
    }

    @Test
    public void hloadDeleteFavoriteMovies() {
        onView(withId(R.id.nav_favorite)).perform(click());
        openActionBarOverflowOrOptionsMenu(InstrumentationRegistry.getInstrumentation().getTargetContext());
        onView(withText(R.string.newest)).perform(click());
        openActionBarOverflowOrOptionsMenu(InstrumentationRegistry.getInstrumentation().getTargetContext());
        onView(withText(R.string.oldest)).perform(click());
        openActionBarOverflowOrOptionsMenu(InstrumentationRegistry.getInstrumentation().getTargetContext());
        onView(withText(R.string.random)).perform(click());

        onView(withId(R.id.rv_movies_fav)).perform(RecyclerViewActions.actionOnItemAtPosition(0, clickChildViewWithId(R.id.floatingActionButton)));
    }

    @Test
    public void iloadDetailFavoriteTvShow() {
        onView(withId(R.id.nav_favorite)).perform(click());
        onView(withId(R.id.view_pager_main)).perform(swipeLeft());
        onView(withId(R.id.rv_tvShows_fav)).perform(RecyclerViewActions.actionOnItemAtPosition(0, click()));

        onView(withId(R.id.iv_poster_detail)).check(matches(isDisplayed()));
        onView(withId(R.id.iv_backdrop_detail)).check(matches(isDisplayed()));
        onView(withId(R.id.tv_rating_detail)).check(matches(isDisplayed()));
        onView(withId(R.id.tv_release_date_detail)).check(matches(isDisplayed()));
        onView(withId(R.id.tv_title_detail)).check(matches(isDisplayed()));
        onView(withId(R.id.tv_tagline_detail)).check(matches(isDisplayed()));
        onView(withId(R.id.tv_overview_detail)).check(matches(isDisplayed()));
    }

    @Test
    public void jloadDeleteFavoriteTvShows() {
        onView(withId(R.id.nav_favorite)).perform(click());
        onView(withId(R.id.view_pager_main)).perform(swipeLeft());
        openActionBarOverflowOrOptionsMenu(InstrumentationRegistry.getInstrumentation().getTargetContext());
        onView(withText(R.string.newest)).perform(click());
        openActionBarOverflowOrOptionsMenu(InstrumentationRegistry.getInstrumentation().getTargetContext());
        onView(withText(R.string.oldest)).perform(click());
        openActionBarOverflowOrOptionsMenu(InstrumentationRegistry.getInstrumentation().getTargetContext());
        onView(withText(R.string.random)).perform(click());

        onView(withId(R.id.rv_tvShows_fav)).perform(RecyclerViewActions.actionOnItemAtPosition(0, clickChildViewWithId(R.id.floatingActionButton)));

    }

    public static ViewAction clickChildViewWithId(final int id) {
        return new ViewAction() {
            @Override
            public Matcher<View> getConstraints() {
                return null;
            }

            @Override
            public String getDescription() {
                return null;
            }

            @Override
            public void perform(UiController uiController, View view) {
                View v = view.findViewById(id);
                v.performClick();
            }
        };
    }
}