package com.example.githubdemo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.example.githubdemo.activity.mainHome.MainActivity;
import com.example.githubdemo.databinding.ActivityMainBinding;
import com.example.githubdemo.databinding.ActivitySplashBinding;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class Splash extends AppCompatActivity {

    ActivitySplashBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_splash);

        Handler handler = new Handler();
        Runnable r = new Runnable() {
            @Override
            public void run() {
                startActivity(new Intent(Splash.this, MainActivity.class));
            }
        };

        handler.postDelayed(r, 3000);

    }
}