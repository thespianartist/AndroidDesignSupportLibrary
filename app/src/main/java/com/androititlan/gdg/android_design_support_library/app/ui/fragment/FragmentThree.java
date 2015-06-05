package com.androititlan.gdg.android_design_support_library.app.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import com.androititlan.gdg.android_design_support_library.R;
import com.androititlan.gdg.android_design_support_library.app.ui.adapter.FragmentPagerExample;

import butterknife.ButterKnife;
import butterknife.InjectView;

/**
 * Created by Jhordan on 02/06/15.
 */
public class FragmentThree extends FragmentBase {


    public static FragmentThree getInstance(){
        FragmentThree fragmentThree = new FragmentThree();
        Bundle extraArguments = new Bundle();
        fragmentThree.setArguments(extraArguments);
        return fragmentThree;
    }

    @InjectView(R.id.viewpager) ViewPager viewPager;
    @InjectView(R.id.tabs) TabLayout tabLayout;
    @InjectView(R.id.fab) FloatingActionButton floatingActionButton ;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_three, container, false);
        settingsToolbar(rootView);
        ButterKnife.inject(this, rootView);

        if(viewPager != null){
            setUpViewPager(viewPager);
            tabLayout.setupWithViewPager(viewPager);
        }

        return rootView;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Snackbar.make(view, "Google Developers Groups - Snackbar", Snackbar.LENGTH_LONG).setAction("Action", null).show();

            }
        });
    }

    private void setUpViewPager(ViewPager viewPager){

        FragmentPagerExample fragmentPagerExample = new FragmentPagerExample(getChildFragmentManager());
        fragmentPagerExample.addFragment(FragmentListExample.getInstance(),"GDE LATAM");
        fragmentPagerExample.addFragment(FragmentExampleOne.getInstance(),"Components");
        fragmentPagerExample.addFragment(FragmentExampleTwo.getInstance(),"LM Scrolls");
        viewPager.setAdapter(fragmentPagerExample);

    }

    @Override
    protected void settingsToolbar(View rootView) {
        super.settingsToolbar(rootView);
    }
}
