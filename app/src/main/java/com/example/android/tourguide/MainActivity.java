package com.example.android.tourguide;

import android.support.design.widget.TabLayout;
import android.support.v7.app.AppCompatActivity;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.view.View;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    static class ViewHolder {
        @BindView(R.id.container) ViewPager viewPager;
        @BindView(R.id.tabs) TabLayout tabLayout;
        public ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }

    private SectionsPagerAdapter mSectionsPagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());

        ViewHolder holder = new ViewHolder(this.findViewById(R.id.main_content));
        holder.viewPager.setAdapter(mSectionsPagerAdapter);
        holder.tabLayout.setupWithViewPager(holder.viewPager);
    }

    public class SectionsPagerAdapter extends FragmentPagerAdapter {

        public SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            switch (position) {
                case 0:
                    WhyHereFragment whyHereFragment = new WhyHereFragment();
                    return whyHereFragment;
                case 1:
                    HistoryFragment historyFragment = new HistoryFragment();
                    return historyFragment;
                case 2:
                    CultureFragment cultureFragment = new CultureFragment();
                    return cultureFragment;
                case 3:
                    RestaurantFragment restaurantFragment = new RestaurantFragment();
                    return restaurantFragment;
                default:
                    return null;
            }
        }

        @Override
        public int getCount() {
            // Show 3 total pages.
            return 4;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            switch (position) {
                case 0:
                    return getString(R.string.why_here_header);
                case 1:
                    return getString(R.string.history_header);
                case 2:
                    return getString(R.string.culture_header);
                case 3:
                    return getString(R.string.restaurant_header);
            }
            return null;
        }
    }
}