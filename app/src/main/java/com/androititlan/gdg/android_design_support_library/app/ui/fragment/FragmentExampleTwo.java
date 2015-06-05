package com.androititlan.gdg.android_design_support_library.app.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.androititlan.gdg.android_design_support_library.R;

/**
 * Created by Jhordan on 02/06/15.
 */
public class FragmentExampleTwo extends Fragment {

    public static FragmentExampleTwo getInstance() {
        FragmentExampleTwo fragmentExampleTwo= new FragmentExampleTwo();
        Bundle extraArguments = new Bundle();
        fragmentExampleTwo.setArguments(extraArguments);
        return fragmentExampleTwo;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_example_two, container, false);

        return rootView;

    }



}
