package com.example.greenspinning;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class DetailsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        Intent intent = getIntent();
        CardView cardView = (CardView) findViewById(R.id.card_view);
        TextView title = (TextView) findViewById(R.id.title_details);
        ImageView movie_bg = (ImageView) findViewById(R.id.cover_bg_details);
        TextView subtitle = (TextView) findViewById(R.id.subtitle_details);

        Glide.with(this).load(intent.getIntExtra("thumbnail", 1)).into(movie_bg);
        title.setText(intent.getStringExtra("title"));
        subtitle.setText(intent.getStringExtra("subtitle"));
    }
}