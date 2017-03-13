package com.example.android.tourguide;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;

public class History extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.listview, container, false);

        ArrayList<TourItem> tourItems = new ArrayList<TourItem>();
        tourItems.add(new TourItem("Fukuoka Castle", "The ruins of Fukuoka Castle (福岡城跡, Fukuokajōato) " +
                "are located in the middle of the city in Maizuru Park, named after the castle's alias, Maizuru " +
                "Castle. During the Edo Period (1603-1867), Fukuoka Castle used to be the largest castle on Kyushu, " +
                "but it was almost completely torn down after the Meiji Restoration as an unwanted symbol of the feudal " +
                "past.", R.drawable.history));
        tourItems.add(new TourItem("Kushida Shrine", "A Shinto shrine located in Hakata-ku, Fukuoka, Japan. Dedicated to " +
                "Amaterasu and Susanoo, it is said to have been founded in 757. The Hakata Gion Yamakasa festival is centred " +
                "on the shrine.", R.drawable.history2));

        makeArrayList(tourItems, rootView);

        return rootView;
    }

    public void makeArrayList(final ArrayList<TourItem> arrayList, View view) {
        int colorId = R.color.history_color;
        TourItemAdapter adapter = new TourItemAdapter(arrayList, colorId);
        ListView listView = (ListView) view.findViewById(R.id.list_view);
        int color = ContextCompat.getColor(getContext(), colorId);
        listView.setBackgroundColor(color);
        listView.setAdapter(adapter);
    }
}
