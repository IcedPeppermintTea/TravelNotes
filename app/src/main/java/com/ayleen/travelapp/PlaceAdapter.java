package com.ayleen.travelapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

public class PlaceAdapter extends ArrayAdapter<Place> {
    public PlaceAdapter(Context context, List<Place> places) {
        super(context, 0, places);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Place place = getItem(position);
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.place_item, parent, false);
        }

        TextView textViewName = convertView.findViewById(R.id.textViewPlaceName);
        TextView textViewAddress = convertView.findViewById(R.id.textViewPlaceAddress);
        TextView textViewDescription = convertView.findViewById(R.id.textViewPlaceDescription);

        textViewName.setText("Name: " + place.getName());
        textViewAddress.setText("Address: " + place.getAddress() + ", " + place.getCity() + ", " + place.getState() + " " + place.getZip());
        textViewDescription.setText("Description: " + place.getDescription());

        return convertView;
    }
}
