package com.example.greenspinning;

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
       }

    private void prepareNews() {
        int[] covers = new int[]{
                R.drawable.image1,
                R.drawable.image2,
                R.drawable.image3};

            News a = new News("Green energy", "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Ut consequat turpis eu purus sodales suscipit. Sed sit amet pulvinar est, id euismod nulla", covers[0]);
            newsList.add(a);

            a = new News("World news", "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Ut consequat turpis eu purus sodales suscipit. Sed sit amet pulvinar est, id euismod nulla", covers[1]);
            newsList.add(a);

            a = new News("World news", "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Ut consequat turpis eu purus sodales suscipit. Sed sit amet pulvinar est, id euismod nulla", covers[2]);
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
