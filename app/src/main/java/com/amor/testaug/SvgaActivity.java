package com.amor.testaug;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.opensource.svgaplayer.SVGADrawable;
import com.opensource.svgaplayer.SVGAImageView;
import com.opensource.svgaplayer.SVGAParser;
import com.opensource.svgaplayer.SVGAVideoEntity;
import com.opensource.svgaplayer.proto.MovieEntity;
import com.opensource.svgaplayer.utils.SVGARect;
import com.opensource.svgaplayer.utils.log.SVGALogger;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by neil on  2021/9/6
 */
public class SvgaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_svga);

        initList();
      /*  SVGALogger.INSTANCE.setLogEnabled(true);
        SVGAParser.Companion.shareParser().init(this);
        SVGAImageView family_frame = findViewById(R.id.svga_img);
        SVGAParser.Companion.shareParser().decodeFromAssets("ar.svga", new SVGAParser.ParseCompletion() {
            @Override
            public void onComplete(SVGAVideoEntity svgaVideoEntity) {
                family_frame.setImageDrawable(new SVGADrawable(svgaVideoEntity));
                family_frame.startAnimation();
                family_frame.setVisibility(View.VISIBLE);
                SVGARect rect = svgaVideoEntity.getVideoSize();
                Log.d("SVGAParser", rect.getWidth() + " = " );

            }

            @Override
            public void onError() {
            }
        });*/
    }

    private void initList() {
        RecyclerView recyclerView = findViewById(R.id.list);
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        MyAdapter myAdapter = new MyAdapter();
        recyclerView.setAdapter(myAdapter);
        List<String> data = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            data.add("Name you " + i);
        }
        myAdapter.setData(data);
    }

    static class MyAdapter extends RecyclerView.Adapter {
        ArrayList<String> mData = new ArrayList<>();
        public void setData(List<String> list) {
            mData.clear();
            mData.addAll(list);
            notifyDataSetChanged();
        }

        @NonNull
        @Override
        public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_test_layout, parent, false);
            return new MyHolder(view);
        }

        @Override
        public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
            String str = mData.get(position);
            ((MyHolder) holder).name.setText(str);
        }

        @Override
        public int getItemCount() {
            return mData.size();
        }
    }

    static class MyHolder extends RecyclerView.ViewHolder {
        TextView name;

        public MyHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.name);
        }
    }
}