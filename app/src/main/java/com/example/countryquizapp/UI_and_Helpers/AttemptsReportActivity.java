package com.example.countryquizapp.UI_and_Helpers;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.example.countryquizapp.Database.DatabaseManager;
import com.example.countryquizapp.Model.Attempt;
import com.example.countryquizapp.Model.myApp;
import com.example.countryquizapp.R;

import java.util.ArrayList;
import java.util.List;

public class AttemptsReportActivity extends AppCompatActivity implements DatabaseManager.DatabaseListener, AttemptListAdapter.ListClickListener{

    ArrayList<Attempt> attemptListFromDB = new ArrayList<>(0) ;
    DatabaseManager dbManager = new DatabaseManager();
    AttemptListAdapter adapter;
    RecyclerView AttemptsRecyclerView;
    TextView numOfAttempts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_attempts_report);

        //Intent fromMain = getIntent();
        dbManager = ((myApp)getApplication()).getdbManager();
        dbManager.listener = this;
        dbManager.getAllAttempts();

        AttemptsRecyclerView = (RecyclerView) findViewById(R.id.list_of_attempts);
        numOfAttempts = (TextView) findViewById(R.id.num_of_attempts);
        AttemptsRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new AttemptListAdapter(attemptListFromDB, this);
        AttemptsRecyclerView.setAdapter(adapter);
        adapter.listener = this;

        //AttemptsRecyclerView.setAdapter(adapter);


       /* if(!(this.getIntent().getParcelableArrayListExtra("All attempts")==null)){
            attemptListFromDB = this.getIntent().getParcelableArrayListExtra("All attempts");
            adapter = new AttemptReportAdapter(attemptListFromDB, this);
            AttemptsRecyclerView.setAdapter(adapter);
            adapter.notifyDataSetChanged();
            System.out.println("My saved attempts is: \n"+ attemptListFromDB.toString());}
        else {

            //attemptListFromDB = this.getIntent().getParcelableArrayListExtra("All attempts");
            System.out.println("My saved attempts is: \n"+ attemptListFromDB);}
       // dbManager.getAllAttempts();*/

        /*
        ItemTouchHelper itemTouchHelper = new ItemTouchHelper(simpleItemTouchCallback);
        itemTouchHelper.onChildViewAttachedToWindow(listOfAttempts);*/

    }


    @Override
    public void databaseAllAttemptsListener(List<Attempt> list) {
        attemptListFromDB = new ArrayList<>(list);
        System.out.println("This is my db list:"+ attemptListFromDB);
       // adapter = new AttemptReportAdapter(attemptListFromDB, this);
        //AttemptsRecyclerView.setAdapter(adapter);
        numOfAttempts.setText("The number of attempts is " + attemptListFromDB.size());
        adapter.listOfAttempts = attemptListFromDB;
        adapter.notifyDataSetChanged();
    }



    /*
    // table view deleget
    ItemTouchHelper.SimpleCallback simpleItemTouchCallback = new ItemTouchHelper.SimpleCallback(
            ItemTouchHelper.DOWN, ItemTouchHelper.LEFT |
            ItemTouchHelper.RIGHT |
            ItemTouchHelper.DOWN |
            ItemTouchHelper.UP) {

        @Override
        public boolean onMove(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder target) {
            Toast.makeText(CarActivity.this, "Item Moveing", Toast.LENGTH_SHORT).show();

            return false;
        }

        @Override
        public void onSwiped(RecyclerView.ViewHolder viewHolder, int swipeDir) {
            //Remove swiped item from list and notify the RecyclerView
            int position = viewHolder.getAdapterPosition();
            dbService.deleteCar(OwnersCarsObject.cars.get(position));
            dbService.getAllCarsForOwner(id);
            adapter.carList.remove(position);
            // we have to remove it from db as well

            adapter.notifyDataSetChanged();

        }
    };
*/

    @Override
    protected void onStart() {
        super.onStart();
        Toast.makeText(this,"QuizReport started",Toast.LENGTH_SHORT).show();
        dbManager = ((myApp)getApplication()).getdbManager();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Toast.makeText(this,"QuizReport restarted",Toast.LENGTH_SHORT).show();
        dbManager = ((myApp)getApplication()).getdbManager();
    }

    protected void onResume() {
        super.onResume();
        dbManager = ((myApp)getApplication()).getdbManager();
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putParcelableArrayList("All attempts", attemptListFromDB);
        System.out.println("my outstate array is: "+ attemptListFromDB.toString());
    }

    @Override
    public void onAttemptSelected(Attempt selectedAttempt) {

    }
}