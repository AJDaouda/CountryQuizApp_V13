package com.example.countryquizapp.Activities_Helpers;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RadioButton;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import com.example.countryquizapp.Model.Country;
import com.example.countryquizapp.Model.CountryDetails;
import com.example.countryquizapp.Model.QuestionManager;
import com.example.countryquizapp.Model.QuizQuestion;
import com.example.countryquizapp.Model.myApp;
import com.example.countryquizapp.R;

import java.util.ArrayList;

public class QuizActivity extends AppCompatActivity implements NetworkService.NetworkingListener {
    //Instance variables
    String countryCode;
    CountryDetails selectedCountry;
    ArrayList<CountryDetails> countriesDetails = new ArrayList<CountryDetails>(0);
   // QuizActivity selectedCountryQuiz;
    ArrayList<QuizQuestion> selectedCountryQuestionBank;
    String playerChoice;

    //Layout Widgets declaration
    ImageView flagImage;
    RadioButton ans_1,ans_2,ans_3;
    ProgressBar myProgress;

    FragmentManager fm = getSupportFragmentManager();
    NetworkService networkingService;
    QuestionManager qManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        flagImage = (ImageView) findViewById(R.id.quiz_flag_image);
        ans_1 = (RadioButton) findViewById(R.id.Answer_1);
        ans_2 = (RadioButton) findViewById(R.id.Answer_2);
        ans_3 = (RadioButton) findViewById(R.id.Answer_3);
        myProgress =  (ProgressBar) findViewById(R.id.pbar);

        networkingService = ((myApp)getApplication()).getNetworkingService();
        qManager = ((myApp)getApplication()).getqManager();

        //Getting country code to fetch country flag
        Intent fromCountryListActivity = getIntent();
        if(!(this.getIntent().getStringExtra("Country flag")==null)){
            countryCode = this.getIntent().getStringExtra("Country flag");
            System.out.println("My country code is: \n"+ countryCode);}
        else if(!(this.getIntent().getStringExtra("Country flag")==null)){
            countryCode = this.getIntent().getStringExtra("Country flag");
            System.out.println("My country code is: \n"+ countryCode);}

        //Fetching country flag
        networkingService.getCountryFlag(countryCode);
        networkingService.listener =this;

        //Getting "selected country details"
        if(!(this.getIntent().getExtras().get("Selected country details")==null)){
            selectedCountry = (CountryDetails) this.getIntent().getExtras().get("Selected country details");
            System.out.println("My received country details are: \n"+ selectedCountry.toString());
        }
        else if(!(this.getIntent().getExtras().get("Selected country details")==null)){
            selectedCountry = (CountryDetails) this.getIntent().getExtras().get("Selected country details");
            System.out.println("My received country details are: \n"+ selectedCountry.toString());}

        //Getting an array of countries details
        if(!(this.getIntent().getExtras().getParcelableArrayList("listOfCountriesDetails")==null)){
            countriesDetails = this.getIntent().getExtras().getParcelableArrayList("listOfCountriesDetails");
            System.out.println("My received arraylist is: \n"+ countriesDetails);}
        else if(!(this.getIntent().getExtras().getParcelableArrayList("ListOfProd")==null)){
            countriesDetails = this.getIntent().getExtras().getParcelableArrayList("listOfCountriesDetails");
            System.out.println("My received arraylist is: \n"+ countriesDetails);}
    }


    @Override
    public void APINetworkListenerForCountryData(String jsonString) { }

    @Override
    public void APINetworkingListerForImage(Bitmap image) {
        //Displaying country flag
        flagImage.setImageBitmap(image);
    }


    private ArrayList<QuizQuestion> createQBankForSelectedCountry(){
        String question = "What is the countryCode of "+selectedCountry.getCountryName()+" ?";
        String correctAnswer = selectedCountry.getCountryCurrencyCode();
        String[] potentialAnswers = ;
        QuizQuestion countryCode = new QuizQuestion();

    }

    public void onRadioButtonClicked(View view) {
        //playerChoice = String.valueOf((RadioButton)view.get)
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();

        // Check which radio button was clicked
        switch(view.getId()) {
            case R.id.Answer_1:
                if (checked)
                    playerChoice = ((RadioButton) view).getText().toString();
                    break;
            case R.id.Answer_2:
                if (checked)
                    playerChoice = ((RadioButton) view).getText().toString();
                    break;
            case R.id.Answer_3:
                if (checked)
                    playerChoice = ((RadioButton) view).getText().toString();
                    break;
        }



    }
}
