
package com.androititlan.gdg.android_design_support_library.app.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.androititlan.gdg.android_design_support_library.R;
import com.androititlan.gdg.android_design_support_library.app.models.Developer;
import com.androititlan.gdg.android_design_support_library.app.ui.adapter.RecyclerViewAdapterExample;

import java.util.ArrayList;
import java.util.List;


public class FragmentListExample extends Fragment {

    public static FragmentListExample getInstance() {
        FragmentListExample fragmentListExample = new FragmentListExample();
        Bundle extraArguments = new Bundle();
        fragmentListExample.setArguments(extraArguments);
        return fragmentListExample;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        RecyclerView rv = (RecyclerView) inflater.inflate(R.layout.fragment_list_example, container, false);
        setupRecyclerView(rv);
        return rv;
    }

    private void setupRecyclerView(RecyclerView recyclerView) {
        recyclerView.setLayoutManager(new LinearLayoutManager(recyclerView.getContext()));
        recyclerView.setAdapter(new RecyclerViewAdapterExample(devs()));
    }

    // Generamos personas y repetimos para tener una lista grande
    private List<Developer> devs() {

        String[] nameExpert = {"Antonio Guzmán", "Enrique Diaz", "Cesar Anton", "Adrian Catalan",
                "Matias Molinas", "David Cifuentes"};

        int[] photoExpert = {R.drawable.tony, R.drawable.kikillo, R.drawable.cesar, R.drawable.adrian, R.drawable.mati, R.drawable.david};

        List<Developer> developers = new ArrayList<>();

        for (int j = 0; j < 2; j++) {

            for (int i = 0; i < nameExpert.length && i < photoExpert.length; i++) {
                Developer developer = new Developer();
                developer.setFoto(photoExpert[i]);
                developer.setName(nameExpert[i]);
                developers.add(developer);
            }
        }
        return developers;
    }


}
