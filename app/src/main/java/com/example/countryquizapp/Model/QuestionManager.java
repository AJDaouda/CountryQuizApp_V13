package com.example.countryquizapp.Model;

import java.util.ArrayList;

public class QuestionManager {
    private ArrayList<QuizQuestion> questionBank = new ArrayList<>();

    public QuestionManager() { }
    public QuestionManager(ArrayList<QuizQuestion> questionBank) {this.questionBank = questionBank;}

    public ArrayList<QuizQuestion> getQuestionBank() {return questionBank;}
    public void setQuestionBank(ArrayList<QuizQuestion> questionBank) {this.questionBank = questionBank;}
}
