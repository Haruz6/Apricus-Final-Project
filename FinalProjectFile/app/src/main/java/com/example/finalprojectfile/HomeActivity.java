package com.example.finalprojectfile;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.widget.Toolbar;

import com.google.android.material.navigation.NavigationView;
import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;

public class HomeActivity extends AppCompatActivity implements RecyclerAdapter.OnNoteListener, View.OnClickListener, NavigationView.OnNavigationItemSelectedListener {

    public CardView cardRec;
    RecyclerView recyclerView;
    RecyclerAdapter adapter;
    ArrayList<FeaturedHelperClass> featuredLocations = new ArrayList<>();

    DrawerLayout drawerLayout;
    NavigationView navigationView;
    Toolbar toolbar;

    TextView searchbar;

    String currentUser;

    String statesNames[] = {"Sarawak", "Sabah", "Johor", "Selangor",
    "Kedah", "Penang", "Kelantan", "Perak", "Pahang",
    "Negeri Sembilan", "Perlis", "Terengganu", "Malacca"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        searchbar = findViewById(R.id.text_search_bar);

        Intent intent = getIntent();

        currentUser = intent.getStringExtra("currentUser");

        featuredLocations.add(new FeaturedHelperClass(R.drawable.penang_1, "Penang"));
        featuredLocations.add(new FeaturedHelperClass(R.drawable.johor_1, "Johor"));
        featuredLocations.add(new FeaturedHelperClass(R.drawable.melaka_1, "Melaka"));
        featuredLocations.add(new FeaturedHelperClass(R.drawable.negeri_sembilan_1, "Negeri Sembilan"));
        featuredLocations.add(new FeaturedHelperClass(R.drawable.pahang_1, "Pahang"));
        featuredLocations.add(new FeaturedHelperClass(R.drawable.kelantan_1, "Kelantan"));
        featuredLocations.add(new FeaturedHelperClass(R.drawable.kedah_1, "Kedah"));

        recyclerView = findViewById(R.id.recyclerview);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        adapter = new RecyclerAdapter(featuredLocations, this);
        recyclerView.setAdapter(adapter);

        GradientDrawable gradient1 = new GradientDrawable(GradientDrawable.Orientation.LEFT_RIGHT, new int[]{0xffeff400, 0xffaff600});


        //Recommendations CardView Button
        cardRec = (CardView) findViewById(R.id.recommendationCard);

        cardRec.setOnClickListener(this);
        //-----------------------------------------------

        //Drawer Menu
        drawerLayout = findViewById(R.id.drawerlayout);
        navigationView = findViewById(R.id.nav_view);
        toolbar = findViewById(R.id.toolbar);

        setSupportActionBar(toolbar);

        navigationView.bringToFront();
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this,drawerLayout,toolbar,R.string.navigation_drawer_open,R.string.navigation_drawer_close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        navigationView.setNavigationItemSelectedListener(this);
        navigationView.setCheckedItem(R.id.nav_home);

        searchbar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent searchIntent = new Intent(HomeActivity.this, SearchActivity.class);
                startActivity(searchIntent);

            }
        });
    }

    //To avoid activity closure upon pressing back.
    public void onBackPressed()
    {
        if(drawerLayout.isDrawerOpen(GravityCompat.START)){
            drawerLayout.closeDrawer(GravityCompat.START);
        }
        else
        {
            super.onBackPressed();
        }
    }


    @Override
    public void onNoteClick(int position) {
        //Intent intent = new Intent(this, )
        //StartActivity(intent);

    }

    @Override
    public void onClick(View v) {
        Intent intent;
        switch(v.getId()){
            case R.id.recommendationCard:
                intent = new Intent(this, RecommendationsActivity1.class);
                startActivity(intent);
                break;
        }
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

        switch(menuItem.getItemId()){
            case R.id.nav_home:
                break;
            case R.id.nav_profile:
                Intent intent = new Intent(HomeActivity.this, User_Profile_Activity.class);
                intent.putExtra("currentUser", currentUser);
                startActivity(intent);
                break;
            case R.id.nav_trivia:
                intent = new Intent(HomeActivity.this, StartActivity.class);
                intent.putExtra("currentUser", currentUser);
                startActivity(intent);
                break;
            case R.id.nav_covid:
                intent = new Intent(HomeActivity.this, activity_covidcases.class);
                startActivity(intent);
                break;
            case R.id.nav_camera:
                Intent open_camera = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivity(open_camera);
                break;
            case R.id.nav_logout:
                Toast.makeText(HomeActivity.this, "Logged Out", Toast.LENGTH_SHORT).show();
                intent = new Intent(HomeActivity.this, LoginActivity.class);
                startActivity(intent);
                break;
        }

        drawerLayout.closeDrawer(GravityCompat.START);
        return true;


    }


}
