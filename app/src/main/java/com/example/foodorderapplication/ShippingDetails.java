package com.example.foodorderapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TableLayout;
import android.widget.TextView;
import android.widget.Toast;

import static com.example.foodorderapplication.FinalCartPreview.finalarray;
import static com.example.foodorderapplication.FinalCartPreview.grandTotal;
import static com.example.foodorderapplication.FinalCartPreview.grandTotalplus;

public class ShippingDetails extends AppCompatActivity {
    EditText editText;
    TextView amount,promotion,total_amount,couponstatus;
    Button placeorder;
    TableLayout tableLayout;
    double promocode;
    Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shipping_details);
        editText = findViewById(R.id.coupon);
        amount = findViewById(R.id.TotalAmount);
        promotion =  findViewById(R.id.TotalPromotionalAmount);
        couponstatus =  findViewById(R.id.coupon_status);
        couponstatus.setVisibility(View.GONE);
        promotion.setVisibility(View.GONE);
        placeorder = findViewById(R.id.proceed_to_checkout);
        total_amount = findViewById(R.id.TotalFinalAmount);
        button = findViewById(R.id.Enter);
        amount.setText(""+grandTotalplus);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String couponcode= editText.getText().toString().trim();

                if(TextUtils.isEmpty(couponcode))
                {
                    Toast.makeText(getApplicationContext(),"Please enter a coupon code",Toast.LENGTH_SHORT).show();
                    couponstatus.setVisibility(View.GONE);
                    promotion.setVisibility(View.GONE);
                    return;
                }

                if(couponcode.equalsIgnoreCase("FIRSTTIME")&&grandTotalplus>5)
                {
                    Toast.makeText(getApplicationContext(),"Promotional Code Successfully",Toast.LENGTH_SHORT).show();
                    editText.setText(null);
                    promocode=grandTotalplus-5;
                    promotion.setText("$"+5);
                    couponstatus.setVisibility(View.VISIBLE);
                    promotion.setVisibility(View.VISIBLE);
                    total_amount.setText(""+promocode);
                }
                else if(!couponcode.equalsIgnoreCase("FIRSTTIME"))
                {
                    Toast.makeText(getApplicationContext(),"Invalid Promotional Code",Toast.LENGTH_SHORT).show();
                    editText.setText(null);
                    promotion.setText("");
                    couponstatus.setVisibility(View.GONE);
                    promotion.setVisibility(View.GONE);
                    total_amount.setText(""+grandTotalplus);
                }
                else if(grandTotalplus<=5)
                {
                    Toast.makeText(getApplicationContext(),"Amount must be greater than $5",Toast.LENGTH_SHORT).show();
                    editText.setText(null);
                    promotion.setText("");
                    couponstatus.setVisibility(View.GONE);
                    promotion.setVisibility(View.GONE);
                    total_amount.setText(""+grandTotalplus);
                }
                else
                {
                    Toast.makeText(getApplicationContext(),"Invalid Promotional Code",Toast.LENGTH_SHORT).show();
                    editText.setText(null);
                    promotion.setText("");
                    total_amount.setText(""+grandTotalplus);
                    couponstatus.setVisibility(View.GONE);
                    promotion.setVisibility(View.GONE);
                }
            }
        });
        placeorder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(),BookMyOrder.class));
            }
        });

    }
}
