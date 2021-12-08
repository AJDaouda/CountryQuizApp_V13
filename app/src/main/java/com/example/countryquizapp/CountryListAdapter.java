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
    Context cContext;
    ArrayList<Country> allCountriesList;

    public CountryListAdapter(Context c, ArrayList<Country> countries) {
        cContext = c;
        allCountriesList = countries; }


    public interface ListClickListener{
        void onCountrySelected(Country seletedCountry);}

    public ListClickListener listener;
    // inner class
    // View Holder = Row in the table
    // static = able to access it from the class without creating object
    public static class viewHolder extends RecyclerView.ViewHolder{
        private final TextView cName;

        public viewHolder(@NonNull View itemView) {
            super(itemView);
            cName=itemView.findViewById(R.id.RecyclerCountryName); }

        public TextView getcName() {return cName;}
    }

    @NonNull
    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(cContext).inflate(R.layout.recycler_row_item_for_country,parent,false);
        return new viewHolder(view); }

    @Override
    public void onBindViewHolder(@NonNull viewHolder holder, int position) {
        holder.getcName().setText(allCountriesList.get(position).getCountryName());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onCountrySelected(allCountriesList.get(position));
            }
        });
    }
    @Override
    public int getItemCount() {return allCountriesList.size(); }
}
