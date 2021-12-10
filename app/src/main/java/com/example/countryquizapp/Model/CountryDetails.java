package com.example.countryquizapp.Model;

import android.os.Parcel;
import android.os.Parcelable;

public class CountryDetails implements Parcelable {
    private String code;
    private String countryName;
    private String capitalCity;
    //private int population;
    private String population;
    private String countryCurrencyCode;

    //Constructors
    public CountryDetails() { }

    public CountryDetails(String code, String countryName, String capitalCity, String population, String countryCurrencyCode) {
        this.code = code;
        this.countryName = countryName;
        this.capitalCity = capitalCity;
        this.population = population;
        this.countryCurrencyCode = countryCurrencyCode; }

    //Getters
    public String getCode() {return code;}
    public String getCountryName() {return countryName;}
    public String getCapitalCity() {return capitalCity;}
    public String getPopulation() {return population;}
    public String getCountryCurrencyCode() {return countryCurrencyCode;}

    //Setters
    public void setCode(String code) {this.code = code; }
    public void setCountryName(String countryName) {this.countryName = countryName;}
    public void setCapitalCity(String capitalCity) {this.capitalCity = capitalCity;}
    public void setPopulation(String population) {this.population = population; }
    public void setCountryCurrencyCode(String countryCurrencyCode) {this.countryCurrencyCode = countryCurrencyCode; }

    //Implementing Parcelable methods
    protected CountryDetails(Parcel in) {
        code = in.readString();
        countryName = in.readString();
        capitalCity = in.readString();
        population = in.readString();
        countryCurrencyCode = in.readString(); }

    public static final Creator<CountryDetails> CREATOR = new Creator<CountryDetails>() {

        @Override
        public CountryDetails createFromParcel(Parcel in) {
            return new CountryDetails(in); }

        @Override
        public CountryDetails[] newArray(int size) {
            return new CountryDetails[size]; }};
    @Override
    public int describeContents() {
        return 0; }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(code);
        dest.writeString(countryName);
        dest.writeString(capitalCity);
        dest.writeString(population);
        dest.writeString(countryCurrencyCode); }

    @Override
    public String toString() {
        return "CountryDetails{" +
                "code='" + code + '\'' +
                ", countryName='" + countryName + '\'' +
                ", capitalCity='" + capitalCity + '\'' +
                ", population=" + population +
                ", countryCurrencyCode='" + countryCurrencyCode + '\'' +
                '}'; }
}
