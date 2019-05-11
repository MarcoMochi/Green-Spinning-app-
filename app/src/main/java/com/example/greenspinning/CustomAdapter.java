package com.example.greenspinning;


import android.content.Context;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.MyViewHolder> {

    ArrayList dates;
    ArrayList wattProduced;
    ArrayList helperNames;
    ArrayList calories;
    ArrayList speed;
    ArrayList km;
    ArrayList spinning_class;
    Context context;
    private static int currentPosition = -1;
    private static int previousExpandedPosition = -1;

    public CustomAdapter(Context context, ArrayList dates, ArrayList helperNames, ArrayList wattProduced, ArrayList calories, ArrayList speed, ArrayList km, ArrayList spinning_class) {
        this.context = context;
        this.dates = dates;
        this.helperNames = helperNames;
        this.wattProduced = wattProduced;
        this.calories = calories;
        this.speed = speed;
        this.km = km;
        this.spinning_class = spinning_class;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
// infalte the item Layout
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_item, parent, false);
// set the view's size, margins, paddings and layout parameters
        MyViewHolder vh = new MyViewHolder(v); // pass the view to View Holder
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, final int position) {

        // set the data in items
        holder.date.setText((CharSequence) dates.get(position));
        holder.wattProduced.setText((CharSequence) wattProduced.get(position));
        holder.helper.setText((CharSequence) helperNames.get(position));
        holder.calories.setText((CharSequence) calories.get(position));
        holder.speed.setText((CharSequence) speed.get(position));
        holder.km.setText((CharSequence) km.get(position));
        holder.spinning_class.setText((CharSequence) spinning_class.get(position));
        final boolean isExpanded = position== currentPosition;
        Animation slideDown = AnimationUtils.loadAnimation(context, R.anim.slide_down);
        holder.linearLayout.startAnimation(slideDown);
        holder.linearLayout.setVisibility(isExpanded?View.VISIBLE:View.GONE);
        holder.itemView.setActivated(isExpanded);


        if (isExpanded)
            previousExpandedPosition = position;

// implement setOnClickListener event on item view.
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                currentPosition = isExpanded ? -1:position;
                notifyItemChanged(previousExpandedPosition);
                notifyItemChanged(position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return dates.size();
    }



    public class MyViewHolder extends RecyclerView.ViewHolder {
        // init the item view's
        TextView date;
        TextView wattProduced;
        TextView helper;
        TextView calories;
        TextView speed;
        TextView km;
        TextView spinning_class;
        RelativeLayout linearLayout;

        public MyViewHolder(View itemView) {
            super(itemView);

// get the reference of item view's
            date = (TextView) itemView.findViewById(R.id.date);
            wattProduced = (TextView) itemView.findViewById(R.id.watt_produced);
            helper = (TextView) itemView.findViewById(R.id.help_taken);
            calories = (TextView) itemView.findViewById(R.id.calories);
            speed = (TextView) itemView.findViewById(R.id.speed);
            km = (TextView) itemView.findViewById(R.id.km);
            spinning_class = (TextView) itemView.findViewById(R.id.spinning_class);

            linearLayout = (RelativeLayout) itemView.findViewById(R.id.linear_layout);
        }
    }
}

