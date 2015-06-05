package com.androititlan.gdg.android_design_support_library.app.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.androititlan.gdg.android_design_support_library.R;

/**
 * Created by Jhordan on 02/06/15.
 */
public class FragmentOne extends FragmentBase {

    public static FragmentOne getInstance() {
        FragmentOne fragmentOne = new FragmentOne();
        Bundle extraArguments = new Bundle();
        fragmentOne.setArguments(extraArguments);
        return fragmentOne;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_one, container, false);
        settingsToolbar(rootView);
        return rootView;

    }

    @Override
    protected void settingsToolbar(View rootView) {
        super.settingsToolbar(rootView);
    }


}
