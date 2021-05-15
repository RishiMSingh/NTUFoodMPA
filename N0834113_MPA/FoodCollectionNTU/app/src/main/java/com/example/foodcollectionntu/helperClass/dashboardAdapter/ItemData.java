package com.example.foodcollectionntu.helperClass.dashboardAdapter;

import java.io.Serializable;

public class ItemData implements Serializable {

    String Item;
    String Restaurant;
    String Price;
    String itemVal;

    public ItemData() {

    }

    public String getItem() {
        return Item;
    }

    public void setItem(String item) {
        Item = item;
    }

    public String getRestaurant() {
        return Restaurant;
    }

    public void setRestaurant(String restaurant) {
        Restaurant = restaurant;
    }

    public String getPrice() {
        return Price;
    }

    public void setPrice(String price) {
        Price = price;
    }

    public String getItemVal() {
        return itemVal;
    }

    public void setItemVal(String itemVal) {
        this.itemVal = itemVal;
    }
}
