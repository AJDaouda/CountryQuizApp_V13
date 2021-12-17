package com.example.countryquizapp.UI_and_Helpers;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.countryquizapp.Model.Attempt;
import com.example.countryquizapp.R;

import java.util.List;

public class AttemptListAdapter extends RecyclerView.Adapter<AttemptListAdapter.viewHolder>  {

    static Context acontext;
    static List<Attempt> attemptList;

        public AttemptListAdapter(Context context, List<Attempt> list) {
        this.acontext = context;
        this.attemptList = list;
    }

    public static class viewHolder extends RecyclerView.ViewHolder{
        private final TextView aName;
        private final TextView aAns;
        private final TextView aPoint;


        public viewHolder(@NonNull View itemView) {
            super(itemView);
            aName=itemView.findViewById(R.id.attempt);
            aAns=itemView.findViewById(R.id.correctAns);
            aPoint=itemView.findViewById(R.id.point);
        }

        public TextView getaName() {return aName;}
        public TextView getaAns() {return aAns;}
        public TextView getaPoint() {return aPoint;}

        @NonNull
    @Override
    public AttemptListAdapter.viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(acontext).inflate(R.layout.activity_attempts_report,parent,false);
            return new AttemptListAdapter.viewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AttemptListAdapter.viewHolder holder, int position) {
        holder.getaName().setText(attemptList.get(position).getName());
        holder.getaAns().setText(attemptList.get(position).getCorrectAnswer());
        holder.getaPoint().setText(attemptList.get(position).getPoints());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onCountrySelected(allCountriesList.get(position));
            }
        });
    }

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    interface ListClickListener {
        void OwnerAttemptClicked(Attempt selectedAttempt);
    }

    ListClickListener listner;






    }
/*
 @Override
    public OwnerCarsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mCtx).inflate(R.layout.owner_item, parent, false);
        return new OwnerCarsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(OwnerCarsViewHolder holder, int position) {
        Owner t = ownerList.get(position);
        holder.cityTextView.setText(t.name);

    }

    @Override
    public int getItemCount() {
        return ownerList.size();
    }
    class OwnerCarsViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        TextView cityTextView, countryTextView;

        public OwnerCarsViewHolder(View itemView) {
            super(itemView);

            cityTextView = itemView.findViewById(R.id.ownername);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            Owner owner = ownerList.get(getAdapterPosition());
            listner.OwnerAdapterClickListener(owner);
        }
    }

















List<Attempt> listOfAttempts;
    Context activity_Context;

    AttemptReportAdapter(List<Attempt> list, Context activity_context){
        listOfAttempts = list;
        activity_Context = activity_context;
    }

    public interface ListClickListener{
        void onAttemptSelected(Attempt selectedAttempt);}

    public AttemptReportAdapter.ListClickListener listener;

    public static class viewHolder extends RecyclerView.ViewHolder{
        private final TextView name;
        private final TextView correctAns;
        private final TextView point;

        public viewHolder(@NonNull View itemView) {
            super(itemView);
            name=itemView.findViewById(R.id.attempt);
            correctAns = itemView.findViewById(R.id.correctAns);
            point = itemView.findViewById(R.id.point); }

        public TextView getName() {return name; }
        public TextView getCorrectAns() {return correctAns;}
        public TextView getPoint() {return point; }
    }

    @NonNull
    @Override
    public AttemptReportAdapter.viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(activity_Context).inflate(R.layout.activity_attempts_report,parent,false);
        return new AttemptReportAdapter.viewHolder(view); }

    @Override
    public void onBindViewHolder(@NonNull AttemptReportAdapter.viewHolder holder, int position) {
        holder.getName().setText(listOfAttempts.get(position).getName()+"");
       // holder.getName().setText(listOfAttempts.get(position).getName());
        holder.getCorrectAns().setText(listOfAttempts.get(position).getCorrectAnswer()+ " correct answers");
        holder.getPoint().setText(listOfAttempts.get(position).getPoints()+" points");

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onAttemptSelected(listOfAttempts.get(position));
            }
        });
    }


    @Override
    public int getItemCount() {return listOfAttempts.size(); }
 */

