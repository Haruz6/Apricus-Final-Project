package com.example.finalprojectfile;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;

public class HomeActivity extends AppCompatActivity implements RecyclerAdapter.OnNoteListener {

    //public CardView card1;
    RecyclerView recyclerView;
    RecyclerAdapter adapter;
    ArrayList<FeaturedHelperClass> featuredLocations = new ArrayList<>();

    String statesNames[] = {"Sarawak", "Sabah", "Johor", "Selangor",
    "Kedah", "Penang", "Kelantan", "Perak", "Pahang",
    "Negeri Sembilan", "Perlis", "Terengganu", "Malacca"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        featuredLocations.add(new FeaturedHelperClass(R.drawable.penang, "Penang"));
        featuredLocations.add(new FeaturedHelperClass(R.drawable.penang, "Sabah"));
        featuredLocations.add(new FeaturedHelperClass(R.drawable.penang, "Sarawak"));

        recyclerView = findViewById(R.id.recyclerview);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        adapter = new RecyclerAdapter(featuredLocations, this);
        recyclerView.setAdapter(adapter);

        GradientDrawable gradient1 = new GradientDrawable(GradientDrawable.Orientation.LEFT_RIGHT, new int[]{0xffeff400, 0xffaff600});


        //card1 = (CardView) findViewById(R.id.state1);

        //card1.setOnClickListener(this);
    }



    @Override
    public void onNoteClick(int position) {
        //Intent intent = new Intent(this, N)
        //StartActivity(intent);

    }
}