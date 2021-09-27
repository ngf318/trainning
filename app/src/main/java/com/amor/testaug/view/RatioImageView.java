package com.amor.testaug.view;

import android.content.Context;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/**
 * Created by neil on  2021/9/11
 */
public class RatioImageView extends androidx.appcompat.widget.AppCompatImageView {
    public RatioImageView(@NonNull Context context) {
        super(context);
    }

    public RatioImageView(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public RatioImageView(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        DisplayMetrics metrics = getResources().getDisplayMetrics();
        int widthPixels = metrics.widthPixels;
        int heightPixels = metrics.heightPixels;
        int widthImage = MeasureSpec.getSize(widthMeasureSpec);
        int heightImage = MeasureSpec.getSize(heightMeasureSpec);


        widthMeasureSpec = MeasureSpec.makeMeasureSpec(widthImage, MeasureSpec.EXACTLY);
        heightMeasureSpec = MeasureSpec.makeMeasureSpec(heightImage, MeasureSpec.EXACTLY);

        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }
}
