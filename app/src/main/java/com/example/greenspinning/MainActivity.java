package com.example.greenspinning;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import android.util.Log;

import androidx.annotation.NonNull;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.view.GravityCompat;

import android.view.MenuItem;

import androidx.drawerlayout.widget.DrawerLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.Menu;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity
        {

    ArrayList<DataModel> dataModels;
    ListView listView;
    private static CustomAdapter adapter;
    ArrayList personNames = new ArrayList<>(Arrays.asList("03/06/19", "05/06/19", "07/06/19", "10/06/19", "12/06/19", "14/06/19", "17/06/19","19/06/19", "21/06/19", "24/06/19", "26/06/19", "28/06/19", "01/06/19", "03/06/19"));

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setTheme(R.style.AppTheme);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);
        bottomNavigationView.getMenu().getItem(1).setChecked(true);
        bottomNavigationView.setOnNavigationItemSelectedListener(
                new BottomNavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                        Fragment fragment;
                        switch (item.getItemId()) {
                            case R.id.action_profile:
                                fragment = new ProfileFragment();
                                loadFragment(fragment);
                                return true;
                            case R.id.action_home:
                                fragment = new HomeFragment();
                                loadFragment(fragment);
                                return true;
                            case R.id.action_news:
                                fragment = new NewsFragment();
                                loadFragment(fragment);
                                return true;
                        }
                        return false;
                    }
                });

        CoordinatorLayout.LayoutParams layoutParams = (CoordinatorLayout.LayoutParams) bottomNavigationView.getLayoutParams();
        layoutParams.setBehavior(new BottomNavigationBehavior());

        Intent intent = new Intent(MainActivity.this, LoginActivity.class);
        startActivity(intent);

        loadFragment(new HomeFragment());
    }

            private void loadFragment(Fragment fragment) {
                // load fragment
                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                transaction.setCustomAnimations(R.anim.fade_in, R.anim.fade_out);
                transaction.replace(R.id.frame_container, fragment);
                transaction.addToBackStack("my_fragment");
                transaction.commit();
            }

            @Override
            public void onBackPressed() {
                if (getFragmentManager().getBackStackEntryCount() > 0) {
                    getFragmentManager().popBackStack();
                } else {
                    super.onBackPressed();
                }
            }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        Log.d("TAG", String.valueOf(id));
        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

}



