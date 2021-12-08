package com.example.countryquizapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import java.util.ArrayList;

public class CountryListActivity extends AppCompatActivity implements NetworkService.NetworkingListener,CountryListAdapter.ListClickListener{

    NetworkService networkingService;
    JsonService jsonService;

    //Layout Widgets declaration
    // TextView countrytextview;
    RecyclerView countryRecyclerview;

    ArrayList<Country> countrydata = new ArrayList<Country>(0);
    CountryListAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_country_list);
        networkingService = ((myApp)getApplication()).getNetworkingService();
        jsonService =  ((myApp)getApplication()).getJsonService();

        networkingService.listener =this;
        networkingService.fetchCountryData();
        //countrytextview = findViewById(R.id.intro_textView);
        countryRecyclerview = findViewById(R.id.CountryRecyclerView);
        countryRecyclerview.setLayoutManager(new LinearLayoutManager(this));
        adapter = new CountryListAdapter(this, countrydata);
        System.out.println("****************************THis is my data :" + countrydata.toString()+" ");
        adapter.listener = this;
        countryRecyclerview.setAdapter(adapter);
        //adapter.notifyDataSetChanged();
    }



    @Override
    public void APINetworkListenerForCountryData(String jsonString) {
        // System.out.println(jsonString);
        Log.d("country details", jsonString);// not parsed yet.
        countrydata = jsonService.parseCountriesFromJsonAPIData(jsonString);
        Log.d("Printin my data", countrydata.get(0).getCountryName() + " " + countrydata.get(1).getCountryName()+ " " +countrydata.get(2).getCountryName());
        System.out.println("****************************THis is my data :" + countrydata.toString()+" ");
        adapter.allCountriesList = countrydata;
        adapter.notifyDataSetChanged();
    }


    @Override
    public void APINetworkingListerForImage(Bitmap image) {
    }

    @Override
    public void onCountrySelected(Country seletedCountry) {
        String countryCode = seletedCountry.getCountryCode().toString().toLowerCase();
        Intent toQuizActivity = new Intent(this, QuizActivity.class);
        toQuizActivity.putExtra("Country flag",countryCode);
        startActivity(toQuizActivity);
        // System.out.println("My history details are: \n"+ selectedHistory.toString());
        Toast.makeText(this, "Country flag being sent", Toast.LENGTH_SHORT).show();

    }
}