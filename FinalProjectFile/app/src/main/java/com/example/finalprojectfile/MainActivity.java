package com.example.finalprojectfile;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

//import java.util.logging.Handler;
//import java.util.logging.LogRecord;

public class MainActivity extends AppCompatActivity {

    private static int SPLASH_SCREEN = 5000;

    int loading_time = 5000;

    //Variables
    Animation topAnim;
    ImageView logoImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);

        //Animations
        topAnim = AnimationUtils.loadAnimation(this,R.anim.top_animation);

        //Hooks
        logoImage = findViewById(R.id.splash_logo);

        logoImage.setAnimation(topAnim);

        //postDelayed(new Runnable())

        new Handler().postDelayed(new Runnable() {
            @Override

            public void run() {

                Intent home = new Intent(MainActivity.this, HomeActivity.class);
                startActivity(home);
                finish();
            }
        }, loading_time);

    }
}