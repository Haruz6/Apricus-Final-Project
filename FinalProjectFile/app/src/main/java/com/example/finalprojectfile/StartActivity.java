package com.example.finalprojectfile;

import android.app.Activity;
import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import android.widget.TextView;


public class StartActivity extends AppCompatActivity {
    private static final int REQUEST_CODE_QUIZ = 1;

    public static final String SHARED_PREFS = "sharedPrefs";
    public static final String KEY_HIGHSCORE = "keyHighscore";
    private TextView textViewscore;

    //private int highscore;

    private DatabaseHelper DB;
    String currentUser;


    private int totalscore = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);
        Button buttonStartQuiz = findViewById(R.id.button_start_quiz);
        textViewscore = findViewById(R.id.text_view_highscore);


        showPoints();

        buttonStartQuiz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(StartActivity.this,"Quiz Start!",Toast.LENGTH_SHORT).show();
                startQuiz();
            }
        });

        findViewById(R.id.redeem_bt).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                jumpRedeem();
            }
        });

        findViewById(R.id.bt_open).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent();
                i.setAction(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivity(i);
            }
        });


    }
    private void startQuiz() {
        Intent intent = new Intent(StartActivity.this, QuizActivity.class);
        startActivity(intent);
    }

    private void jumpRedeem() {
        Intent intent = new Intent(StartActivity.this, Coupon.class);
        startActivity(intent);
    }

    private void showPoints()
    {
        Intent data = new Intent();
        String currentUser = data.getStringExtra("currentUser");
        int point = DB.getScore(currentUser);
        textViewscore.setText("Points: " + String.valueOf(point));
    }


    /*private void getScore()
    {
        Intent intent = new Intent();

    }



    private void loadHighscore() {
        SharedPreferences prefs = getSharedPreferences(SHARED_PREFS, MODE_PRIVATE);
        highscore = prefs.getInt(KEY_HIGHSCORE, 0);
        textViewscore.setText("Points: " + highscore);
    }

    private void updateHighscore(int highscoreNew) {
        highscore = highscoreNew;
        textViewscore.setText("Points: " + highscore);
        SharedPreferences prefs = getSharedPreferences(SHARED_PREFS, MODE_PRIVATE);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putInt(KEY_HIGHSCORE, highscore);
        editor.apply();
    }*/
}