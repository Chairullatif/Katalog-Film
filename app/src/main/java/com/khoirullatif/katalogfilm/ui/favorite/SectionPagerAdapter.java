package com.khoirullatif.katalogfilm.ui.favorite;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.annotation.StringRes;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.khoirullatif.katalogfilm.R;
import com.khoirullatif.katalogfilm.ui.favorite.favmovies.FavoriteMoviesFragment;
import com.khoirullatif.katalogfilm.ui.favorite.favtvshows.FavoriteTvShowsFragment;

public class SectionPagerAdapter extends FragmentPagerAdapter {

    private final Context context;

    public SectionPagerAdapter(Context context, FragmentManager fm) {
        super(fm, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
        this.context = context;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {

        switch (position) {
            case 0:
                return new FavoriteMoviesFragment();
            case 1:
                return new FavoriteTvShowsFragment();
            default:
                return new Fragment();
        }
    }

    @StringRes
    private final int[] TAB_TITLES = new int[]{
            R.string.tab_1,
            R.string.tab_2
    };

    @NonNull
    @Override
    public CharSequence getPageTitle(int position) {
        return context.getResources().getString(TAB_TITLES[position]);
    }

    @Override
    public int getCount() {
        return 2;
    }
}
