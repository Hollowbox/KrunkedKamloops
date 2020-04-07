package com.example.krunkedkamloops;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RestaurantDetailsRecyclerAdapter extends RecyclerView.Adapter<RestaurantDetailsRecyclerAdapter.ViewHolder>{
    private static final  String TAG = "RestaurantDetailsRecyclerAdapter";

    private ArrayList<String> mDrinkNames = new ArrayList<>();
    private ArrayList<String> mDrinkPrices = new ArrayList<>();
    private Context mContext;

    public RestaurantDetailsRecyclerAdapter(Context mContext, ArrayList<String> mDrinkNames, ArrayList<String> mDrinkPrices) {
        this.mDrinkNames = mDrinkNames;
        this.mDrinkPrices = mDrinkPrices;
        this.mContext = mContext;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.drink_listitem, parent, false);
        ViewHolder holder = new ViewHolder(view);

        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Log.d(TAG, "onBindViewHolder: called");

        holder.drinkNameText.setText(mDrinkNames.get(position));
        holder.drinkPriceText.setText(mDrinkPrices.get(position));
    }

    @Override
    public int getItemCount() {
        return mDrinkNames.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        TextView drinkNameText;
        TextView drinkPriceText;
        ConstraintLayout parentLayout;

        public ViewHolder(View itemView) {
            super(itemView);
            drinkNameText = itemView.findViewById(R.id.drink_NameTextView);
            drinkPriceText = itemView.findViewById(R.id.drink_PriceTextView);
            parentLayout = itemView.findViewById(R.id.drink_Layout);

        }
    }
}
