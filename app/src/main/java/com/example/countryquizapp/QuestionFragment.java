package com.example.countryquizapp;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link QuestionFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class QuestionFragment extends Fragment {

    // TODO: Rename and change types and number of parameters
    public static QuestionFragment newInstance(int qId, int colorId) {
        QuestionFragment fragment = new QuestionFragment();
        Bundle args = new Bundle();
        args.putInt("QuestonId", qId);
        args.putInt("ColorId", colorId);
        fragment.setArguments(args);
        return fragment; }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflating the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_question, container, false);
        TextView QText = (TextView)v.findViewById(R.id.qText_id);

        QText.setText(getArguments().getInt("QuestonId"));
        QText.setBackgroundResource(getArguments().getInt("ColorId"));
        return v;
    }
}