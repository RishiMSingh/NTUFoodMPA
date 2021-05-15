package com.example.foodcollectionntu.User;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.foodcollectionntu.MapsActivity;
import com.example.foodcollectionntu.R;
import com.example.foodcollectionntu.helperClass.dashboardAdapter.FoodAdapter;
import com.example.foodcollectionntu.helperClass.dashboardAdapter.FoodHelperClass;
import com.example.foodcollectionntu.helperClass.dashboardAdapter.RestaurantAdapter;
import com.example.foodcollectionntu.helperClass.dashboardAdapter.RestaurantHelperClass;
import com.google.android.material.navigation.NavigationView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

public class Dashboard extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    //Variables
    RecyclerView restaurantRecycler, foodRecycler;
    RecyclerView.Adapter adapter;
    ImageView menuIcon;
    static final float END_SCALE = 0.7f;

    private EditText searchBar;



   //Side Navigation
    DrawerLayout drawerLayout;
    NavigationView navigationView;
    LinearLayout contentView;
    FirebaseAuth mAuth;


   @Override
   protected void onCreate(Bundle savedInstanceState){
       super.onCreate(savedInstanceState);
       setContentView(R.layout.activity_dashboard);

       //Hooks for recycler locations
       restaurantRecycler = findViewById(R.id.res_recycler);
       foodRecycler = findViewById(R.id.foodRes);
       //Hooks for menu
       menuIcon = findViewById(R.id.menu_icon);
       drawerLayout =findViewById(R.id.drawer_layout);
       navigationView = findViewById(R.id.navigation_view);
       contentView = findViewById(R.id.content);
       searchBar = findViewById(R.id.search);
       //Functions
       navigationDrawer();
       foodRecycler();
       restaurantRecycler();


       searchBar.addTextChangedListener(new TextWatcher(){

           @Override
           public void beforeTextChanged(CharSequence s, int start, int count, int after) {

           }

           @Override
           public void onTextChanged(CharSequence s, int start, int before, int count) {


           }

           @Override
           public void afterTextChanged(Editable s) {
               Toast.makeText(Dashboard.this, s.toString(), Toast.LENGTH_SHORT).show();
           }
       });


   }

   //navigation
   private void navigationDrawer() {
        //navigation drawer
        navigationView.bringToFront();
        navigationView.setNavigationItemSelectedListener(this);
        navigationView.setCheckedItem(R.id.nav_home);

        menuIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(drawerLayout.isDrawerVisible(GravityCompat.START)){
                    drawerLayout.closeDrawer(GravityCompat.START);
                }
                else{
                    drawerLayout.openDrawer((GravityCompat.START));
                }
            }
        });
        animateNavigationDrawer();

    }

    private void animateNavigationDrawer() {
       drawerLayout.setScrimColor(getResources().getColor(R.color.selected));
        drawerLayout.addDrawerListener(new DrawerLayout.SimpleDrawerListener() {
            @Override
            public void onDrawerSlide(View drawerView, float slideOffset) {

                // Scale the View based on current slide offset
                final float diffScaledOffset = slideOffset * (1 - END_SCALE);
                final float offsetScale = 1 - diffScaledOffset;
                contentView.setScaleX(offsetScale);
                contentView.setScaleY(offsetScale);

                // Translate the View, accounting for the scaled width
                final float xOffset = drawerView.getWidth() * slideOffset;
                final float xOffsetDiff = contentView.getWidth() * diffScaledOffset / 2;
                final float xTranslation = xOffset - xOffsetDiff;
                contentView.setTranslationX(xTranslation);
            }
        });

    }

    @Override
    public void onBackPressed() {
       if(drawerLayout.isDrawerVisible(GravityCompat.START)){
           drawerLayout.closeDrawer(GravityCompat.START);
       }
       else {
           super.onBackPressed();
       }
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
       item.setChecked(true);
       int menu_id = item.getItemId();

       if (menu_id == R.id.nav_home){
           Intent intent = new Intent(Dashboard.this,Dashboard.class);
           startActivity(intent);

           return true;
       }
       if (menu_id == R.id.nav_locations){
           Intent intent = new Intent(Dashboard.this,restaurants.class);
           startActivity(intent);

           return true;
       }
       if (menu_id == R.id.nav_basket){
           Intent intent = new Intent(Dashboard.this,CartActivity.class);
           startActivity(intent);

           return true;
       }
       if (menu_id == R.id.nav_map){
           Intent intent = new Intent(Dashboard.this,MapsActivity.class);
           startActivity(intent);
           return true;
       }
       if (menu_id == R.id.nav_logout){
           Intent intent = new Intent(Dashboard.this,UserPage.class);
           startActivity(intent);
           return true;
       }
        return true;
    }


    //recycler
    private void restaurantRecycler() {

       restaurantRecycler.setHasFixedSize(true);
       restaurantRecycler.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL,false));

       ArrayList<RestaurantHelperClass> restaurantLocations = new ArrayList<>();

       restaurantLocations.add(new RestaurantHelperClass(R.drawable.point,"The Point", "The point has a wide selection of food options."));
       restaurantLocations.add(new RestaurantHelperClass(R.drawable.ncafe_barista,"Cafe Barista", "Refreshments and hot drinks."));
       restaurantLocations.add(new RestaurantHelperClass(R.drawable.refectory,"The Refectory", "Food to lift up your day."));

       adapter = new RestaurantAdapter(restaurantLocations,Dashboard.this);
       restaurantRecycler.setAdapter(adapter);

    }
    
    private void foodRecycler(){
       
       foodRecycler.setHasFixedSize(true);
       foodRecycler.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL, false));

       ArrayList<FoodHelperClass> foodOptions = new ArrayList<>();
       foodOptions.add(new FoodHelperClass(R.drawable.pizza,"Pizza", "Cheesy yet delicate The Point provides an amazing Pizza which will fill you right up."));
       foodOptions.add(new FoodHelperClass(R.drawable.chickenburger,"Chicken Burger", "The point has a wide range of Burgers for you to choose from."));
       foodOptions.add(new FoodHelperClass(R.drawable.fries,"Curly Fries", "Small sides we got you!"));

       adapter = new FoodAdapter(foodOptions, Dashboard.this);
       foodRecycler.setAdapter(adapter);

    }









}