package com.example.krunkedkamloops;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class RestaurantDetailsActivity extends AppCompatActivity {

    //variables
    private ArrayList<String> mNames = new ArrayList<>();
    private ArrayList<String> mPrices = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restaurant_details);

        initDrinkData();
    }

    private void initDrinkData(){
        String[] names = getResources().getStringArray(R.array.drink_names); // Get the list of names
        for(int i = 0; i < names.length; i++){
            mNames.add(names[i]); // add the names to the list
        }
        String[] prices = getResources().getStringArray(R.array.drink_prices);
        for(int i = 0; i < prices.length; i++){
            mPrices.add(prices[i]);
        }

        initRecyclerView();
    }

    private void initRecyclerView(){
        RecyclerView recyclerView = findViewById(R.id.detail_RecyclerView);
        RestaurantDetailsRecyclerAdapter adapter = new RestaurantDetailsRecyclerAdapter(this,mNames,mPrices);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }
}
