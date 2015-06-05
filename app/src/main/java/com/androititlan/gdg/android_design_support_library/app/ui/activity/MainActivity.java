package com.androititlan.gdg.android_design_support_library.app.ui.activity;

import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.view.GravityCompat;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;

import com.androititlan.gdg.android_design_support_library.R;
import com.androititlan.gdg.android_design_support_library.app.ui.fragment.FragmentOne;
import com.androititlan.gdg.android_design_support_library.app.ui.fragment.FragmentThree;
import com.androititlan.gdg.android_design_support_library.app.ui.fragment.FragmentTwo;


public class MainActivity extends AppCompatActivity {

    private DrawerLayout mDrawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       fragmentTransactionReplace(FragmentOne.getInstance());

        mDrawerLayout = (DrawerLayout)findViewById(R.id.drawer_layout);
        final NavigationView navigationView = (NavigationView)findViewById(R.id.nav_view);
        if(navigationView != null){
            setupDrawerContent(navigationView);
        }

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                mDrawerLayout.openDrawer(GravityCompat.START);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private void setupDrawerContent(final NavigationView navigationView) {
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem menuItem) {

                switch (menuItem.getItemId()){

                    case R.id.nav_home:
                        fragmentTransactionReplace(FragmentOne.getInstance());
                        break;

                    case R.id.nav_messages:
                        fragmentTransactionReplace(FragmentTwo.getInstance());
                        break;

                    case R.id.nav_tabs:
                        fragmentTransactionReplace(FragmentThree.getInstance());

                        break;
                }

                menuItem.setChecked(true);
                mDrawerLayout.closeDrawers();
                return true;
            }
        });
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    private void fragmentTransactionReplace(Fragment fragmentInstance) {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.container, fragmentInstance)
                .commit();
    }

}
