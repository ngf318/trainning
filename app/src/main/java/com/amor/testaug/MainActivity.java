package com.amor.testaug;

import android.content.Intent;
import android.os.Bundle;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.URLSpan;
import android.view.KeyEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.amor.testaug.utils.Utils;

public class MainActivity extends AppCompatActivity {
    int mInt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        testSpannable();
        TextView textView = findViewById(R.id.test);
        textView.setText(Utils.getEmulatorInfo(getApplicationContext()));
        findViewById(R.id.title_a).setOnClickListener(view -> startActivity(new Intent(MainActivity.this, ViewPagerActivity.class)));
        findViewById(R.id.content).setOnClickListener(view -> startActivity(new Intent(MainActivity.this, SvgaActivity.class)));
        Toast.makeText(this, "a = " + Utils.isEmulator(this), Toast.LENGTH_LONG).show();

        EditText editText = findViewById(R.id.edit);
        editText.setOnEditorActionListener((textView1, i, keyEvent) -> keyEvent == null ? false : keyEvent.getKeyCode() == KeyEvent.KEYCODE_ENTER);
        editText.setOnClickListener(view -> Toast.makeText(getApplicationContext(), "a"  + (mInt == 1 ? true : view.getId() == R.id.edit), Toast.LENGTH_LONG).show());
    }

    private void testSpannable() {
        TextView content = findViewById(R.id.content_span);
        content.setLongClickable(false);
        content.setTextIsSelectable(true);
        content.setMovementMethod(LinkMovementMethod.getInstance());
        CharSequence text = content.getText();
        if (text instanceof Spannable) {
            int end = text.length();
            Spannable sp = (Spannable) content.getText();
            URLSpan[] urls = sp.getSpans(0, end, URLSpan.class);
            SpannableStringBuilder style = new SpannableStringBuilder(text);
            style.clearSpans(); // should clear old spans
            for (final URLSpan url : urls) {
                style.setSpan(new ClickableSpan() {
                    @Override
                    public void onClick(View widget) {
                        Toast.makeText(MainActivity.this, "rul " + url.getURL().toString(), Toast.LENGTH_SHORT).show();
                    }
                }, sp.getSpanStart(url), sp.getSpanEnd(url), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
                style.setSpan(new ForegroundColorSpan(0xffFF7710), sp.getSpanStart(url), sp.getSpanEnd(url), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
            }
            content.setText(style);
        }
    }
}