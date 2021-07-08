package com.khoirullatif.katalogfilm.ui.spalshcreen;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import androidx.appcompat.app.AppCompatActivity;

import com.khoirullatif.katalogfilm.R;
import com.khoirullatif.katalogfilm.ui.home.MainActivity;

public class SplashScreenActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_splash_screen);

        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }

        final Handler handler = new Handler();
        handler.postDelayed(() -> {
            startActivity(new Intent(getApplicationContext(), MainActivity.class));
            finish();
        }, 2000L);
    }
}

