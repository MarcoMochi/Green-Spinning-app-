package com.example.greenspinning;


import android.annotation.SuppressLint;
import android.content.Context;

import android.content.res.ColorStateList;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.drawable.DrawableCompat;
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
    ArrayList icon_color;
    ArrayList<Boolean> icon_view;
    Context context;
    private static int currentPosition = -1;
    private static int previousExpandedPosition = -1;

    public CustomAdapter(Context context, ArrayList dates, ArrayList helperNames, ArrayList wattProduced, ArrayList calories, ArrayList speed, ArrayList km, ArrayList spinning_class, ArrayList icon_color, ArrayList icon_view) {
        this.context = context;
        this.dates = dates;
        this.helperNames = helperNames;
        this.wattProduced = wattProduced;
        this.calories = calories;
        this.speed = speed;
        this.km = km;
        this.spinning_class = spinning_class;
        this.icon_color = icon_color;
        this.icon_view = icon_view;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
// infalte the item Layout
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_item, parent, false);
// set the view's size, margins, paddings and layout parameters
        MyViewHolder vh = new MyViewHolder(v); // pass the view to View Holder
        return vh;
    }

    @SuppressLint("ResourceAsColor")
    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, final int position) {

        // set the data in items
        holder.date.setText((CharSequence) dates.get(position));
        holder.wattProduced.setText((CharSequence) wattProduced.get(position));
        holder.calories.setText((CharSequence) calories.get(position));
        holder.speed.setText((CharSequence) speed.get(position));
        holder.km.setText((CharSequence) km.get(position));
        holder.spinning_class.setText((CharSequence) spinning_class.get(position));
        holder.helper.setText((CharSequence) helperNames.get(position));

        // set icon color based on the array
        if(icon_color.get(position).equals("GREEN")) {
            holder.help.setText("help given to:");
            DrawableCompat.setTint(holder.icon_color.getBackground(), ContextCompat.getColor(context, R.color.green));
        } else if(icon_color.get(position).equals("RED")) {
            DrawableCompat.setTint(holder.icon_color.getBackground(), ContextCompat.getColor(context, R.color.red));
        } else {
            DrawableCompat.setTint(holder.icon_color.getBackground(), ContextCompat.getColor(context, R.color.iron));
            holder.helper.setText("--");
        }

        // set icon visibility based on the array
        if(icon_view.get(position)) {
            holder.icon_view.setVisibility(View.VISIBLE);
        } else {
            holder.icon_view.setVisibility(View.GONE);
        }

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
        TextView help;
        TextView spinning_class;
        RelativeLayout linearLayout;
        ImageView icon_color;
        ImageView icon_view;

        public MyViewHolder(View itemView) {
            super(itemView);

// get the reference of item view's
            date = (TextView) itemView.findViewById(R.id.date);
            wattProduced = (TextView) itemView.findViewById(R.id.watt_produced);
            helper = (TextView) itemView.findViewById(R.id.help_taken);
            calories = (TextView) itemView.findViewById(R.id.calories);
            speed = (TextView) itemView.findViewById(R.id.speed);
            km = (TextView) itemView.findViewById(R.id.km);
            help = (TextView) itemView.findViewById(R.id.help_text);
            spinning_class = (TextView) itemView.findViewById(R.id.spinning_class);
            icon_color = (ImageView) itemView.findViewById(R.id.help_icon);
            icon_view = (ImageView) itemView.findViewById(R.id.cup_icon);

            linearLayout = (RelativeLayout) itemView.findViewById(R.id.linear_layout);
        }
    }
}

