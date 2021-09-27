package com.amor.testaug;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

/**
 * Created by neil on  2021/9/6
 */
public class FragmentTest extends Fragment {

    public static FragmentTest newInstance() {
        Bundle args = new Bundle();
        FragmentTest fragment = new FragmentTest();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup parent, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_main, parent, false);
        return view;
    }
}
