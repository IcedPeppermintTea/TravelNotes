package com.ayleen.travelapp;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PlacesListActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_places_list);

        ListView listViewPlaces = findViewById(R.id.listViewPlaces);
        String location = getIntent().getStringExtra("location");
        List<Place> places = getPlacesForLocation(location);

        PlaceAdapter adapter = new PlaceAdapter(this, places);
        listViewPlaces.setAdapter(adapter);
    }

    private List<Place> getPlacesForLocation(String location) {
        SharedPreferences prefs = getSharedPreferences(Constants.PREFS_NAME, Context.MODE_PRIVATE);
        String json = prefs.getString(Constants.PLACES_KEY, "");
        Gson gson = new Gson();
        Place[] placeArray = gson.fromJson(json, Place[].class);
        List<Place> filteredPlaces = new ArrayList<>();
        for (Place place : placeArray) {
            if ((place.getCity() + ", " + place.getState()).equalsIgnoreCase(location)) {
                filteredPlaces.add(place);
            }
        }
        return filteredPlaces;
    }
}
