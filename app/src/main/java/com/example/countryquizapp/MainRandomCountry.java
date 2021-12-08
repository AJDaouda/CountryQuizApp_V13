package com.example.countryquizapp;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.drawable.Drawable;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class MainRandomCountry {
    String code;
    String country_description;
    int image_id;

    public MainRandomCountry() { }

    public MainRandomCountry(String description) {
        this.country_description = description;}

    public MainRandomCountry(int image_id) {
        this.image_id = image_id; }

    public MainRandomCountry(String description, int image_id) {
        this.country_description = description;
        this.image_id = image_id; }

    //Getters for instance variables
    public String getCountry_description() {return country_description; }
    public int getImage_id() {return image_id;}


}
