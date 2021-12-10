package com.example.countryquizapp.Model;

import android.os.Parcel;
import android.os.Parcelable;

public class Country implements Parcelable {
private String code;
private String countryName;
private String continent;

//Creating Constructors
public Country(String code, String countryName, String capitalCity, String population, String countryCurrencyCode) { }

//    public Country(String code, String countryName){
//        this.code = this.code;
//        this.countryName = this.countryName;}

public Country(String code, String country) {//Used in "JsonService" in "" method
    this.code = code;
    this.countryName = country; }

    // Creating getters
public String getCountryCode() {return code;}
public String getCountryName() {return countryName;}
public String getContinent() {return continent;}

// Creating setters
public void setCode(String code) {this.code = code;}
public void setCountry(String countryName) {this.countryName = countryName;}
public void setContinent(String continent) {this.continent = continent;}

//Implementing Parcelable methods
protected Country(Parcel in) {
    code = in.readString();
    countryName = in.readString();
}
public static final Creator<Country> CREATOR = new Creator<Country>() {

@Override
public Country createFromParcel(Parcel in) {
    return new Country(in); }

@Override
public Country[] newArray(int size) {
    return new Country[size]; }};
@Override
public int describeContents() {
    return 0; }

@Override
public void writeToParcel(Parcel dest, int flags) {
    dest.writeString(code);
    dest.writeString(countryName);
}

   /* @Override
    public String toString() {
        return "Country{" +
                "code='" + code + '\'' +
                ", countryName='" + countryName + '\'' +
                '}'; }*/
   @Override
   public String toString() {return "{" + "code:'" + code + ", countryName:'" + countryName+'}';}


}
/*
    //Implementing Parcelable methods
    protected Country(Parcel in) {
        code = in.readString();
        countryName = in.readString();}
    public static final Creator<Country> CREATOR = new Creator<Country>() {
        @Override
        public Country createFromParcel(Parcel in) {
            return new Country(in);
        }
        @Override
        public Country[] newArray(int size) {
            return new Country[size];
        }
    };
    @Override
    public int describeContents() {
        return 0;
    }
    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(code);
        dest.writeString(countryName);}*/