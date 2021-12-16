package com.example.countryquizapp.Model;

import android.app.Application;

import com.example.countryquizapp.Database.DatabaseManager;
import com.example.countryquizapp.UI_and_Helpers.JsonService;
import com.example.countryquizapp.UI_and_Helpers.NetworkService;

public class myApp extends Application {
    private NetworkService networkingService = new NetworkService();
    private JsonService jsonService = new JsonService();
    private DatabaseManager dbManager = new DatabaseManager();
    private QuestionManager qManager = new QuestionManager();


    public NetworkService getNetworkingService() {return networkingService;}
    public JsonService getJsonService() {return jsonService;}
    public DatabaseManager getdbManager() {return dbManager; }
    public QuestionManager getqManager() {return qManager;}
}
