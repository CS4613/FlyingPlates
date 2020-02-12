package com.example.foodorderapplication;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.braintreepayments.cardform.view.CardForm;
import com.braintreepayments.cardform.view.CvvEditText;

public class BookMyOrder extends AppCompatActivity {
    Button placeorder;
    CardForm cardForm;
    AlertDialog.Builder alertBuilder;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_my_order);
        placeorder = findViewById(R.id.buynow);
        cardForm = findViewById(R.id.card_form);
        cardForm.cardRequired(true)
                .expirationRequired(true)
                .cvvRequired(true)
                .postalCodeRequired(true)
                .setup(BookMyOrder.this);
        cardForm.getCvvEditText().setInputType(InputType.TYPE_CLASS_NUMBER |InputType.TYPE_NUMBER_VARIATION_PASSWORD);
        placeorder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(cardForm.isValid())
                {
                alertBuilder = new AlertDialog.Builder(BookMyOrder.this);
                alertBuilder.setTitle("Confirm before purchase");
                alertBuilder.setMessage("Card Number:"+cardForm.getCardNumber()+ " \n "+"Card Expiry date : "+cardForm.getExpirationDateEditText().getText().toString()+
                                        "CVV "+cardForm.getCvv());
                alertBuilder.setPositiveButton("Confirm", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                        Toast.makeText(BookMyOrder.this , "Thank you for purchase",Toast.LENGTH_LONG).show();
                    }
                });
                    alertBuilder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            dialogInterface.dismiss();
                          //  Toast.makeText(BookMyOrder.this , "Thank you for purchase",Toast.LENGTH_LONG).show();
                        }
                    });
                    AlertDialog alertDialog = alertBuilder.create();
                    alertDialog.show();
                }
                else
                {
                    Toast.makeText(BookMyOrder.this , "Please Complete the form",Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}
