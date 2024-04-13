package com.ayleen.travelapp;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class UnvisitedPlacesActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_unvisited_places);

        Button addButton = findViewById(R.id.buttonAddAdventure);
        Button viewButton = findViewById(R.id.buttonViewAdventures);

        addButton.setOnClickListener(view -> {
            Intent intent = new Intent(UnvisitedPlacesActivity.this, AddAdventureActivity.class);
            startActivity(intent);
        });

        viewButton.setOnClickListener(view -> {
            Intent intent = new Intent(UnvisitedPlacesActivity.this, ViewAdventuresActivity.class);
            startActivity(intent);
        });
    }
}
