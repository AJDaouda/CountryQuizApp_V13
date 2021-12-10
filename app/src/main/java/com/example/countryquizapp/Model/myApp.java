package com.example.countryquizapp.Model;

import android.app.Application;

import com.example.countryquizapp.Activities_Helpers.JsonService;
import com.example.countryquizapp.Activities_Helpers.NetworkService;

public class myApp extends Application {
    private NetworkService networkingService = new NetworkService();
    private JsonService jsonService = new JsonService();
    private QuestionManager qManager = new QuestionManager();


    public NetworkService getNetworkingService() {return networkingService;}
    public JsonService getJsonService() {return jsonService;}
    public QuestionManager getqManager() {return qManager;}
}
