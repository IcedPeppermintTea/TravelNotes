package com.ayleen.travelapp;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class HomeScreen extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_screen);

        Button btnVisited = findViewById(R.id.buttonVisitedPlaces);
        btnVisited.setOnClickListener(view -> {
            // Intent to navigate to VisitedPlaces Activity
            Intent intent = new Intent(HomeScreen.this, VisitedPlacesActivity.class);
            startActivity(intent);
        });

        Button btnUnvisited = findViewById(R.id.buttonUnvisitedPlaces);
        btnUnvisited.setOnClickListener(view -> {
            // Intent to navigate to UnvisitedPlaces Activity
            Intent intent = new Intent(HomeScreen.this, UnvisitedPlacesActivity.class);
            startActivity(intent);
        });

    }
}