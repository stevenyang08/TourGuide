package com.example.android.tourguide;

/**
 * Created by stevenyang on 3/9/17.
 */

public class TourItem {

    private String mTitle;
    private String mInformation;
    private int mImageId = NO_IMAGE;
    private final static int NO_IMAGE = -1;

    public TourItem(String itemTitle, String information) {
        mTitle = itemTitle;
        mInformation = information;
    }

    public TourItem(String itemTitle, String information, int resourceImageId) {
        mTitle = itemTitle;
        mInformation = information;
        mImageId = resourceImageId;
    }

    public String getTitle() {
        return mTitle;
    }

    public String getInformation() {
        return mInformation;
    }

    public int getImageId() {
        return mImageId;
    }

    public boolean hasImage() {
        if (mImageId == -1) {
            return false;
        } else {
            return true;
        }
    }
}
