package com.example.countryquizapp;

import android.app.Application;

public class myApp extends Application {
    private NetworkService networkingService = new NetworkService();
    private  JsonService  jsonService = new JsonService();
    private  RandomCountryManager  rcMng = new RandomCountryManager();

    public NetworkService getNetworkingService() {return networkingService;}
    public JsonService getJsonService() {return jsonService;}
    public RandomCountryManager getRcMng() {return rcMng; }
}
