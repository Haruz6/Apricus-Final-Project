package com.example.finalprojectfile;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.app.AlertDialog;
import android.content.DialogInterface;

public class Coupon extends AppCompatActivity {

    String currentUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        Intent intent = getIntent();

        currentUser = intent.getStringExtra("currentUser");

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_coupon);
        findViewById(R.id.jump_back).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                jumpHome(currentUser);
            }
        });

        findViewById(R.id.Card).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new AlertDialog.Builder(Coupon.this).setTitle("Hint")//设置对话框标题

                        .setMessage("Do you want to redeem points for discounts?")
                        .setPositiveButton("Yes", new DialogInterface.OnClickListener() {//添加确定按钮

                            @Override
                            public void onClick(DialogInterface dialog, int which) {//确定按钮的响应事件

                            }
                        }).setNegativeButton("No", new DialogInterface.OnClickListener() {//添加返回按钮

                    @Override
                    public void onClick(DialogInterface dialog, int which) {//响应事件

                    }

                }).show();//在按键响应事件中显示此对话框
            }
        });

        findViewById(R.id.card2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new AlertDialog.Builder(Coupon.this).setTitle("Hint")//设置对话框标题

                        .setMessage("Do you want to redeem points for discounts?")
                        .setPositiveButton("Yes", new DialogInterface.OnClickListener() {//添加确定按钮

                            @Override
                            public void onClick(DialogInterface dialog, int which) {//确定按钮的响应事件

                            }
                        }).setNegativeButton("No", new DialogInterface.OnClickListener() {//添加返回按钮

                    @Override
                    public void onClick(DialogInterface dialog, int which) {//响应事件

                    }

                }).show();//在按键响应事件中显示此对话框
            }
        });

    }

    private void jumpHome(String currentUser) {
        Intent intent = getIntent();
        //currentUser = intent.getStringExtra("currentUser");
        intent = new Intent(Coupon.this, HomeActivity.class);
        intent.putExtra("currentUser", currentUser);
        startActivity(intent);
        //finish();
    }
}