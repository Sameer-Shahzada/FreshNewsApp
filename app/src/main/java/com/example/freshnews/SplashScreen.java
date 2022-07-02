package com.example.freshnews;

import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class SplashScreen extends AppCompatActivity {
    // define onCreate method here

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // code for splash screen
        SystemClock.sleep(2000);
        startActivity(new Intent(this, MainActivity.class));
        finish();
    }
}
