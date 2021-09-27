package com.amor.testaug;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
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
import java.util.List;

/**
 * Created by neil on  2021/9/6
 */
public class SvgaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_svga);

        SVGALogger.INSTANCE.setLogEnabled(true);
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
        });
    }
}