package com.example.krunkedkamloops;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class RestaurantListActivity extends AppCompatActivity {
    private ArrayList<String> mNames = new ArrayList<>(); // list of pub names
    private ArrayList<String> mLocs = new ArrayList<>(); // list of pub locations


    private RecyclerView recyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restaurant_list);
        initPubData();








        recyclerView = (RecyclerView) findViewById(R.id.restaurantListRecyclerView);

        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);


    }

    // Set up the data
    private void initPubData(){
        String[] names = getResources().getStringArray(R.array.restaurant_names); // Get the list of names
        for(int i = 0; i < names.length; i++){
            mNames.add(names[i]); // add the names to the list
        }
        String[] locs = getResources().getStringArray(R.array.restaurant_locations);
        for(int i = 0; i < locs.length; i++){
            mLocs.add(locs[i]);
        }

        initRecyclerView();
    }

    // Set up the RecyclerView
    private void initRecyclerView(){
        RecyclerView recyclerView = findViewById(R.id.restaurantListRecyclerView); // get the recyclerview reference
        RestaurantListRecyclerAdapter adapter = new RestaurantListRecyclerAdapter(this, mNames, mLocs); // create the adapter
        recyclerView.setAdapter(adapter); // set the recyclerview adapter
        recyclerView.setLayoutManager(new LinearLayoutManager(this)); // set the layout manager

    }
}
