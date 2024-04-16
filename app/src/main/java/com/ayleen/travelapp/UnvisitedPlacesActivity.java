package com.ayleen.travelapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class UnvisitedPlacesActivity extends AppCompatActivity {

    Button btnBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_unvisited_places);

        // Setting up the Back Button
        btnBack = findViewById(R.id.btnBack);

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

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
