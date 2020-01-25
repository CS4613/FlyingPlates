package com.example.foodorderapplication;

public class ModelFood {
    private int image;
    private String name,place,price;
    public ModelFood(int image, String name, String place, String price) {
        this.image = image;
        this.name = name;
        this.place = place;
        this.price = price;
    }



    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }


}
