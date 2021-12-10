package com.example.countryquizapp.Activities_Helpers;

import com.example.countryquizapp.Model.Country;
import com.example.countryquizapp.Model.CountryDetails;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class JsonService {
    //ArrayList<Country> allCountriesFromAPI = new ArrayList<>(0);
    ArrayList<CountryDetails> allCountriesdetails = new ArrayList<CountryDetails>(0);

    //public ArrayList<Country> parseCountriesFromJsonAPIData(String jsonStringfromAPI){
    public ArrayList<CountryDetails> parseCountriesFromJsonAPIData(String jsonStringfromAPI){
        try {
            JSONObject jsonObject = new JSONObject(jsonStringfromAPI);// root data
            JSONObject countriesObj =  jsonObject.getJSONObject("countries");
            JSONArray countryData = countriesObj.getJSONArray("country");
            for (int i = 0 ; i<= countryData.length(); i++) {
                JSONObject country = countryData.getJSONObject(i);
                String continentName = country.getString("continentName");
                if (continentName.equals("Africa")) {
                    String code = country.getString("countryCode");
                    String countryName = country.getString("countryName");
                   // allCountriesFromAPI.add(new Country(code,countryName));
                    String countryCurrencyCode = country.getString("currencyCode");
                    //int population = Integer.parseInt(country.getString("population"));
                    String population = country.getString("population");
                    String capitalCity =country.getString("capital");
                    allCountriesdetails.add(new CountryDetails(code, countryName, capitalCity, population, countryCurrencyCode));
                }
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return allCountriesdetails;
    }



}
