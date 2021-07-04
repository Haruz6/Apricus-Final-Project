package com.example.finalprojectfile;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Coupon extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_coupon);
        findViewById(R.id.jump_back).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                jumpHome();
            }
        });

    }

    private void jumpHome() {
        Intent intent = new Intent(Coupon.this, StartActivity.class);
        startActivity(intent);
    }
}