package com.example.foodcollectionntu.helperClass.dashboardAdapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.foodcollectionntu.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.List;

public class cartAdapter extends RecyclerView.Adapter<cartAdapter.ViewHolder> {

    List<ItemData> itemDataList;
    FirebaseFirestore db;
    FirebaseAuth mAuth;
    ItemRemoved RemoveItem;
    public cartAdapter(List<ItemData> itemDataList, ItemRemoved RemoveItem){
        this.itemDataList = itemDataList;
        db = FirebaseFirestore.getInstance();
        mAuth = FirebaseAuth.getInstance();
        this.RemoveItem = RemoveItem;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cart_item_design,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, final int position) {
        holder.itemCartName.setText(itemDataList.get(position).getItem());
        holder.itemCartPrice.setText(itemDataList.get(position).getPrice());
        holder.itemCartRes.setText(itemDataList.get(position).getRestaurant());
        holder.removeItem.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {

                db.collection("User").document(mAuth.getCurrentUser().getUid())
                        .collection("Cart").document(itemDataList.get(position).getItemVal())
                        .delete().addOnCompleteListener(new OnCompleteListener<Void>(){
                                                            @Override
                                                            public void onComplete(@NonNull Task<Void> task) {
                                                                if (task.isSuccessful()){
                                                                    itemDataList.remove(itemDataList.get(position));
                                                                    notifyDataSetChanged();
                                                                    RemoveItem.onRemoveItem(itemDataList);
                                                                    Toast.makeText(holder.itemCartName.getContext(), "item removed",Toast.LENGTH_SHORT).show();

                                                                }else{
                                                                    Toast.makeText(holder.itemCartName.getContext(), task.getException().getMessage(),Toast.LENGTH_SHORT).show();


                                                                }

                                                            }
                                                        }
                );

            }
        });
    }

    @Override
    public int getItemCount() {
        return itemDataList.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView itemCartName, itemCartPrice, itemCartRes, removeItem;


        public ViewHolder(@NonNull View itemView){
            super(itemView);
            itemCartName = itemView.findViewById(R.id.cart_name);
            itemCartPrice = itemView.findViewById(R.id.cart_price);
            removeItem = itemView.findViewById(R.id.remove_item);
            itemCartRes = itemView.findViewById(R.id.cart_res);
        }

    }

    public interface ItemRemoved{
        public void onRemoveItem(List<ItemData> itemDataList);
    }




}
