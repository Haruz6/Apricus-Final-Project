package com.example.finalprojectfile;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class RecommendationsActivity1 extends AppCompatActivity {

    private RecyclerView mRecyclerView1;
    private RecyclerView.Adapter mAdapter1;
    private RecyclerView.LayoutManager mLayoutManager1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recommendations1);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_baseline_arrow_back_ios_24);

        ArrayList<RecommendationsItem> recommendationsItemArrayList = new ArrayList<>();
        recommendationsItemArrayList.add(new RecommendationsItem(R.drawable.johor_1, "Johor", Page_Johor.class));
        recommendationsItemArrayList.add(new RecommendationsItem(R.drawable.kedah_1, "Kedah", Page_Kedah.class));
        recommendationsItemArrayList.add(new RecommendationsItem(R.drawable.kelantan_1, "Kelantan", Page_Kelantan.class));
        recommendationsItemArrayList.add(new RecommendationsItem(R.drawable.melaka_1, "Melaka", Page_Melaka.class));
        recommendationsItemArrayList.add(new RecommendationsItem(R.drawable.negeri_sembilan_1, "Negeri Sembilan", Page_Negeri_Sembilan.class));
        recommendationsItemArrayList.add(new RecommendationsItem(R.drawable.pahang_1, "Pahang", Page_Pahang.class));
        recommendationsItemArrayList.add(new RecommendationsItem(R.drawable.penang_1, "Penang", Page_Penang.class));

        Collections.shuffle(recommendationsItemArrayList);
        mRecyclerView1 = findViewById(R.id.recommendRecyclerView);
        mRecyclerView1.setHasFixedSize(true);
        mLayoutManager1 = new LinearLayoutManager(this);
        mAdapter1=new Recommendations1Adapter(recommendationsItemArrayList);

        mRecyclerView1.setLayoutManager(mLayoutManager1);
        mRecyclerView1.setAdapter(mAdapter1);
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
}