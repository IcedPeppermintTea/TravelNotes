package com.ayleen.travelapp;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.google.gson.Gson;

import static com.ayleen.travelapp.Constants.PREFS_NAME;
import static com.ayleen.travelapp.Constants.PLACES_KEY;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AddAdventureActivity extends AppCompatActivity {

    Button btnBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_adventure);

        // Setting up the Back Button
        btnBack = findViewById(R.id.btnBack);

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

        EditText editTextPlaceName = findViewById(R.id.editTextPlaceName);
        EditText editTextAddress = findViewById(R.id.editTextAddress);
        EditText editTextCity = findViewById(R.id.editTextCity);
        EditText editTextState = findViewById(R.id.editTextState);
        EditText editTextZip = findViewById(R.id.editTextZip);
        EditText editTextDescription = findViewById(R.id.editTextDescription);

        Button saveButton = findViewById(R.id.buttonSave);
        saveButton.setOnClickListener(view -> {
            Place place = new Place(
                    editTextPlaceName.getText().toString(),
                    editTextAddress.getText().toString(),
                    editTextCity.getText().toString(),
                    editTextState.getText().toString(),
                    editTextZip.getText().toString(),
                    editTextDescription.getText().toString()
            );

            savePlace(place);
            Toast.makeText(this, "Site saved!", Toast.LENGTH_SHORT).show();
            finish(); // Closes the activity, returning to the previous one
        });

    }

    private void savePlace(Place place) {
        SharedPreferences prefs = getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = prefs.edit();
        Gson gson = new Gson();

        // Retrieve the existing places, add the new one, and save them back
        String json = prefs.getString(PLACES_KEY, "");
        List<Place> places = new ArrayList<>();
        if (!json.isEmpty()) {
            Place[] placeArray = gson.fromJson(json, Place[].class);
            places = new ArrayList<>(Arrays.asList(placeArray));
        }
        places.add(place);

        // Convert the list of places back to JSON and save it
        json = gson.toJson(places);
        editor.putString(PLACES_KEY, json);
        editor.apply();
    }
}
