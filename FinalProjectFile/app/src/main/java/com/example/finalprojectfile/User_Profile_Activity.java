package com.example.finalprojectfile;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

public class User_Profile_Activity extends AppCompatActivity implements View.OnClickListener{


    //private EditText usernameET;


    private EditText passwordET;
    private DatabaseHelper DB;

    private ImageView profileImageView;
    private Button pickImage;
    private Button saveChanges;

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
        DB = new DatabaseHelper(this);

        Intent intent = getIntent();
        currentUser = intent.getStringExtra("currentUser");

        pickImage.setOnClickListener(this);
    }

    //saveChanges.setOnClickListener(new View.OnClickListener(){


    //});



    @Override
    public void onClick(View view) {
        switch(view.getId()){
            case R.id.pick_image:
                Intent photoPickerIntent = new Intent(Intent.ACTION_PICK);
                photoPickerIntent.setType("image/*");
                startActivityForResult(photoPickerIntent, SELECT_PHOTO);
                break;

            case R.id.save_changes:
                String passwordString = passwordET.getText().toString();

                if(passwordString.equals("")) {
                    Toast.makeText(User_Profile_Activity.this, "Please enter all the fields", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    Toast.makeText(User_Profile_Activity.this, "Password Updated", Toast.LENGTH_SHORT).show();
                    DB.updatePassword(currentUser, passwordString);
                }
                break;
        }

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