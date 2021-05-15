package com.example.foodcollectionntu.helperClass.dashboardAdapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.foodcollectionntu.R;
import com.example.foodcollectionntu.User.Dashboard;
import com.example.foodcollectionntu.User.Login;
import com.example.foodcollectionntu.User.restaurants;

import java.util.ArrayList;


public class RestaurantAdapter extends RecyclerView.Adapter<RestaurantAdapter.RestaurantViewHolder> {

    Context mcontext;

    ArrayList<RestaurantHelperClass> restaurantLocations;

    public RestaurantAdapter(ArrayList<RestaurantHelperClass> restaurantLocations, Context context) {
        this.restaurantLocations = restaurantLocations;
        mcontext = context;
    }

    @NonNull
    @Override
    public RestaurantViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.resturant_card_design, parent, false);
        RestaurantViewHolder restaurantViewHolder = new RestaurantViewHolder(view);
        return restaurantViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RestaurantViewHolder holder, int position) {

        RestaurantHelperClass restaurantHelperClass = restaurantLocations.get(position);

        holder.image.setImageResource(restaurantHelperClass.getImage());
        holder.title.setText(restaurantHelperClass.getTitle());
        holder.description.setText(restaurantHelperClass.getDescription());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mcontext, restaurants.class);
                mcontext.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return restaurantLocations.size();
    }


    public static class RestaurantViewHolder extends RecyclerView.ViewHolder{

        ImageView image;
        TextView title, description;


        public RestaurantViewHolder(@NonNull View itemView) {
            super(itemView);
            //hooks

            image = itemView.findViewById(R.id.resturant_image);
            title = itemView.findViewById(R.id.resturant_title);
            description = itemView.findViewById(R.id.resturant_description);

        }
    }




}

