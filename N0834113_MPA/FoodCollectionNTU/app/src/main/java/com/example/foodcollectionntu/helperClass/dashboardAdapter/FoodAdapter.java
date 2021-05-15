package com.example.foodcollectionntu.helperClass.dashboardAdapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.foodcollectionntu.R;
import com.example.foodcollectionntu.User.MenuActivity;
import com.example.foodcollectionntu.User.restaurants;

import java.util.ArrayList;

public class FoodAdapter extends RecyclerView.Adapter<FoodAdapter.FoodViewHolder>{

    ArrayList<FoodHelperClass> foodOptions;
    Context mcontext;

    public FoodAdapter(ArrayList<FoodHelperClass> foodOptions,Context context){
        this.foodOptions = foodOptions;
        mcontext = context;
    }

    @NonNull
    @Override
    public FoodViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.quick_add, parent,false);
        FoodViewHolder foodViewHolder = new FoodViewHolder(view);
        return foodViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull FoodViewHolder holder, int position) {
        FoodHelperClass foodhelperClass = foodOptions.get(position);

        holder.foodImage.setImageResource(foodhelperClass.getImage());
        holder.foodTitle.setText(foodhelperClass.getTitle());
        holder.foodDescription.setText(foodhelperClass.getDescription());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mcontext, MenuActivity.class);
                mcontext.startActivity(intent);
            }
        });


    }

    @Override
    public int getItemCount() {
        return foodOptions.size();
    }

    public static class FoodViewHolder extends RecyclerView.ViewHolder{

        ImageView foodImage;
        TextView foodTitle;
        TextView foodDescription;

        public FoodViewHolder(@NonNull View itemView) {
            super(itemView);

            foodImage = itemView.findViewById(R.id.food_image);
            foodTitle = itemView.findViewById(R.id.food_title);
            foodDescription = itemView.findViewById(R.id.foodDescription);

        }
    }



}