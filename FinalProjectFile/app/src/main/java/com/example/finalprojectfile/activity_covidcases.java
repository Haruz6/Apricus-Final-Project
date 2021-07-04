package com.example.finalprojectfile;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import java.lang.ref.ReferenceQueue;

public class activity_covidcases extends AppCompatActivity {

    private TextView glbTotalConfirmed, glbTotalDeath, glbTotalRecovered;
    private TextView myTotalConfirmed, myTotalDeath, myTotalRecovered;
    private ProgressBar progressBar;
    private ImageButton navback;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_covidcases);

        navback = findViewById(R.id.profile_navback);

        glbTotalConfirmed = findViewById(R.id.glb_totConfirmed);
        glbTotalDeath = findViewById(R.id.glb_totDeaths);
        glbTotalRecovered = findViewById(R.id.glb_totRecovered);

        myTotalConfirmed = findViewById(R.id.my_totConfirmed);
        myTotalDeath = findViewById(R.id.my_totDeaths);
        myTotalRecovered = findViewById(R.id.my_totRecovered);
        progressBar = findViewById(R.id.progressBar);

        navback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        getGlobalData();
        getMalayData();

    }

    private void getGlobalData() {
        RequestQueue queue = Volley.newRequestQueue(this);

        String url = "https://corona.lmao.ninja/v2/all";

        StringRequest stringRequest = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                progressBar.setVisibility(View.GONE);

                try {
                    JSONObject jsonObject = new JSONObject(response.toString());

                    glbTotalConfirmed.setText(jsonObject.getString("cases"));
                    glbTotalDeath.setText(jsonObject.getString("deaths"));
                    glbTotalRecovered.setText(jsonObject.getString("recovered"));

                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                progressBar.setVisibility(View.GONE);
                Log.d("Error Response", error.toString());
            }

    });

        queue.add(stringRequest);
    }


    private void getMalayData() {
        RequestQueue queue = Volley.newRequestQueue(this);

        String url = "https://corona.lmao.ninja/v2/countries/malaysia";

        StringRequest stringRequest = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                progressBar.setVisibility(View.GONE);

                try {
                    JSONObject jsonObject = new JSONObject(response.toString());

                    myTotalConfirmed.setText(jsonObject.getString("cases"));
                    myTotalDeath.setText(jsonObject.getString("deaths"));
                    myTotalRecovered.setText(jsonObject.getString("recovered"));

                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                progressBar.setVisibility(View.GONE);
                Log.d("Error Response", error.toString());
            }

        });

        queue.add(stringRequest);
    }
}