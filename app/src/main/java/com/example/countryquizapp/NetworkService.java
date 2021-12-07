package com.example.countryquizapp;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class NetworkService {
    //Instanciating URL strings
    //String countryURL = "https://api.first.org/data/v1/countries";
    String countryURL ="https://gist.githubusercontent.com/tiagodealmeida/0b97ccf117252d742dddf098bc6cc58a/raw/f621703926fc13be4f618fb4a058d0454177cceb/countries.json";
    String flagURL1 = "https://flagcdn.com/80x60/";
    String flagURL2 = ".png";

    public static final ExecutorService networkingExecutor = Executors.newFixedThreadPool(4);
    static Handler networkHandler = new Handler(Looper.getMainLooper());
    //This handler is pointing to the mainActivity Looper, therefore it can pot message on the mainActivity thread

    interface NetworkingListener{
        void APINetworkListenerForCountryData(String jsonString);
        void APINetworkingListerForImage(Bitmap image);}

    NetworkingListener listener;


    public void fetchCountryData(){
        String completeURL = countryURL;
        connect(completeURL); }



    public void getCountryFlag(String countryName){
        String completeURL = flagURL1+countryName+flagURL2;
        networkingExecutor.execute(new Runnable() {
            @Override
            public void run() {
                try {
                    URL urlObj = new URL(completeURL);
                    InputStream in = ((InputStream)urlObj.getContent());
                    Bitmap imageData = BitmapFactory.decodeStream(in);
                    networkHandler.post(new Runnable() {
                        @Override
                        public void run() {
                            listener.APINetworkingListerForImage(imageData);
                        }
                    });
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
    }


    private void connect(String url){
        networkingExecutor.execute(new Runnable() {
            //String jsonString = "";
            @Override
            public void run() {
                HttpURLConnection httpURLConnection = null;
                try {
                    /*URL urlObject = new URL(url);
                    httpURLConnection = (HttpURLConnection) urlObject.openConnection();
                    httpURLConnection.setRequestMethod("GET");
                    httpURLConnection.setRequestProperty("Content-Type","application/json");
                    int statues = httpURLConnection.getResponseCode();*/
                    URL urlObject = new URL(url);
                    httpURLConnection = (HttpURLConnection) urlObject.openConnection();
                    httpURLConnection.setRequestMethod("GET");
                    httpURLConnection.setRequestProperty("Content-Type", "application/json");
                    // httpURLConnection.setRequestProperty("X-Parse-Application-Id", applicationID); // This is your app's application id
                    //httpURLConnection.setRequestProperty("X-Parse-REST-API-Key", APIKey); // This is your app's REST API key
                    int status = httpURLConnection.getResponseCode();

                    if ((status >= 200) && (status <= 299)) {
                        BufferedReader reader = new BufferedReader(new InputStreamReader(httpURLConnection.getInputStream()));
                        StringBuilder stringBuilder = new StringBuilder();
                        String line;
                        while ((line = reader.readLine()) != null) {
                            stringBuilder.append(line);
                        }
                        JSONObject data = new JSONObject(stringBuilder.toString()); // Here you have the data that you need
                        //Log.d("MainActivity", data.toString(2));
                        Log.d("MainActivity", data.toString());
                        final String finalJson = data.toString();
                        networkHandler.post(new Runnable() {
                            @Override
                            public void run() {
                                //send data to main thread
                                listener.APINetworkListenerForCountryData(finalJson);

                            }
                        });
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (JSONException e) {
                    e.printStackTrace();
                } finally {
                    httpURLConnection.disconnect();
                }
            }
        });
    }
}
