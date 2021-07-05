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

    DatabaseHelper DB;
    String currentUser;
    int score;

    private int totalscore = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        Intent intent = getIntent();

        currentUser = intent.getStringExtra("currentUser");

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);

        Button buttonStartQuiz = findViewById(R.id.button_start_quiz);
        textViewscore = findViewById(R.id.text_view_highscore);

        //String usernameCurr = intent.getStringExtra("currentUser");

        //int point = DB.getScore(usernameCurr);
        //int point = 100;
        textViewscore.setText(currentUser);

        //showPoints(currentUser);

        buttonStartQuiz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(StartActivity.this,"Quiz Start!",Toast.LENGTH_SHORT).show();
                startQuiz(currentUser);
            }
        });


        findViewById(R.id.jump_back).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                jumpBack(currentUser);
            }
        });

        findViewById(R.id.bt_open).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent open_camera = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivity(open_camera);

            }
        });


    }


    private void startQuiz(String currentUser) {
        Intent intent = new Intent(StartActivity.this, QuizActivity.class);
        intent.putExtra("currentUser", currentUser);
        startActivity(intent);
    }

    private void jumpBack(String currentUser) {
        Intent intent = new Intent();
        //currentUser = intent.getStringExtra("currentUser");
        intent = new Intent(StartActivity.this, HomeActivity.class);
        intent.putExtra("currentUser", currentUser);
        startActivity(intent);
    }

    private void showPoints(String currentUser)
    {
        //Intent data = new Intent();
        //String currentUser = data.getStringExtra("currentUser");
        int point = DB.getScore(currentUser);
        //textViewscore.setText("Points: " + String.valueOf(point));
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