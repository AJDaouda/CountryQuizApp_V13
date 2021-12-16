package com.example.countryquizapp.Database;

import com.example.countryquizapp.Model.Attempt;
import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(version = 1,entities = {Attempt.class})
public abstract class AttemptDatabase extends RoomDatabase{
    public abstract AttemptDAO getAttemptDAO();
    //abstract public AttemptDAO getAttemptDAO();
}
