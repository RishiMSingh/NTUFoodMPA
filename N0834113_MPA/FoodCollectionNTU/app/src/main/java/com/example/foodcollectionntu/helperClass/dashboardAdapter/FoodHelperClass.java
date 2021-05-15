package com.example.foodcollectionntu.helperClass.dashboardAdapter;

public class FoodHelperClass {

    int image;
    String title, description;

    public FoodHelperClass(int image, String title, String description) {
        this.image = image;
        this.title = title;
        this.description = description;

    }

    public int getImage() {
        return image;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }
}
