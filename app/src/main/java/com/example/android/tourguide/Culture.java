package com.example.android.tourguide;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;

public class Culture extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.listview, container, false);

        ArrayList<TourItem> tourItems = new ArrayList<TourItem>();
        tourItems.add(new TourItem("Culture", "Fukuoka is bordered by the ocean to the north, east, and west, and " +
                "each of its coastlines has a unique character. Breathtaking views and outdoor activities can be " +
                "enjoyed in the area's mild climate.\n\n" +
                "The prefectural capital of Fukuoka City overlooks the Port of Hakata, a harbor that has long facilitated " +
                "the region's prosperity through trade with other parts of Asia. In addition to being the administrative and " +
                "economic heart of the prefecture, Fukuoka is a lively commercial center from which trends in culture and fashion " +
                "filter out to other parts of Japan. International flights from a variety of countries fly into and out of " +
                "this \"gateway to Asia,\" and the city's shops make it easy for tourists to satisfy their urge to splurge.\n\n" +
                "Fukuoka also boasts popular annual festivals with long histories. The Hakata Dontaku Festival, which takes place " +
                "on May 3-4, dates back to the twelfth century. Originally a means of celebrating the New Year, it is now a major " +
                "event in which about 20,000 residents parade through the city dressed in a variety of costumes, attracting as many " +
                "as two million spectators.",
                R.drawable.culture));

        makeArrayList(tourItems, rootView);

        return rootView;
    }

    public void makeArrayList(final ArrayList<TourItem> arrayList, View view) {
        int colorId = R.color.culture_color;
        TourItemAdapter adapter = new TourItemAdapter(arrayList, colorId);
        ListView listView = (ListView) view.findViewById(R.id.list_view);
        int color = ContextCompat.getColor(getContext(), colorId);
        listView.setBackgroundColor(color);
        listView.setAdapter(adapter);
    }
}
