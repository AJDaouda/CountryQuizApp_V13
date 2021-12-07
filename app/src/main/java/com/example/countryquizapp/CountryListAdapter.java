package com.example.countryquizapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class CountryListAdapter extends RecyclerView.Adapter<CountryListAdapter.viewHolder> {
    Context context;
    ArrayList<com.example.countryquizapp.Country> allcountries;

    public interface ListClickListener{
        void onCountrySelected(com.example.countryquizapp.Country seletedCountry);}

    public ListClickListener listener;
    // inner class
    // View Holder = Row in the table
    // static = able to access it from the class without creating object
    //
    public static class viewHolder extends RecyclerView.ViewHolder{
        private final TextView countryName;

        public viewHolder(@NonNull View itemView) {
            super(itemView);
            countryName=itemView.findViewById(R.id.RecyclerCountryName);}

        public TextView getCountryNameName() {return countryName;}
    }

    public CountryListAdapter(Context c, ArrayList<com.example.countryquizapp.Country> countries) {
        context = c;
        allcountries = countries;
    }
    @NonNull
    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.recycler_row_item_for_country,parent,false);//Recycler view Layout
        return new viewHolder(view); }

    @Override
    public void onBindViewHolder(@NonNull viewHolder holder, int position) {
        holder.getCountryNameName().setText(allcountries.get(position).getCountryName());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onCountrySelected(allcountries.get(position));
            }
        });
    }
    @Override
    public int getItemCount() {return allcountries.size(); }
}
