package com.example.countryquizapp;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class QuizActivity extends AppCompatActivity implements NetworkService.NetworkingListener{
    ImageView flagImage;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);
    }

    @Override
    public void APINetworkListenerForCountryData(String jsonString) {

    }

    @Override
    public void APINetworkingListerForImage(Bitmap image) {
        flagImage.setImageBitmap(image); }
}
