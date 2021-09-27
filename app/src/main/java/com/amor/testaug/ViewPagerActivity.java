package com.amor.testaug;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import java.util.Random;

/**
 * Created by neil on  2021/9/6
 */
public class ViewPagerActivity extends AppCompatActivity {
    private TextView mTitle;
    private String[] mLen = new String[10000];
    ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_pager);

        viewPager = findViewById(R.id.view_pager);
        MyFragmentAdapter adapter = new MyFragmentAdapter();
        viewPager.setAdapter(adapter);
        viewPager.setCurrentItem(5000);
        mTitle = findViewById(R.id.title);
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                mTitle.setText("title " + position);
            }

            @Override
            public void onPageScrollStateChanged(int i) {
                if (i == 1) {
                    viewPager.removeCallbacks(switchBanner);
                } else if (i == 2) {
                    viewPager.removeCallbacks(switchBanner);
                    viewPager.postDelayed(switchBanner, 1 * 1000);
                }
            }
        });

        mTitle.postDelayed(new Runnable() {
            @Override
            public void run() {
                mLen = new String[0];
                viewPager.setAdapter(new MyFragmentAdapter());
                viewPager.setCurrentItem(5000);
                viewPager.removeCallbacks(switchBanner);
                viewPager.postDelayed(switchBanner, 100);
            }
        }, 3000);

    }

    private Runnable switchBanner = () -> {
        int index = viewPager.getCurrentItem();
        if (index + 1 == 10000) {
            index = 5000;
        } else {
            index = index + 1;
        }
        Log.e("fatal", "index  = " + index);
        viewPager.setCurrentItem(index);
    };

    private class MyFragmentAdapter extends PagerAdapter {

        @Override
        public int getCount() {
            return mLen.length;
        }

        @Override
        public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
            return view == object;
        }

        @Override
        public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
            container.removeView((View) object);
        }

        @NonNull
        @Override
        public Object instantiateItem(@NonNull ViewGroup container, int position) {
            TextView textView = new TextView(container.getContext());
            textView.setText("ggggggggggggggggggggggggg\n\n\n\nllllllllllllllllllgggggggggg\n\n\n\nllllllllllllllll" +
                    "llgggggggggg\n\n\n\nllllllllllllllllllgggggggggg\n\n\n\nllllllllllllllllll");
            container.addView(textView);
            return textView;
        }

        @Override
        public int getItemPosition(@NonNull Object object) {
            return POSITION_NONE;
        }
    }
}