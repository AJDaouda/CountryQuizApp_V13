package com.example.countryquizapp;

public class CountryListActivity {//implements NetworkService.NetworkingListener
    /*
    NetworkService networkingService;
    JsonService  jsonService;

    FragmentManager fm = getSupportFragmentManager();

    //ArrayList<Country> apiCountrydata;
    //Country  coutryObj = new Country();
    //String apiCountrydata;
    ArrayList<Country> data = new ArrayList<Country>(0);
    ArrayList<Country>emojis = new ArrayList<Country>(0);
    int index = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        networkingService = ((myApp)getApplication()).getNetworkingService();
        networkingService.listener =this;

        networkingService.fetchCountryData();
        networkingService.fetchEmojiData();

        jsonService =  ((myApp)getApplication()).getJsonService();


    }


    @Override
    public void APINetworkListenerForCountryData(String jsonString) {
        System.out.println(jsonString);
        Log.d("country details", jsonString);// not parsed yet.
        //apiCountrydata = jsonService.parseCountriesFromJsonAPIData(jsonString);
        data = jsonService.parseCountriesFromJsonAPIData(jsonString);
        Log.d("data", data.toString()); }

    @Override
    public void APINetworkListenerForCountryEmoji(String jsonString) {
        System.out.println(jsonString);
        Log.d("emoji details", jsonString);
        emojis = jsonService.parseCountryEmojiFromJsonAPIData(jsonString); }*/
}
