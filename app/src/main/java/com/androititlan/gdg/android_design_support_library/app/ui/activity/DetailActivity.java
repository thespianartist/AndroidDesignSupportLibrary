

package com.androititlan.gdg.android_design_support_library.app.ui.activity;


import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;

import com.androititlan.gdg.android_design_support_library.R;
import com.androititlan.gdg.android_design_support_library.app.models.Developer;
import com.androititlan.gdg.android_design_support_library.app.ui.adapter.RecyclerViewAdapterExample;
import com.androititlan.gdg.android_design_support_library.app.util.Config;
import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;


public class DetailActivity extends AppCompatActivity {



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        Intent intent = getIntent();
        final String expertName = intent.getStringExtra(Config.EXTRA_NAME);
        final int expertFoto = intent.getIntExtra(Config.EXTRA_PHOTO,R.drawable.adrian);


        final Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        final android.support.v7.app.ActionBar actionBar = getSupportActionBar();
        if(actionBar !=  null){
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }


        CollapsingToolbarLayout collapsingToolbar =
                (CollapsingToolbarLayout) findViewById(R.id.collapsing_toolbar);
        collapsingToolbar.setTitle(expertName);

        loadBackdrop(expertFoto);

        RecyclerView rv = (RecyclerView)findViewById(R.id.scrollableview);
        setupRecyclerView(rv);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private void loadBackdrop(int foto) {
        final ImageView imageView = (ImageView) findViewById(R.id.backdrop);
        Glide.with(this).load(foto).centerCrop().into(imageView);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
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
