package com.example.foodorderapplication;

public class ModelFood {
    private int image,productId,quantity;
    private String name,place;
    private  double price;
    public ModelFood(int image, String name, String place, double price,int productId,int quantity) {
        this.image = image;
        this.name = name;
        this.place = place;
        this.price = price;
        this.productId=productId;
        this.quantity=quantity;
    }

    public ModelFood() {

    }


    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
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

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }


    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }


}
