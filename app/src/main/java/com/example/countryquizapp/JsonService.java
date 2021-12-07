package com.example.countryquizapp;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class JsonService {
    ArrayList<Country> allCountriesFromAPI = new ArrayList<>(0);
    ArrayList<Country> allRequiredCountries;
    ArrayList<Country> allRequiredCountryEmojis = new ArrayList<>(0);
    Country data;
    //String emoji="";
    //public ArrayList<Country> parseCountriesFromJsonAPIData(String jsonStringfromAPI){
    public ArrayList<Country> parseCountriesFromJsonAPIData(String jsonStringfromAPI){
        try {
            JSONObject jsonObject = new JSONObject(jsonStringfromAPI);// root data
            JSONObject countriesObj =  jsonObject.getJSONObject("countries");
            JSONArray countryData = countriesObj.getJSONArray("country");
            for (int i = 0 ; i< countryData.length(); i++) {
                JSONObject country = countryData.getJSONObject(i);
                String continentName = country.getString("continentName");
                if (continentName.equals("Africa")) {
                    String code = country.getString("countryCode");
                    String countryName = country.getString("countryName");
                    allCountriesFromAPI.add(data = new Country(code,countryName));
                }
            }

        } catch (JSONException e) {
            e.printStackTrace();
        }

        return allCountriesFromAPI;
    }
}
