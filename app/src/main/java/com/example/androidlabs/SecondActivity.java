package com.example.androidlabs;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class        SecondActivity extends AppCompatActivity {
    static final int REQUEST_IMAGE_CAPTURE = 1;
    Button chatButton;
    ImageButton camara;
    public static final String ACTIVITY_NAME = "SecondActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        Intent dataFromPreviousPage = getIntent();

        String whatUserTyped = dataFromPreviousPage.getStringExtra("emailInput");
        TextView emailInput = findViewById(R.id.p2emailInput);
        emailInput.setText(whatUserTyped);
        camara = findViewById(R.id.pictureButton);
        camara.setOnClickListener((view) ->{dispatchTakePictureIntent();} );

        chatButton = findViewById(R.id.p2chatButton);
        chatButton.setOnClickListener(clk -> {
                    Intent goToPage3 = new Intent(SecondActivity.this, ListViewExample1.class);
                    startActivity(goToPage3);
                });
        Log.e(ACTIVITY_NAME,"In function:" +"onCreate");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.e(ACTIVITY_NAME,"In function:" +"onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.e(ACTIVITY_NAME,"In function:" +"onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.e(ACTIVITY_NAME,"In function:" +"onPause");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.e(ACTIVITY_NAME,"In function:" +"onDestroy");
    }


    @Override
    protected void onStop() {
        super.onStop();
        Log.e(ACTIVITY_NAME,"In function:" +"onStop");
    }

    private void dispatchTakePictureIntent(){
            Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
            if (takePictureIntent.resolveActivity(getPackageManager()) != null) {
                startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE);
            }
        }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == REQUEST_IMAGE_CAPTURE && resultCode == RESULT_OK) {
            Bundle extras = data.getExtras();
            Bitmap imageBitmap = (Bitmap) extras.get("data");
            camara.setImageBitmap(imageBitmap);
        }
        Log.e(ACTIVITY_NAME,"In function:" +"onActivityResult");
    }





    }

