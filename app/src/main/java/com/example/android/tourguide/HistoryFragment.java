package com.example.android.tourguide;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;

public class HistoryFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.listview, container, false);

        ArrayList<TourItem> tourItems = new ArrayList<TourItem>();
        tourItems.add(new TourItem(getString(R.string.history_0_title), getString(R.string.history_0_information), R.drawable.history));
        tourItems.add(new TourItem(getString(R.string.history_1_title), getString(R.string.history_1_information), R.drawable.history2));

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
