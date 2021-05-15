package com.example.foodcollectionntu.helperClass.dashboardAdapter;

import java.io.Serializable;

public class MenuData implements Serializable {

    private String foodItemName;
    private String restaurantName;
    private String price;
    private Integer foodImage;
    private String userID;



    public MenuData(String foodItemName, String restaurantName, String price, Integer foodImage, String userID) {
        this.foodItemName = foodItemName;
        this.restaurantName = restaurantName;
        this.price = price;
        this.foodImage = foodImage;
        this.userID = userID;
    }


    public Integer getFoodImage() {
        return foodImage;
    }

    public void setFoodImage(Integer foodImage) {
        this.foodImage = foodImage;
    }


    public String getFoodItemName() {
        return foodItemName;
    }

    public void setFoodItemName(String foodItemName) {
        this.foodItemName = foodItemName;
    }

    public String getRestaurantName() {
        return restaurantName;
    }

    public void setRestaurantName(String restaurantName) {
        this.restaurantName = restaurantName;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }
}
