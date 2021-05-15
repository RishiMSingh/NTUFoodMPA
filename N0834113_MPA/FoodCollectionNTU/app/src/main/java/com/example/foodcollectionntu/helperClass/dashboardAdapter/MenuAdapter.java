package com.example.foodcollectionntu.helperClass.dashboardAdapter;

import android.content.Context;
import android.content.Intent;
import android.text.Layout;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.foodcollectionntu.R;
import com.example.foodcollectionntu.User.CartActivity;
import com.example.foodcollectionntu.User.MenuActivity;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class MenuAdapter extends RecyclerView.Adapter<MenuAdapter.ViewHolder>
{
    MenuData[] menuData;
    Context context;
    String name="";
    String price="";
    String restaurant="";

    private FirebaseFirestore db;

    public MenuAdapter(MenuData[] menuData, MenuActivity activity){
        this.menuData = menuData;
        this.context = activity ;

    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.fooddesign,parent,false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        final MenuData menuDataList = menuData[position];
        holder.foodName.setText(menuDataList.getFoodItemName());
        holder.foodPrice.setText("£"+ menuDataList.getPrice());
        holder.foodRestaurant.setText(menuDataList.getRestaurantName());
        holder.foodImage.setImageResource(menuDataList.getFoodImage());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // Add a new document with a generated ID

                Map<String, Object> mMap = new HashMap<>();
                name = menuDataList.getFoodItemName();
                price = menuDataList.getPrice();
                restaurant = menuDataList.getRestaurantName();
                mMap.put("Item", name);
                mMap.put("Price", price);
                mMap.put("Restaurant", restaurant);
                Toast.makeText(context, name, Toast.LENGTH_SHORT).show();

                db = FirebaseFirestore.getInstance();
                // Create a new user with a first and last name
                db.collection("User").document(menuDataList.getUserID())
                        .collection("Cart").add(mMap).addOnCompleteListener(new OnCompleteListener<DocumentReference>(){

                    @Override
                    public void onComplete(@NonNull Task<DocumentReference> task) {
                        if(task.isSuccessful()){
                            Toast.makeText(context, "Added to cart", Toast.LENGTH_SHORT).show();
                        }

                    }
                });


            }
        });

    }

    @Override
    public int getItemCount() {
        return menuData.length;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        ImageView foodImage;
        TextView foodName;
        TextView foodPrice;
        TextView foodRestaurant;
        LinearLayout parentLayout;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            foodImage = itemView.findViewById(R.id.foodImage1);
            foodPrice = itemView.findViewById(R.id.foodPrice1);
            foodRestaurant = itemView.findViewById(R.id.foodRes1);
            foodName = itemView.findViewById(R.id.foodTitle1);




        }
    }

}
