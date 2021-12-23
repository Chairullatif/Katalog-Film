package com.khoirullatif.katalogfilm.ui.home;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
//import androidx.appcompat.widget.Toolbar;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
//import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.khoirullatif.katalogfilm.R;

public class MainActivity extends AppCompatActivity {

    @SuppressLint("NonConstantResourceId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigation);

//        Toolbar toolbar = findViewById(R.id.toolbar);
//
//        setSupportActionBar(toolbar);
        TextView tv_kind = findViewById(R.id.tv_kind);
        getSupportActionBar();

        BottomNavigationView navView = findViewById(R.id.nav_view);
//        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
//                R.id.nav_movies, R.id.nav_tv_show, R.id.nav_favorite)
//                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
//        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);

        navController.addOnDestinationChangedListener((controller, destination, arguments) -> {
            switch (destination.getId()) {
                case R.id.nav_movies:
                    tv_kind.setText(R.string.popular_movie);
                    break;
                case R.id.nav_tv_show:
                    tv_kind.setText(R.string.popular_tvshows);
                    break;
                case R.id.nav_favorite:
                    tv_kind.setText(R.string.favorite);
                    break;
            }
        });
        NavigationUI.setupWithNavController(navView, navController);
    }

}
