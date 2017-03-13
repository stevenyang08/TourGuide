package com.example.android.tourguide;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;

public class Restaurant extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.listview, container, false);

        ArrayList<TourItem> tourItems = new ArrayList<TourItem>();
        tourItems.add(new TourItem("Hakata Miyachiku", "Imagining to be a healing space in mothernature of Miyazaki and coutry of fairy tale,\n" +
                "Fully enjoy the delicious taste from 「Miyazaki Beef」\n" +
                "◆ Private dining room available\n" +
                "\n" +
                "<<Restaurants as delivering the philosophy of producers>>\n" +
                "For being the bridge between clients and producers, Miyazaki Japan cows, growing from the good shiny environment of Kawasaki,\n" +
                "are continuously processed through the producing line of our company and distributed into our affilated restaurants. \n" +
                "\n" +
                "「Fukuoka‧Hakata」, the birthplace of Kyushu, offers the safe and worry-free Miyazaki Japan beef,\n" +
                "and all kind of other tasty food of Miyazaki.",
                R.drawable.restaurant));
        tourItems.add(new TourItem("Kawataro", "With over 40 years of history, we were the first restaurant in Japan to have " +
                "an on-site fish tank. Enjoy unbeatably fresh seafood & authentic Japanese dishes and some new flavors too.",
                R.drawable.restaurant2));

        makeArrayList(tourItems, rootView);

        return rootView;
    }

    public void makeArrayList(final ArrayList<TourItem> arrayList, View view) {
        int colorId = R.color.restaurants_color;
        TourItemAdapter adapter = new TourItemAdapter(arrayList, colorId);
        ListView listView = (ListView) view.findViewById(R.id.list_view);
        int color = ContextCompat.getColor(getContext(), colorId);
        listView.setBackgroundColor(color);
        listView.setAdapter(adapter);
    }
}
