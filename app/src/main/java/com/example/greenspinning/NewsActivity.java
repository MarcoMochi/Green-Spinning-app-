package com.example.greenspinning;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.ListView;

import com.bumptech.glide.Glide;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NewsActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private NewsAdapter adapter;
    private List<News> newsList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news);

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.news);
        newsList = new ArrayList<>();
        adapter = new NewsAdapter(this, newsList);

        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setAdapter(adapter);


        prepareNews();

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);
        bottomNavigationView.setOnNavigationItemSelectedListener(
                new BottomNavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                        switch (item.getItemId()) {
                            case R.id.action_favorites:

                            case R.id.action_schedules:
                                Intent i = new Intent(NewsActivity.this, MainActivity.class);
                                startActivity(i);
                                overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                                break;
                            case R.id.action_music:
                                Intent j = new Intent(NewsActivity.this, NewsActivity.class);
                                startActivity(j);
                                overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                                break;
                        }
                        return true;
                    }
                });
       }

    private void prepareNews() {
        int[] covers = new int[]{
                R.drawable.image1,
                R.drawable.image2,
                R.drawable.image3};

            News a = new News("How Green is 'Green' Energy?", "While these efforts are commendable, much of the development of green energy is having large impacts on the ...", covers[0]);
            newsList.add(a);

            a = new News("From Oil to Solar: Saudi Arabia\n", "Life in Saudi Arabia has long been defined by the oil that flows from the kingdom. Over decades, the vast wealth it pumped ...", covers[1]);
            newsList.add(a);

            a = new News("Simple Rules for Healthy Eating", "There's a lot of advice out there about what kinds of food you should be avoiding. Here's a more positive ...", covers[2]);
            newsList.add(a);


        adapter.notifyDataSetChanged();
        }


    @Override
    public void onBackPressed() {
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

}
