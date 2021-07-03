package com.example.finalprojectfile;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

public class User_Profile_Activity extends AppCompatActivity implements View.OnClickListener{


    //private EditText usernameET;


    private EditText passwordET;
    private DatabaseHelper DB;

    private TextView usernameText;

    private ImageView profileImageView;
    private Button pickImage;
    private Button saveChanges;
    private ImageButton navback;

    String currentUser;

    private static final int SELECT_PHOTO = 1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_profile);

        profileImageView = (ImageView) findViewById(R.id.profile_image);
        passwordET = findViewById(R.id.change_password_edit);
        pickImage = (Button) findViewById(R.id.pick_image);
        saveChanges = findViewById(R.id.save_changes);
        usernameText = findViewById(R.id.profile_username);
        DB = new DatabaseHelper(this);

        navback = findViewById(R.id.profile_navback);

        Intent intent = getIntent();
        currentUser = intent.getStringExtra("currentUser");
        usernameText.setText(currentUser);

        navback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });


        pickImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent photoPickerIntent = new Intent(Intent.ACTION_PICK);
                photoPickerIntent.setType("image/*");
                startActivityForResult(photoPickerIntent, SELECT_PHOTO);
            }
        });


        saveChanges.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent intent = getIntent();
                String usernameCurr = intent.getStringExtra("currentUser");
                String passwordString = passwordET.getText().toString();

                if(passwordString.equals("")) {
                    Toast.makeText(User_Profile_Activity.this, "Please enter all the fields", Toast.LENGTH_SHORT).show();
                }

                else
                    {
                        Boolean updatePass = DB.updatePassword(usernameCurr, passwordString);
                        if(updatePass)
                        {
                            Toast.makeText(User_Profile_Activity.this, "Password Updated", Toast.LENGTH_SHORT).show();
                        }
                        else {
                            Toast.makeText(User_Profile_Activity.this, "Password Update Failed", Toast.LENGTH_SHORT).show();
                        }
                    }
            }
        });
    }

    //saveChanges.setOnClickListener(new View.OnClickListener(){


    //});



    @Override
    public void onClick(View v) {

    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data){
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == SELECT_PHOTO){
            if(resultCode == RESULT_OK){
                try{
                    final Uri imageUri = data.getData();
                    final InputStream imageStream = getContentResolver().openInputStream(imageUri);
                    final Bitmap selectedImage = BitmapFactory.decodeStream(imageStream);
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private void saveUser(){
        //String usernameString = usernameET.getText().toString().trim();
        String passwordString = passwordET.getText().toString();

        if(passwordString.equals("")) {
            Toast.makeText(User_Profile_Activity.this, "Please enter all the fields", Toast.LENGTH_SHORT).show();
        }
        else
        {
            Toast.makeText(User_Profile_Activity.this, "Password Updated", Toast.LENGTH_SHORT).show();
            DB.updatePassword(currentUser, passwordString);
        }

        //profileImageView.setDrawingCacheEnabled(true);
        //profileImageView.buildDrawingCache();
        //Bitmap bitmap = profileImageView.getDrawingCache();
        //Bitmap bitmap = Bitmap.createBitmap(profileImageView.getWidth(),profileImageView.getHeight(),Bitmap.Config.ARGB_8888);
        //ByteArrayOutputStream baos = new ByteArrayOutputStream();
        //bitmap.compress(Bitmap.CompressFormat.JPEG, 100, baos);
        //byte[] data = baos.toByteArray();

    }
}