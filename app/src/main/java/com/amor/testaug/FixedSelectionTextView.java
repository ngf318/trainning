package com.amor.testaug;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatTextView;

/**
 * Created by neil on  2021/8/27
 */
public class FixedSelectionTextView extends AppCompatTextView {
    public FixedSelectionTextView(@NonNull Context context) {
        super(context);
    }

    public FixedSelectionTextView(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if (hasSelection() && event.getActionMasked() == MotionEvent.ACTION_DOWN) {
            CharSequence text = getText();
            setText(null);
            setText(text);
        }
        return super.onTouchEvent(event);
    }
}
