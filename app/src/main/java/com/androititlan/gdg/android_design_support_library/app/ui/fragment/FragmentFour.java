package com.androititlan.gdg.android_design_support_library.app.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.androititlan.gdg.android_design_support_library.R;

/**
 * Created by Jhordan on 02/06/15.
 */
public class FragmentFour extends Fragment {


    public static FragmentFour getInstance(){
        FragmentFour fragmentOne = new FragmentFour();
        Bundle extraArguments = new Bundle();
        fragmentOne.setArguments(extraArguments);
        return fragmentOne;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_four,container,false);
        Log.i("dato", "se creo four");
        return rootView;

    }
}
