package com.example.krunkedkamloops;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class RestaurantListRecyclerAdapter extends RecyclerView.Adapter<RestaurantListRecyclerAdapter.ViewHolder> { // the generic is the ViewHolder that will be shown in the recycler view
    private static final String TAG = "RestaurantListRecyclerAdapter";

    private ArrayList<String> mPubNames = new ArrayList<>(); // list of pub names
    private ArrayList<String> mPubLocations = new ArrayList<>(); // list of pub locations
    private Context mContext;


    public RestaurantListRecyclerAdapter(Context context, ArrayList<String> pubNames, ArrayList<String> pubLocations) {
        mPubNames = pubNames;
        mPubLocations = pubLocations;
        mContext = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()) // Get the context from the parent
                .inflate(R.layout.restaurant_listitem, parent, false); // make the thing from the restaurant_listitem
        ViewHolder holder = new ViewHolder(view); // make the viewholder from the info that was inflated
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        holder.pubNameText.setText(mPubNames.get(position));
        holder.pubLocText.setText(mPubLocations.get(position));
        holder.pubNameText.setOnClickListener(new View.OnClickListener(){ // On click listener for the pub name
            @Override
            public void onClick(View view){ // stuff to do when pub name text is clicked
                Log.d(TAG, "onClick: clicked on: " + mPubNames.get(position)); // in logcat
                Toast.makeText(mContext, mPubNames.get(position), Toast.LENGTH_SHORT).show(); // on screen
            }
        });

        holder.pubLocText.setOnClickListener(new View.OnClickListener(){ // on click listener for the pub location
            @Override
            public void onClick(View view){ // stuff to do when pub location text is clicked
                Log.d(TAG, "onClick: clicked on: " + mPubLocations.get(position)); // in logcat
                Toast.makeText(mContext, mPubLocations.get(position), Toast.LENGTH_SHORT).show(); // on screen
            }
        });
    }

    @Override
    public int getItemCount() {
        return mPubNames.size(); // the number of items is equal to the number of items in the pub name list
    }


    public static class ViewHolder extends RecyclerView.ViewHolder{ // the thing that holds the info for the single list item
        TextView pubNameText; // the name of the pub
        TextView pubLocText; // the location of the pub
        ConstraintLayout parentLayout; // the layout that holds the list item

        public ViewHolder(View itemView){
            super(itemView);
            pubNameText = itemView.findViewById(R.id.pubNameText);
            pubLocText = itemView.findViewById(R.id.pubLocationText);
            parentLayout = itemView.findViewById(R.id.parentLayout);
        }
    }
}
