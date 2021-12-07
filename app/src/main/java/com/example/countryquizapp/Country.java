package com.example.countryquizapp;

public class Country {
    String code;
    String countryName;
    String countryEmoji;
    String continent;

    //Creating Constructors

//    public Country() { }
//
//    public Country(String emoji) { }
//
//    public Country(String code, String countryName){
//        this.code = this.code;
//        this.countryName = this.countryName;}

    public Country(String code, String country) {//Used in "JsonService" in "" method
        this.code = code;
        this.countryName = country;
        }

    public Country(String code, String country, String emoji, String continent) {//Used in "JsonService" in "" method
        this.code = code;
        this.countryName = country;
        this.countryEmoji=emoji;
        this.continent = continent;}

    // Creating getters
    public String getCountryCode() {return code;}
    public String getCountryName() {return countryName;}
    public String getContinent() {return continent;}

    // Creating setters
    public void setCode(String code) {this.code = code;}
    public void setCountry(String countryName) {this.countryName = countryName;}
    public void setContinent(String continent) {this.continent = continent;}

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

    @Override
    public String toString() {
        return "Country{" +
                "code='" + code + '\'' +
                ", countryName='" + countryName + '\'' +
                '}';
    }
}
