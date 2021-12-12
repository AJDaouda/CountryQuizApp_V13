package com.example.countryquizapp.Activities_Helpers;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import com.example.countryquizapp.Model.CountryDetails;
import com.example.countryquizapp.Model.QuestionManager;
import com.example.countryquizapp.Model.QuizQuestion;
import com.example.countryquizapp.Model.myApp;
import com.example.countryquizapp.R;

import java.util.ArrayList;

public class QuizActivity extends AppCompatActivity implements NetworkService.NetworkingListener {
    FragmentManager fm = getSupportFragmentManager();
    NetworkService networkingService;
    QuestionManager qManager;
    AlertDialog.Builder builder;

    //Instance variables
    int index=0;
    int randomNum1,randomNum2;
    int[] randomNumArray = new int[2];
    int progressMaxValue;
    int correctAnswers=0;
    int points=0;

    String countryCode;
    String countryName;
    /*String[] countryCodePotentialAns;
    String[] countryCodePotentialAns;
    String[] countryCodePotentialAns;
    String[] countryCodePotentialAns;*/
    CountryDetails selectedCountry;
    ArrayList<CountryDetails> countriesDetails = new ArrayList<CountryDetails>(0);
    QuizQuestion countryCodeQuiz;
    QuizQuestion currencyCodeQuiz;
    QuizQuestion populationQuiz;
    QuizQuestion capitalCityQuiz;
    ArrayList<QuizQuestion> selectedCountryQuestionBank;
    String playerChoice;

    //Layout Widgets declaration
    ImageView flagImage;
    RadioButton ans_1,ans_2,ans_3;
    ProgressBar myProgress;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        flagImage = (ImageView) findViewById(R.id.quiz_flag_image);
        ans_1 = (RadioButton) findViewById(R.id.Answer_1);
        ans_2 = (RadioButton) findViewById(R.id.Answer_2);
        ans_3 = (RadioButton) findViewById(R.id.Answer_3);
        myProgress =  (ProgressBar) findViewById(R.id.pbar);
        builder = new AlertDialog.Builder(this);
        //myProgress.setMax(progressMaxValue);

        networkingService = ((myApp)getApplication()).getNetworkingService();
        qManager = ((myApp)getApplication()).getqManager();

        //Getting country code to fetch country flag
        Intent fromCountryListActivity = getIntent();
        if(!(fromCountryListActivity.getStringExtra("Country flag")==null)){
            countryCode = this.getIntent().getStringExtra("Country flag");
            System.out.println("My country code is: \n"+ countryCode);}
        else if(!(this.getIntent().getStringExtra("Country flag")==null)){
            countryCode = this.getIntent().getStringExtra("Country flag");
            System.out.println("My country code is: \n"+ countryCode);}

        //Fetching country flag
        networkingService.getCountryFlag(countryCode);
        networkingService.listener =this;

        //Getting "selected country details"
        if(!(fromCountryListActivity.getExtras().get("Selected country details")==null)){
            selectedCountry = (CountryDetails) this.getIntent().getExtras().get("Selected country details");
            countryName = selectedCountry.getCountryName().substring(0,selectedCountry.getCountryName().length()-6);
            System.out.println("My received country details are: \n"+ selectedCountry.toString());
        }
        else if(!(this.getIntent().getExtras().get("Selected country details")==null)){
            selectedCountry = (CountryDetails) this.getIntent().getExtras().get("Selected country details");
            countryName = selectedCountry.getCountryName().substring(0,selectedCountry.getCountryName().length()-6);
            System.out.println("My received country details are: \n"+ selectedCountry.toString());}

        //Getting an array of countries details
        if(!(this.getIntent().getExtras().getParcelableArrayList("listOfCountriesDetails")==null)){
            countriesDetails = this.getIntent().getExtras().getParcelableArrayList("listOfCountriesDetails");
            System.out.println("My received arraylist is: \n"+ countriesDetails);}
        else if(!(this.getIntent().getExtras().getParcelableArrayList("ListOfProd")==null)){
            countriesDetails = this.getIntent().getExtras().getParcelableArrayList("listOfCountriesDetails");
            System.out.println("My received arraylist is: \n"+ countriesDetails);}

        selectedCountryQuestionBank = qManager.getQuestionBank();
        createQBankForSelectedCountry();
        progressMaxValue=qManager.getQuestionBank().size();
        myProgress.setMax(progressMaxValue);

        System.out.println("My quizBank is : \n"+ selectedCountryQuestionBank);

        if(savedInstanceState!= null){
            index = savedInstanceState.getInt("current");
            updateFragment(qManager.getQuestionBank().get(index).getQuestion());
            System.out.println("my list is: " + qManager.getQuestionBank().get(index).getQuestion());
        }
        else{
            updateFragment(qManager.getQuestionBank().get(index).getQuestion());
            System.out.println("Something went wrong");}
            updatePotentialAns();

       /* String potentialAns1 =qManager.getQuestionBank().get(index).getPotentialAnswers()[0];
        String potentialAns2 =qManager.getQuestionBank().get(index).getPotentialAnswers()[1];
        String potentialAns3 =qManager.getQuestionBank().get(index).getPotentialAnswers()[2];
        ans_1.setText(potentialAns1);
        ans_2.setText(potentialAns2);
        ans_3.setText(potentialAns3);*/

    }

    public void updateFragment(String question) {
        fm.findFragmentById(R.id.quiz_frame_id);
        QuestionFragment qFragment = QuestionFragment.newInstance(question);
        fm.beginTransaction().replace(R.id.quiz_frame_id,qFragment).commit();}

    @Override
    public void APINetworkListenerForCountryData(String jsonString) { }

    @Override
    public void APINetworkingListerForImage(Bitmap image) {
        //Displaying country flag
        flagImage.setImageBitmap(image);}

    private int[] getPotentialAnsArray(){
        randomNum1 = (int)Math.floor(Math.random()*(countriesDetails.size()));
        randomNum2 = (int)Math.floor(Math.random()*(countriesDetails.size()));
        randomNumArray[0]=randomNum1;
        randomNumArray[1]=randomNum2;
        return randomNumArray;}

    private void createQBankForSelectedCountry(){
        createCountryCodeQuiz();
        createCapitalCityQuiz();
        createCurrencyCodeQuiz();
        createPopulationQuiz();
        selectedCountryQuestionBank.add(countryCodeQuiz);
        selectedCountryQuestionBank.add(capitalCityQuiz);
        selectedCountryQuestionBank.add(currencyCodeQuiz);
        selectedCountryQuestionBank.add(populationQuiz);}

        private void createCountryCodeQuiz(){
            String countryCodeQ = "What is the country code of "+countryName+"?";
            String countryCodeCorrectAns = selectedCountry.getCode();
            String[] countryCodePotentialAns ;
            getPotentialAnsArray();
            countryCodePotentialAns= new String[]{selectedCountry.getCode(), countriesDetails.get(randomNumArray[0]).getCode(),
            countriesDetails.get(randomNumArray[1]).getCode()};
            countryCodeQuiz = new QuizQuestion(countryCodeQ,countryCodeCorrectAns,countryCodePotentialAns); }

        private void createCurrencyCodeQuiz(){
            String currencyCodeQ = "What is the currency code of "+countryName+"?";
            String currencyCodeCorrectAns = selectedCountry.getCountryCurrencyCode();
            String[] currencyCodePotentialAns ;
            getPotentialAnsArray();
            currencyCodePotentialAns= new String[]{countriesDetails.get(randomNumArray[0]).getCountryCurrencyCode(),selectedCountry.getCountryCurrencyCode(),
                    countriesDetails.get(randomNumArray[1]).getCountryCurrencyCode()};
            currencyCodeQuiz = new QuizQuestion(currencyCodeQ,currencyCodeCorrectAns,currencyCodePotentialAns);}

        private void createPopulationQuiz(){
            String populationQ = "What is the population number of "+countryName+"?";
            String populationCorrectAns = selectedCountry.getPopulation();
            String[] populationPotentialAns ;
            getPotentialAnsArray();
            populationPotentialAns= new String[]{countriesDetails.get(randomNumArray[0]).getPopulation() +" people",
            countriesDetails.get(randomNumArray[1]).getPopulation()+" people",selectedCountry.getPopulation()+" people"};
            populationQuiz = new QuizQuestion(populationQ,populationCorrectAns,populationPotentialAns);}

        private void createCapitalCityQuiz(){
            String capitalCityQ = "What is the capital city of "+countryName+"?";
            String capitalCityCorrectAns = selectedCountry.getCapitalCity();
            String[] capitalCityPotentialAns ;
            getPotentialAnsArray();
            capitalCityPotentialAns= new String[]{ countriesDetails.get(randomNumArray[0]).getCapitalCity(),selectedCountry.getCapitalCity(),
            countriesDetails.get(randomNumArray[1]).getCapitalCity()};
            capitalCityQuiz = new QuizQuestion(capitalCityQ,capitalCityCorrectAns,capitalCityPotentialAns);}

    private void updatePotentialAns(){
        String potentialAns1 =qManager.getQuestionBank().get(index).getPotentialAnswers()[0];
        String potentialAns2 =qManager.getQuestionBank().get(index).getPotentialAnswers()[1];
        String potentialAns3 =qManager.getQuestionBank().get(index).getPotentialAnswers()[2];
        ans_1.setText(potentialAns1);
        ans_2.setText(potentialAns2);
        ans_3.setText(potentialAns3); }

    private void resetRadioBtn() {
       ans_1.setChecked(false);
       ans_2.setChecked(false);
       ans_3.setChecked(false); }

    private void getAnswer(){
        if (playerChoice != qManager.getQuestionBank().get(index).getCorrectAnswer()){
            System.out.println("The user's answer is: "+ playerChoice);
            System.out.println("The correct answer is: "+ qManager.getQuestionBank().get(index).getCorrectAnswer().toString());
            Toast.makeText(this,"Incorrect answer",Toast.LENGTH_SHORT).show();}
        else{
            System.out.println("The user's answer is: "+ playerChoice);
            System.out.println("The correct answer is: "+ qManager.getQuestionBank().get(index).getCorrectAnswer().toString());
            Toast.makeText(this,"Correct",Toast.LENGTH_SHORT).show();
            correctAnswers++;
            points++;}
    }

    public void onRadioButtonClicked(View view) {
        //playerChoice = String.valueOf((RadioButton)view.get)
        // Is the button now checked?
        playerChoice = ((RadioButton) view).getText().toString();
        boolean checked = ((RadioButton) view).isChecked();

        // Check which radio button was clicked
        //showNextOption();
        switch(view.getId()) {
            case R.id.Answer_1:
            case R.id.Answer_2:
            case R.id.Answer_3:
                if (index==qManager.getQuestionBank().size()-1){
                    if (checked)
                    getAnswer();
                    myProgress.setProgress(progressMaxValue);
                    showNextOption();
                    System.out.println("The number of correct answer is: "+ correctAnswers +
                            ", and you have accumulated "+points);
                    //resetRadioBtn();
                }
                else{
                    if (checked)
                    getAnswer();
                    index++;
                    updateFragment(qManager.getQuestionBank().get(index).getQuestion());
                    myProgress.setProgress(index);
                    resetRadioBtn();
                    updatePotentialAns();
                }

                break;}
    }

    /*public void onRadioButtonClicked(View view) {
        //playerChoice = String.valueOf((RadioButton)view.get)
        // Is the button now checked?

        boolean checked = ((RadioButton) view).isChecked();

        // Check which radio button was clicked
        //showNextOption();
        switch(view.getId()) {
            case R.id.Answer_1:
            case R.id.Answer_2:
            case R.id.Answer_3:
                if (index==qManager.getQuestionBank().size()-1){
                    if (checked){
                        playerChoice = ((RadioButton) view).getText().toString(); }
                        getAnswer();
                        myProgress.setProgress(progressMaxValue);
                        showNextOption();
                        System.out.println("The number of correct answer is: "+ correctAnswers +
                                ", and you have accumulated "+points);
                        //resetRadioBtn();
                    }
                else{
                    if (checked){
                        playerChoice = ((RadioButton) view).getText().toString();
                    }
                    getAnswer();
                    index++;
                    updateFragment(qManager.getQuestionBank().get(index).getQuestion());
                    myProgress.setProgress(index);
                    resetRadioBtn();
                    updatePotentialAns();
                    }

                    break;}
        }*/

    private void showNextOption(){
        builder.setTitle(getResources().getString(R.string.nextStep_text));
        builder.setMessage("To save this attempt, click on Save"+
                        "\nTo ignore and take another quiz, click on Ignore");
        builder.setPositiveButton(getResources().getString(R.string.btn_save), new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(getApplicationContext(),"SAVE clicked",Toast.LENGTH_SHORT).show();
                toAttemptsActivity();
                //Create intent to next activity + save to db
                //Attempt #1(autogenerated num from db)
                //CountryName
                //Correct answers
                //Points earned

            }
        });

        builder.setNegativeButton(getResources().getString(R.string.btn_ignore), new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(getApplicationContext(),"IGNORE clicked",Toast.LENGTH_SHORT).show();
                BackToMainActivity(); }
        });
        AlertDialog alertDialog=builder.create();
        builder.show();

    }

    private void BackToMainActivity(){
        Intent backToMain = new Intent(this,MainActivity.class);
        startActivity(backToMain); }

    private void toAttemptsActivity(){
        Intent toAttemptsReport = new Intent(this,AttemptsReportActivity.class);
        startActivity(toAttemptsReport); }


    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("current", index);
    }
}
