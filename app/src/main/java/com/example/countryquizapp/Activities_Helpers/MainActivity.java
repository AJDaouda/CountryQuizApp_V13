package com.example.countryquizapp.Activities_Helpers;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.countryquizapp.Model.Country;
import com.example.countryquizapp.Model.CountryDetails;
import com.example.countryquizapp.Model.myApp;
import com.example.countryquizapp.R;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements NetworkService.NetworkingListener, CountryListAdapter.ListClickListener {

    NetworkService networkingService;
    JsonService jsonService;

    //Layout Widgets declaration
    // TextView countrytextview;
    RecyclerView countryRecyclerview;

    //ArrayList<Country> countrydata = new ArrayList<Country>(0);
    //ArrayList<Country> countrydata1 = new ArrayList<Country>(0);

    ArrayList<CountryDetails> countrydata = new ArrayList<CountryDetails>(0);
    ArrayList<CountryDetails> countrydata1 = new ArrayList<CountryDetails>(0);
    //ArrayList<CountryDetails> countrydataWithEmojiFlag = new ArrayList<CountryDetails>(0);

    ArrayList<String> countryEmoji1 = new ArrayList<String>(0);


    CountryListAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        networkingService = ((myApp)getApplication()).getNetworkingService();
        jsonService =  ((myApp)getApplication()).getJsonService();

        networkingService.listener =this;
        networkingService.fetchCountryData();
        //countrytextview = findViewById(R.id.intro_textView);
        countryRecyclerview = findViewById(R.id.CountryRecyclerView);
        countryRecyclerview.setLayoutManager(new LinearLayoutManager(this));
        adapter = new CountryListAdapter(this, countrydata1);
        System.out.println("****************************THis is my data :" + countrydata.toString()+" ");
        adapter.listener = this;
        countryRecyclerview.setAdapter(adapter);
        //adapter.notifyDataSetChanged();
    }



    @Override
    public void APINetworkListenerForCountryData(String jsonString) {
        // System.out.println(jsonString);
        Log.d("country details", jsonString);// not parsed yet.
        countrydata = jsonService.parseCountriesFromJsonAPIData(jsonString);
        Log.d("Printin my data", countrydata.get(0).getCountryName() + " " + countrydata.get(1).getCountryName()+ " " +countrydata.get(2).getCountryName());
        Log.d("Printing", countrydata.get(0).getCode() + " " +
                countrydata.get(0).getCountryName()+ " " +countrydata.get(0).getCapitalCity() +
                " " +countrydata.get(0).getPopulation() + " " +countrydata.get(0).getCountryCurrencyCode());

        System.out.println("****************************THis is my data :" + countrydata.toString()+" ");
        countrydata1.add(countrydata.get(0));
        countrydata1.add(countrydata.get(1));
        countrydata1.add(countrydata.get(2));
        countrydata1.add(countrydata.get(3));
        createCountryEmoji();
        createCountriesWithFlag();
        adapter.allCountriesList = countrydata1;
        adapter.notifyDataSetChanged();
    }


    @Override
    public void APINetworkingListerForImage(Bitmap image) {
    }

    @Override
    public void onCountrySelected(CountryDetails seletedCountry) {
        String countryCode = seletedCountry.getCode().toString().toLowerCase();
        Intent toQuizActivity = new Intent(this, QuizActivity.class);
        Bundle bundle = new Bundle();
        bundle.putParcelable("Selected country details",seletedCountry);
        System.out.println("I am sending: \n"+ seletedCountry.toString());
        bundle.putParcelableArrayList("listOfCountriesDetails",countrydata);
        System.out.println("I am sending: \n"+ countrydata.toString());
        toQuizActivity.putExtras(bundle);
        toQuizActivity.putExtra("Country flag",countryCode);
        startActivity(toQuizActivity);
        // System.out.println("My history details are: \n"+ selectedHistory.toString());
        Toast.makeText(this, "Country flag being sent", Toast.LENGTH_SHORT).show(); }

    private void createCountriesWithFlag(){
        for (int i=0;i<=countrydata1.size();i++){
            countrydata.get(i).setCountryName(countrydata.get(i).getCountryName() + "    "+countryEmoji1.get(i));
        }
    }

    private void createCountryEmoji(){
        countryEmoji1.add(getResources().getString(R.string.ao_flag));
        countryEmoji1.add(getResources().getString(R.string.bf_flag));
        countryEmoji1.add(getResources().getString(R.string.bi_flag));
        countryEmoji1.add(getResources().getString(R.string.bj_flag));
        countryEmoji1.add(getResources().getString(R.string.cd_flag));
    }

}

/*private void createCountriesEmoji(){


        String ao_flag = "\uD83C\uDDE6\uD83C\uDDF4";
        countryEmoji.add(ao_flag);
        String bf_flag = "\uD83C\uDDE7\uD83C\uDDEB";
        countryEmoji.add(bf_flag);
        String bi_flag = "\uD83C\uDDE7\uD83C\uDDEE";
        countryEmoji.add(bi_flag);
        String bj_flag = "\uD83C\uDDE7\uD83C\uDDEF";
        countryEmoji.add(bj_flag);
        String bw_flag = "\uD83C\uDDE7\uD83C\uDDFC";
        countryEmoji.add(bw_flag);
        String cd_flag = "\uD83C\uDDE8\uD83C\uDDE9";
        countryEmoji.add(cd_flag);
        String cf_flag = "\uD83C\uDDE8\uD83C\uDDEB";
        countryEmoji.add(cf_flag);
        String cg_flag = "\uD83C\uDDE8\uD83C\uDDEC";
        countryEmoji.add(cg_flag);
        String ci_flag = "\uD83C\uDDE8\uD83C\uDDEE";
        countryEmoji.add(ci_flag);
        String cm_flag = "\uD83C\uDDE8\uD83C\uDDF2";
        countryEmoji.add(cm_flag);
        String cv_flag = "\uD83C\uDDE8\uD83C\uDDFB";
        countryEmoji.add(cv_flag);
        String dj_flag = "\uD83C\uDDE9\uD83C\uDDEF";
        countryEmoji.add(dj_flag);
        String dz_flag = "\uD83C\uDDE9\uD83C\uDDFF";
        countryEmoji.add(dz_flag);
        String eg_flag = "\uD83C\uDDEA\uD83C\uDDEC";
        countryEmoji.add(eg_flag);
        String eh_flag = "\uD83C\uDDEA\uD83C\uDDED";
        countryEmoji.add(eh_flag);
        String er_flag = "\uD83C\uDDEA\uD83C\uDDF7";
        countryEmoji.add(er_flag);
        String et_flag = "\uD83C\uDDEA\uD83C\uDDF9";
        countryEmoji.add(et_flag);
        String ga_flag = "\uD83C\uDDEC\uD83C\uDDE6";
        countryEmoji.add(ga_flag);
        String gh_flag = "\uD83C\uDDEC\uD83C\uDDED";
        countryEmoji.add(gh_flag);
        String gm_flag = "\uD83C\uDDEC\uD83C\uDDF2";
        countryEmoji.add(gm_flag);
    }*/


