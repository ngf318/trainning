package com.amor.testaug.view;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewpager.widget.ViewPager;

/**
 * Created by neil on  2021/9/7
 */
public class TouchSafeViewPager extends ViewPager {
    public TouchSafeViewPager(@NonNull Context context) {
        super(context);
    }

    public TouchSafeViewPager(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public boolean onTouchEvent(MotionEvent ev) {
        Log.d("niexxx", "====current = " + getCurrentItem() + " getChildCount() = " + getChildCount());
/*        if (getCurrentItem() == 0 && getChildCount() == 0) {
            return false;
        }*/

        try {
            return super.onTouchEvent(ev);
        } catch (IndexOutOfBoundsException e) {
            Log.d("niexxx", e.toString());
            return false;
/*            Fatal Exception: java.lang.IndexOutOfBoundsException
            Index: 0, Size: 0
            java.util.ArrayList.get (ArrayList.java:411)
            androidx.viewpager.widget.ViewPager.performDrag (ViewPager.java:7)
            androidx.viewpager.widget.ViewPager.onTouchEvent (ViewPager.java:36)
            com.nebula.livevoice.ui.view.common.TouchSafeViewPager.onTouchEvent (TouchSafeViewPager.java:2)*/
        }
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        if (getCurrentItem() == 0 && getChildCount() == 0) {
            return false;
        }

        return super.onInterceptTouchEvent(ev);
    }
}
