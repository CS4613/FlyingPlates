package com.example.foodorderapplication;

public class ProfileInformation
{
    public String name;
    public String address;
    public int phonenumber;

    public ProfileInformation()
    {
    }

    public ProfileInformation(String name, String address, int phonenumber) {
        this.name = name;
        this.address = address;
        this.phonenumber = phonenumber;
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

    public int getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(int phonenumber) {
        this.phonenumber = phonenumber;
    }
}
