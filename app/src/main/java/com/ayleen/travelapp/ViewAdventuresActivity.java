package com.ayleen.travelapp;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.ayleen.travelapp.Constants.PREFS_NAME;
import static com.ayleen.travelapp.Constants.PLACES_KEY;

public class ViewAdventuresActivity extends AppCompatActivity {
    Button btnBack;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_adventures);

        // Setting up the Back Button
        btnBack = findViewById(R.id.btnBack);

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

        List<Place> places = loadPlaces();
        Map<String, List<Place>> placesByLocation = organizePlacesByLocation(places);

        LinearLayout layoutButtonContainer = findViewById(R.id.layoutButtonContainer);
        for (String location : placesByLocation.keySet()) {
            Button locationButton = new Button(this);
            locationButton.setText(location);
            locationButton.setOnClickListener(view -> {
                Intent intent = new Intent(ViewAdventuresActivity.this, PlacesListActivity.class);
                intent.putExtra("location", location); // location is the city, state string
                startActivity(intent);
            });
            layoutButtonContainer.addView(locationButton);
        }
    }

    private List<Place> loadPlaces() {
        SharedPreferences prefs = getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);
        String json = prefs.getString(PLACES_KEY, "");
        if (!json.isEmpty()) {
            Gson gson = new Gson();
            Place[] placeArray = gson.fromJson(json, Place[].class);
            return new ArrayList<>(Arrays.asList(placeArray));
        }
        return new ArrayList<>();
    }

    private Map<String, List<Place>> organizePlacesByLocation(List<Place> places) {
        Map<String, List<Place>> placesByLocation = new HashMap<>();
        for (Place place : places) {
            String key = place.getCity() + ", " + place.getState();
            if (!placesByLocation.containsKey(key)) {
                placesByLocation.put(key, new ArrayList<>());
            }
            placesByLocation.get(key).add(place);
        }
        return placesByLocation;
    }
}
