package com.example.finalprojectfile;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.SearchView;

import java.util.ArrayList;

public class SearchActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private SearchAdapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_baseline_arrow_back_ios_24);

        ArrayList<SearchItem> searchList = new ArrayList<>();
        searchList.add(new SearchItem(R.drawable.johor_1, "Johor", Page_Johor.class));
        searchList.add(new SearchItem(R.drawable.penang_1, "Penang", Page_Penang.class));
        searchList.add(new SearchItem(R.drawable.melaka_1, "Melaka", Page_Melaka.class));
        searchList.add(new SearchItem(R.drawable.negeri_sembilan_1, "Negeri Sembilan", Page_Negeri_Sembilan.class));
        searchList.add(new SearchItem(R.drawable.kelantan_1, "Kelantan", Page_Kelantan.class));
        searchList.add(new SearchItem(R.drawable.kedah_1, "Kedah", Page_Kedah.class));
        searchList.add(new SearchItem(R.drawable.pahang_1, "Pahang", Page_Pahang.class));

        mRecyclerView = findViewById(R.id.search_recyclerview);
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(this);
        mAdapter = new SearchAdapter(this, searchList);

        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setAdapter(mAdapter);


        /*
        mAdapter.setOnItemClickListener(new SearchAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                /*
                switch (position){
                    case 0:
                        Intent testIntent1 = new Intent(getApplicationContext(), Page_Johor.class);
                        startActivity(testIntent1);
                        break;
                    case 1:
                        testIntent1 = new Intent(getApplicationContext(), Page_Penang.class);
                        startActivity(testIntent1);
                        break;
                    case 2:
                        testIntent1 = new Intent(getApplicationContext(), Page_Melaka.class);
                        startActivity(testIntent1);
                        break;
                    case 3:
                        testIntent1 = new Intent(getApplicationContext(), Page_Negeri_Sembilan.class);
                        startActivity(testIntent1);
                        break;
                    case 4:
                        testIntent1 = new Intent(getApplicationContext(), Page_Kelantan.class);
                        startActivity(testIntent1);
                        break;
                    case 5:
                        testIntent1 = new Intent(getApplicationContext(), Page_Pahang.class);
                        startActivity(testIntent1);
                        break;
                    case 6:
                        testIntent1 = new Intent(getApplicationContext(), Page_Penang.class);
                        startActivity(testIntent1);
                        break;

                }
            }
        });*/

    }
    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.search_menu,menu);

        MenuItem searchmenuItem = menu.findItem(R.id.action_search);
        SearchView searchView = (SearchView) searchmenuItem.getActionView();

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                mAdapter.getFilter().filter(newText);
                return false;
            }
        });
        return true;
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
}