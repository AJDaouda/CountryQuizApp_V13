package com.example.countryquizapp.Model;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Attempt implements Parcelable {

    @PrimaryKey(autoGenerate = true)
    public int id;

    public String name;
    public int correctAnswer;
    public int points;

    public Attempt() { }

    public Attempt(String name, int correctAnswer, int points) {
        this.name = name;
        this.correctAnswer = correctAnswer;
        this.points = points; }

  /*  public Attempt(int id, String name, int correctAnswer, int points) {
        this.id = id;
        this.name = name;
        this.correctAnswer = correctAnswer;
        this.points = points; }*/

    //Getters
    //public int getId() {return id;}
    public String getName() {return name;}
    public int getCorrectAnswer() {return correctAnswer;}
    public int getPoints() {return points;}

    //Setters
   // public void setId(int id) {this.id = id;}
    public void setName(String name) {this.name = name;}
    public void setCorrectAnswer(int correctAnswer) {this.correctAnswer = correctAnswer;}
    public void setPoints(int points) {this.points = points;}

    //Implementing Parcelable methods
    protected Attempt(Parcel in) {
        name = in.readString();
        correctAnswer = in.readInt();
        points = in.readInt(); }

    public static final Creator<Attempt> CREATOR = new Creator<Attempt>() {

    @Override
    public Attempt createFromParcel(Parcel in) {
        return new Attempt(in); }

    @Override
    public Attempt[] newArray(int size) {
        return new Attempt[size]; }};

    @Override
    public int describeContents() {return 0;}

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeInt(correctAnswer);
        dest.writeInt(points); }

    //toString method
    @Override
    public String toString() {
        return "{Attempt: " + "name= " + name  + ", correctAnswer= " + correctAnswer +
                ", points= " + points + '}';
    }
}
