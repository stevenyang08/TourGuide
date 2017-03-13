package com.example.android.tourguide;

import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class TourItemAdapter extends ArrayAdapter<TourItem> {

    static class ViewHolder {
        @BindView(R.id.list_item_title) TextView titleTextView;
        @BindView(R.id.list_item_information) TextView informationTextView;
        @BindView(R.id.list_item_layout) LinearLayout listItemLayout;
        @BindView(R.id.list_item_image) ImageView imageView;

        public ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }

    private int mColorId;

    public TourItemAdapter(ArrayList<TourItem> arrayList, int referenceColorId) {
        super(ThisApplication.getContext(), 0, arrayList);
        mColorId = referenceColorId;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (convertView != null) {
            holder = (ViewHolder) convertView.getTag();
        } else {
            convertView = LayoutInflater.from(ThisApplication.getContext()).inflate(R.layout.listview_item, parent, false);
            holder = new ViewHolder(convertView);
            convertView.setTag(holder);
        }

        TourItem currentItem = getItem(position);

        holder.titleTextView.setText(currentItem.getTitle());
        holder.informationTextView.setText(currentItem.getInformation());
        int color = ContextCompat.getColor(getContext(), mColorId);
        holder.listItemLayout.setBackgroundColor(color);

        if (currentItem.hasImage()) {
            holder.imageView.setImageResource(currentItem.getImageId());
            holder.imageView.setVisibility(View.VISIBLE);
        } else {
            holder.imageView.setVisibility(View.GONE);
        }

        return convertView;
    }
}