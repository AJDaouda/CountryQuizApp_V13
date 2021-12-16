package com.example.countryquizapp.UI_and_Helpers;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.countryquizapp.Model.Attempt;
import com.example.countryquizapp.Model.CountryDetails;
import com.example.countryquizapp.R;

import java.util.ArrayList;

public class AttemptReportAdapter extends BaseAdapter {
    ArrayList<Attempt> listOfAttempts;
    Context activity_Context;

    AttemptReportAdapter(ArrayList<Attempt> list, Context activity_context){
        listOfAttempts = list;
        activity_Context = activity_context;
    }


    @Override
    public int getCount() {
        return listOfAttempts.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    // in each row I have one donation item form the array list;
    // 10 donations
    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        view = LayoutInflater.from(activity_Context).inflate(R.layout.attempt_item,null);
        TextView attemptName = view.findViewById(R.id.attempt);
        TextView correctAnswer = view.findViewById(R.id.correctAns);
        TextView point = view.findViewById(R.id.point);
        attemptName.setText(listOfAttempts.get(i).getName()+"");
        correctAnswer.setText(listOfAttempts.get(i).getCorrectAnswer()+" correct answers");
        point.setText(listOfAttempts.get(i).getPoints()+" points");
        return view;
    }
}
