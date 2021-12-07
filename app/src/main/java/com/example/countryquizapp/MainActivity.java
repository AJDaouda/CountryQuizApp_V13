package com.example.countryquizapp;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements NetworkService.NetworkingListener,CountryListAdapter.ListClickListener {

    NetworkService networkingService;
   JsonService jsonService;

    //Layout Widgets declaration
    TextView countrytextview;
    RecyclerView countryRecyclerview;

    //ArrayList<Country> apiCountrydata;
    //Country  coutryObj = new Country();
    //String apiCountrydata;
    ArrayList<Country> data = new ArrayList<Country>(0);
    ArrayList<Country>dataToString = new ArrayList<Country>(0);
    //int index = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        networkingService = ((myApp)getApplication()).getNetworkingService();
        jsonService =  ((myApp)getApplication()).getJsonService();
        networkingService.listener =this;
        networkingService.fetchCountryData();
        countrytextview = findViewById(R.id.intro_textView);
        countryRecyclerview = findViewById(R.id.CountryRecyclerView);
        countryRecyclerview.setLayoutManager(new LinearLayoutManager(this));
        CountryListAdapter adapter = new CountryListAdapter(this, data);
        adapter.listener = this;
        countryRecyclerview.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }


    @Override
    public void APINetworkListenerForCountryData(String jsonString) {
       // System.out.println(jsonString);
        Log.d("country details", jsonString);// not parsed yet.
        //apiCountrydata = jsonService.parseCountriesFromJsonAPIData(jsonString);
        data = jsonService.parseCountriesFromJsonAPIData(jsonString);

        Log.d("Printin my data", data.get(0).getCountryName() + data.get(1).getCountryName()+data.get(2).getCountryName());
        System.out.println("****************************THis is my data :" + data.toString()+" ");
    }

    @Override
    public void APINetworkingListerForImage(Bitmap image) {
    }


    @Override
    public void onCountrySelected(Country seletedCountry) {
        String code = seletedCountry.getCountryCode().toString().toLowerCase();
        Intent toQuizActivity = new Intent(this, QuizActivity.class);
        toQuizActivity.putExtra("Country flag",code);
        startActivity(toQuizActivity);
        // System.out.println("My history details are: \n"+ selectedHistory.toString());
        Toast.makeText(this, "Country flag being sent", Toast.LENGTH_SHORT).show();

    }
}
