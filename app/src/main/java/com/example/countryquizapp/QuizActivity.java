package com.example.countryquizapp;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

public class QuizActivity extends AppCompatActivity implements NetworkService.NetworkingListener{

    //Layout Widgets declaration
    ImageView flagImage;
    Button btn_true, btn_false;
    ProgressBar myProgress;

    FragmentManager fm = getSupportFragmentManager();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        flagImage = (ImageView) findViewById(R.id.quiz_flag_image);
        btn_true = (Button) findViewById(R.id.btn_T);
        btn_false = (Button) findViewById(R.id.btn_F);
        myProgress =  (ProgressBar) findViewById(R.id.pbar);
    }

    @Override
    public void APINetworkListenerForCountryData(String jsonString) {

    }

    @Override
    public void APINetworkingListerForImage(Bitmap image) {
        flagImage.setImageBitmap(image); }

    public void btnClicked(View view) {
    }
}
