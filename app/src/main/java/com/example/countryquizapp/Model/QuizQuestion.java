package com.example.countryquizapp.Model;

import java.util.Arrays;

public class QuizQuestion {
    private String question;
    private String correctAnswer;
    private String[] potentialAnswers = new String[3];

    public QuizQuestion() { }

    public QuizQuestion(String question, String correctAnswer, String[] potentialAnswers) {
        this.question = question;
        this.correctAnswer = correctAnswer;
        this.potentialAnswers = potentialAnswers;}

    //Getters
    public String getQuestion() {return question;}
    public String getCorrectAnswer() {return correctAnswer;}
    public String[] getPotentialAnswers() {return potentialAnswers;}

    //Setters
    public void setQuestion(String question) {this.question = question;}
    public void setCorrectAnswer(String correctAnswer) {this.correctAnswer = correctAnswer;}
    public void setPotentialAnswers(String[] potentialAnswers) {this.potentialAnswers = potentialAnswers;}

    @Override
    public String toString() {
        return "QuizQuestion{" +
                "question='" + question + '\'' +
                ", correctAnswer='" + correctAnswer + '\'' +
                ", potentialAnswers=" + Arrays.toString(potentialAnswers) +
                '}'; }
}
