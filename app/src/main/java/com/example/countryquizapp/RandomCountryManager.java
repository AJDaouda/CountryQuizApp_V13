package com.example.countryquizapp;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class RandomCountryManager {
    private ArrayList<MainRandomCountry> flags = new ArrayList();

    public RandomCountryManager(){
        MainRandomCountry country0 = new MainRandomCountry(R.drawable.ao);
        flags.add(country0);
        MainRandomCountry country1 = new MainRandomCountry(R.drawable.bf);
        flags.add(country1);
        MainRandomCountry country2 = new MainRandomCountry(R.drawable.bi);
        flags.add(country2);
        MainRandomCountry country3 = new MainRandomCountry(R.drawable.bj);
        flags.add(country3);
        MainRandomCountry country4 = new MainRandomCountry(R.drawable.cd);
        flags.add(country4);
        MainRandomCountry country5 = new MainRandomCountry(R.drawable.cf);
        flags.add(country5);
        MainRandomCountry country6 = new MainRandomCountry(R.drawable.cg);
        flags.add(country6);
        MainRandomCountry country7 = new MainRandomCountry(R.drawable.ci);
        flags.add(country7);
        MainRandomCountry country8 = new MainRandomCountry(R.drawable.cm);
        flags.add(country8);
        MainRandomCountry country9 = new MainRandomCountry(R.drawable.cv);
        flags.add(country9);
        MainRandomCountry country10 = new MainRandomCountry(R.drawable.dj);
        flags.add(country10);
        MainRandomCountry country11 = new MainRandomCountry(R.drawable.dz);
        flags.add(country11);
        MainRandomCountry country12 = new MainRandomCountry(R.drawable.eg);
        flags.add(country12);
        MainRandomCountry country13 = new MainRandomCountry(R.drawable.eh);
        flags.add(country13);
        MainRandomCountry country14 = new MainRandomCountry(R.drawable.er);
        flags.add(country14);
        MainRandomCountry country15 = new MainRandomCountry(R.drawable.et);
        flags.add(country15);

        /*
        MainRandomCountry country16 = new MainRandomCountry(R.drawable.ga);
        MainRandomCountry country17 = new MainRandomCountry(R.drawable.gh);
        MainRandomCountry country18 = new MainRandomCountry(R.drawable.gm);
        MainRandomCountry country19 = new MainRandomCountry(R.drawable.gn);
        MainRandomCountry country20 = new MainRandomCountry(R.drawable.gq);
        MainRandomCountry country21 = new MainRandomCountry(R.drawable.gw);
        MainRandomCountry country22 = new MainRandomCountry(R.drawable.ke);
        MainRandomCountry country23= new MainRandomCountry(R.drawable.km);
        MainRandomCountry country24 = new MainRandomCountry(R.drawable.lr);
        MainRandomCountry country25 = new MainRandomCountry(R.drawable.ls);
        MainRandomCountry country26 = new MainRandomCountry(R.drawable.ly);
        MainRandomCountry country28= new MainRandomCountry(R.drawable.ma);
        MainRandomCountry country29 = new MainRandomCountry(R.drawable.mg);
        MainRandomCountry country30 = new MainRandomCountry(R.drawable.ml);

        MainRandomCountry country31 = new MainRandomCountry(R.drawable.mr);
        MainRandomCountry country32 = new MainRandomCountry(R.drawable.mu);
        MainRandomCountry country33 = new MainRandomCountry(R.drawable.mw);
        MainRandomCountry country34 = new MainRandomCountry(R.drawable.mz);
        MainRandomCountry country35 = new MainRandomCountry(R.drawable.na);
        MainRandomCountry country36 = new MainRandomCountry(R.drawable.);
        MainRandomCountry country37 = new MainRandomCountry(R.drawable.ao);
        MainRandomCountry country38 = new MainRandomCountry(R.drawable.ao);
        MainRandomCountry country39 = new MainRandomCountry(R.drawable.ao);
        MainRandomCountry country40 = new MainRandomCountry(R.drawable.ao);
        MainRandomCountry country41 = new MainRandomCountry(R.drawable.ao);
        MainRandomCountry country42 = new MainRandomCountry(R.drawable.ao);
        MainRandomCountry country43 = new MainRandomCountry(R.drawable.ao);
        MainRandomCountry country44 = new MainRandomCountry(R.drawable.ao);
        MainRandomCountry country45 = new MainRandomCountry(R.drawable.ao);
        MainRandomCountry country46 = new MainRandomCountry(R.drawable.ao);
        MainRandomCountry country47 = new MainRandomCountry(R.drawable.ao);
        MainRandomCountry country48 = new MainRandomCountry(R.drawable.ao);
        MainRandomCountry country49 = new MainRandomCountry(R.drawable.ao);
        MainRandomCountry country50 = new MainRandomCountry(R.drawable.ao);
        MainRandomCountry country51 = new MainRandomCountry(R.drawable.ao);
        MainRandomCountry country52 = new MainRandomCountry(R.drawable.ao);
        MainRandomCountry country53 = new MainRandomCountry(R.drawable.ao);
        MainRandomCountry country54 = new MainRandomCountry(R.drawable.ao);
        MainRandomCountry country55 = new MainRandomCountry(R.drawable.ao);
        MainRandomCountry country56 = new MainRandomCountry(R.drawable.ao);
        MainRandomCountry country57 = new MainRandomCountry(R.drawable.ao);
        MainRandomCountry country58 = new MainRandomCountry(R.drawable.ao);*/
    }

    public ArrayList<MainRandomCountry> getFlags() {return flags; }

    public void shuffle(){
        Collections.shuffle(flags);
       }


}
