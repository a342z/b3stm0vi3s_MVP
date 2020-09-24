package com.example.b3stm0vi3s0.Activities;


import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.example.b3stm0vi3s0.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MovieActivity extends AppCompatActivity {
    @BindView(R.id.imageMM)
    ImageView imageViewMovieImage;
    @BindView(R.id.TVmovieName)
    TextView textViewMovieName;
    @BindView(R.id.TVmovieRS)
    TextView textViewRelease;
    @BindView(R.id.TVmovieOverView)
    TextView textViewOverview;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie);
        ButterKnife.bind(this);


        String imageUrl = getIntent().getStringExtra("image_url");
        String movie_des = getIntent().getStringExtra("movie_des");
        String movie_title = getIntent().getStringExtra("movie_title");
        String movie_rs = getIntent().getStringExtra("movie_rs");


        textViewMovieName.setText(movie_title);
        textViewOverview.setText(movie_des);
        textViewRelease.setText(movie_rs);
        Glide.with(this)
                .asBitmap()
                .load(imageUrl)
                .into(imageViewMovieImage);

    }


}
