package com.example.foodcollectionntu.User;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.foodcollectionntu.R;
import com.example.foodcollectionntu.helperClass.dashboardAdapter.MenuAdapter;
import com.example.foodcollectionntu.helperClass.dashboardAdapter.MenuData;
import com.google.firebase.auth.FirebaseAuth;

public class MenuActivity extends AppCompatActivity {

    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));



        mAuth = FirebaseAuth.getInstance();


        MenuData[] menuData = new MenuData[]{
                new MenuData("Cheese Tomato Pizza", "The Point", "5.99", R.drawable.pizza,mAuth.getUid()),
                new MenuData("Pepperoni Pizza", "The Point", "5.99", R.drawable.pepperoni,mAuth.getUid()),
                new MenuData("Chicken Wings", "The Point", "2.99", R.drawable.chickenwings,mAuth.getUid()),
                new MenuData("Red Sauce Pasta", "The Refectory", "4.50", R.drawable.pasta,mAuth.getUid()),
                new MenuData("Chicken Butterfly", "The Point", "5.99", R.drawable.chickenburger,mAuth.getUid()),
                new MenuData("Jacket Potato", "The Refectory", "4.99", R.drawable.jp,mAuth.getUid()),
                new MenuData("Curly Fries", "The Refectory", "2.99", R.drawable.fries,mAuth.getUid()),
                new MenuData("Ham Cheese Sandwich", "Cafe Barista", "5.99", R.drawable.hamcheese,mAuth.getUid()),
                new MenuData("Hot Chocolate", "Cafe Barista", "2.99", R.drawable.hotchocolate,mAuth.getUid()),
                new MenuData("Coke", "Cafe Barista", "0.99", R.drawable.coke,mAuth.getUid())
        };

        MenuAdapter menuAdapter = new MenuAdapter(menuData,MenuActivity.this);
        recyclerView.setAdapter(menuAdapter);

    }

    public void back(View view){
        Intent intent = new Intent(this, restaurants.class);
        startActivity(intent);
    }









}