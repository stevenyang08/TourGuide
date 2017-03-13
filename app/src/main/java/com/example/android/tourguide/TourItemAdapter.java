package com.example.android.tourguide;

import android.media.Image;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by stevenyang on 3/9/17.
 */

public class TourItemAdapter extends ArrayAdapter<TourItem> {

    private int mColorId;

    public TourItemAdapter(ArrayList<TourItem> arrayList, int referenceColorId) {
        super(ThisApplication.getContext(), 0, arrayList);
        mColorId = referenceColorId;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View listItem = convertView;

        if (listItem == null) {
            listItem = LayoutInflater.from(ThisApplication.getContext()).inflate(R.layout.listview_item, parent, false);
        }

        TourItem currentItem = getItem(position);

        TextView titleTextView = (TextView) listItem.findViewById(R.id.list_item_title);
        titleTextView.setText(currentItem.getTitle());

        TextView informationTextView = (TextView) listItem.findViewById(R.id.list_item_information);
        informationTextView.setText(currentItem.getInformation());

        LinearLayout linearLayout = (LinearLayout) listItem.findViewById(R.id.list_item_layout);
        int color = ContextCompat.getColor(getContext(), mColorId);
        linearLayout.setBackgroundColor(color);

        ImageView imageView = (ImageView) listItem.findViewById(R.id.list_item_image);
        if (currentItem.hasImage()) {
            imageView.setImageResource(currentItem.getImageId());
            imageView.setVisibility(View.VISIBLE);
        } else {
            imageView.setVisibility(View.GONE);
        }

        return listItem;
    }
}
