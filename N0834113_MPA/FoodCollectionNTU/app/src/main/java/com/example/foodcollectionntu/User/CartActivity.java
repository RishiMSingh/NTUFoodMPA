package com.example.foodcollectionntu.User;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.foodcollectionntu.R;
import com.example.foodcollectionntu.helperClass.dashboardAdapter.ItemData;
import com.example.foodcollectionntu.helperClass.dashboardAdapter.cartAdapter;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentChange;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CartActivity extends AppCompatActivity implements cartAdapter.ItemRemoved {

    FirebaseFirestore db;
    FirebaseAuth mAuth;
    List<ItemData> itemList;
    RecyclerView cartRecycler;
    cartAdapter CartAdapter;
    TextView total;
    Button orderCollection;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);

        db = FirebaseFirestore.getInstance();
        mAuth = FirebaseAuth.getInstance();
        itemList= new ArrayList<>();
        cartRecycler = findViewById(R.id.itemContainer);
        total = findViewById(R.id.total);
        cartRecycler.setLayoutManager(new LinearLayoutManager(this));
        cartRecycler.setHasFixedSize(true);
        orderCollection = findViewById(R.id.collect_but);

        orderCollection.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {

                if(itemList != null && itemList.size() > 0){
                    for(ItemData item : itemList){
                        Map<String, Object> mMap = new HashMap<>();
                        mMap.put("Item", item.getItem());
                        mMap.put("Price", item.getPrice());
                        mMap.put("Restaurant", item.getRestaurant());

                        db = FirebaseFirestore.getInstance();
                        // Create a new user with a first and last name
                        db.collection("User").document(mAuth.getCurrentUser().getUid())
                                .collection("Collection").add(mMap).addOnCompleteListener(new OnCompleteListener<DocumentReference>(){

                            @Override
                            public void onComplete(@NonNull Task<DocumentReference> task) {
                                if(task.isSuccessful()){
                                    Toast.makeText(CartActivity.this, "Your order has been sent to the kitchen. Please arrive in 30 mins to collect.", Toast.LENGTH_LONG).show();
                                }

                            }
                        });
                    }

                }
                db.collection("User").document(mAuth.getCurrentUser().getUid())
                        .collection("Cart").document().delete();



            }
        });


        CartAdapter = new cartAdapter(itemList, this);
        cartRecycler.setAdapter(CartAdapter);
        db.collection("User").document(mAuth.getCurrentUser().getUid())
                .collection("Cart").get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {

            @Override
            public void onComplete(@NonNull Task<QuerySnapshot> task) {
                String itemVal;
                if(task.isSuccessful()){
                    if(task.getResult()!=null) {
                        for (DocumentChange doc : task.getResult().getDocumentChanges()) {
                            itemVal = doc.getDocument().getId();
                            ItemData item = doc.getDocument().toObject(ItemData.class);
                            item.setItemVal(itemVal);
                            itemList.add(item);
                            
                        }
                        calculateAmount(itemList);
                        CartAdapter.notifyDataSetChanged();

                        Log.d("TAG", String.valueOf(itemList));
                    }
                    else{
                        Toast.makeText(CartActivity.this, task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                    }

                }

            }
        });


    }

    public void menu(View view){
        Intent intent = new Intent(this, Dashboard.class);
        startActivity(intent);
    }

    public void calculateAmount(List<ItemData> itemList) {
        double totalAmount = 0.0;
            for (ItemData item:itemList){
                String priceVal = item.getPrice();
                double value = Double.parseDouble(priceVal);
                totalAmount += value;

            }
            total.setText("Total: £" +  totalAmount);
        }

    @Override
    public void onRemoveItem(List<ItemData> itemList) {
        calculateAmount(itemList);

    }

    }

