package com.example.greenspinning;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;



public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.MyViewHolder> {

    List<News> newsList;
    Context context;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        // init the item view's
        TextView title, subtitle;
        public ImageView thumbnail;

        public MyViewHolder(View itemView) {
            super(itemView);

// get the reference of item view's
            title = (TextView) itemView.findViewById(R.id.title);
            subtitle = (TextView) itemView.findViewById(R.id.subtitle);
            thumbnail = (ImageView) itemView.findViewById(R.id.thumbnail);
        }
    }

    public NewsAdapter(Context context, List<News> newsList) {
        this.context = context;
        this.newsList = newsList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
// infalte the item Layout
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.news_card, parent, false);
// set the view's size, margins, paddings and layout parameters
        MyViewHolder vhi = new MyViewHolder(v); // pass the view to View Holder
        return vhi;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        News news = newsList.get(position);
        // set the data in items
        holder.title.setText(news.getTitle());
        holder.subtitle.setText(news.getSubtitle());
// implement setOnClickListener event on item view.
        Glide.with(context).load(news.getThumbnail()).into(holder.thumbnail);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
// open another activity on item click
                Intent intent = new Intent(context, Workout.class);
                context.startActivity(intent); // start Intent
            }
        });
    }

    @Override
    public int getItemCount() {
        return newsList.size();
    }

}