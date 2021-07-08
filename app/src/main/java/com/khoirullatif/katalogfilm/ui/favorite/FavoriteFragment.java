package com.khoirullatif.katalogfilm.ui.favorite;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.khoirullatif.katalogfilm.databinding.FragmentFavoriteBinding;

public class FavoriteFragment extends Fragment {

    FragmentFavoriteBinding fragmentFavoriteBinding;

    public FavoriteFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        fragmentFavoriteBinding = FragmentFavoriteBinding.inflate(inflater, container, false);
        return fragmentFavoriteBinding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        SectionPagerAdapter sectionPagerAdapter = new SectionPagerAdapter(getContext(), getChildFragmentManager());
        fragmentFavoriteBinding.viewPagerMain.setAdapter(sectionPagerAdapter);
        fragmentFavoriteBinding.tabLayoutMain.setupWithViewPager(fragmentFavoriteBinding.viewPagerMain);

    }
}