package com.example.android.tourguide;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;

public class WhyHere extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.listview, container, false);

        ArrayList<TourItem> tourItems = new ArrayList<TourItem>();
        tourItems.add(new TourItem("Startup Ecosystem", "Fukuoka’s startup ecosystem is still in its early days. " +
                "Not as many startups here as in other big cities like Tokyo. " +
                "It has its cons (obviously), everything has to be built, we don’t have a lot of investors here, " +
                "not so many English meetups etc. But it also has many advantages. The community being young and still small, " +
                "it is easier to get recognition and get your name on the map. People are also much more motivated. " +
                "We all have to work together to grow the ecosystem and people are willing to help and share their experience.",
                R.drawable.whyhere));
        tourItems.add(new TourItem("Demographics", "Fukuoka is a medium size city (1.5million habitants) and its population is pretty young. " +
                "Average of 40 years old-ish. This makes of the city a very active city, very lively. " +
                "Business wise, a young population means that people are more open minded, " +
                "more prone to change and willing to accept new concepts.", R.drawable.whyhere2));

        makeArrayList(tourItems, rootView);

        return rootView;
    }

    public void makeArrayList(final ArrayList<TourItem> arrayList, View view) {
        int colorId = R.color.why_here_color;
        TourItemAdapter adapter = new TourItemAdapter(arrayList, colorId);
        ListView listView = (ListView) view.findViewById(R.id.list_view);
        int color = ContextCompat.getColor(getContext(), colorId);
        listView.setBackgroundColor(color);
        listView.setAdapter(adapter);
    }
}
