package com.example.foodorderapplication;

import java.util.List;

public class BookMyOrderModel
{
    public static String name;
    public static String address;
    public static String phonenumber;
    public static String pincode;
    public static double totalamount;
    public static String cardnumber;
    public static String cardExpiration;
    public static String cardCVV;
    public static String cardpostalcode;

    public BookMyOrderModel()
    {
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

    public double getTotalamount() {
        return totalamount;
    }

    public void setTotalamount(double totalamount) {
        this.totalamount = totalamount;
    }
    public String getCardnumber() {
        return cardnumber;
    }

    public void setCardnumber(String cardnumber) {
        this.cardnumber = cardnumber;
    }

    public String getCardExpiration() {
        return cardExpiration;
    }

    public void setCardExpiration(String cardExpiration) {
        this.cardExpiration = cardExpiration;
    }

    public String getcardCVV() {
        return cardCVV;
    }

    public void setcardCVV(String cardCVV) {
        this.cardCVV = cardCVV;
    }

    public String getCardpostalcode() {
        return cardpostalcode;
    }

    public void setCardpostalcode(String cardpostalcode) {
        this.cardpostalcode = cardpostalcode;
    }



}
