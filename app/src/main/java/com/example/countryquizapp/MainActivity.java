package com.example.countryquizapp;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements NetworkService.NetworkingListener {

    RandomCountryManager rcMng;
    ImageView randomFlag;
    TextView countryDescription;
    Button toQuiz;

    ArrayList<MainRandomCountry> mainflags = new ArrayList(0);
    int index = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rcMng =  ((myApp)getApplication()).getRcMng();

        randomFlag = (ImageView) findViewById(R.id.random_flag);
        countryDescription = (TextView) findViewById(R.id.country_description);
        toQuiz = (Button) findViewById(R.id.quiz_btn);

        mainflags = rcMng.getFlags();
        rcMng.shuffle();
        randomFlag.setImageResource(mainflags.get(index).getImage_id());


    }


    public void btnClicked(View view) {
        Intent toQuizActivity = new Intent(this, CountryListActivity.class);
        //toQuizActivity.putExtra("countryName",code);
        startActivity(toQuizActivity);
    }

    @Override
    public void APINetworkListenerForCountryData(String jsonString) {

    }

    @Override
    public void APINetworkingListerForImage(Bitmap image) {

    }
}

