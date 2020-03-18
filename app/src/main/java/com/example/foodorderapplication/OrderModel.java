package com.example.foodorderapplication;

public class OrderModel
{
    public static String name;
    public static String address;
    public static String phonenumber;
    public static String pincode;

    public OrderModel()
    {
    }

    public OrderModel(String name, String address, String phonenumber,String pincode) {
        this.name = name;
        this.address = address;
        this.phonenumber = phonenumber;
        this.pincode = pincode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }
    public String getPincode() {
        return pincode;
    }

    public void setPincode(String pincode) {
        this.pincode = pincode;
    }
}
