package com.example.foodorderapplication;

public class ModelStoreFood {
    private int image,productId,quantity;
    private String name,place;
    private  double totalprice;
    private double price;
    public ModelStoreFood(int image, String name, String place, double totalprice,int productId,double price,int quantity) {
        this.image = image;
        this.name = name;
        this.place = place;
        this.totalprice = totalprice;
        this.productId=productId;
        this.price=price;
        this.quantity=quantity;
    }

    public ModelStoreFood() {

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

    public double getTotalPrice() {
        return totalprice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalprice = totalprice;
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
