package com.example.foodorderapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.content.Intent;
import android.view.View;


public class SaveProfileInformation extends AppCompatActivity implements View.OnClickListener{
    private TextView userdata;
    private Button viewData;
    private Button buttonlogout;
    private Button saveInformation;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_toggle);
        userdata =(TextView) findViewById(R.id.textProfile);
        viewData=(Button)findViewById(R.id.buttonView);
        saveInformation=(Button)findViewById(R.id.saveInformation);
        saveInformation.setOnClickListener(this);
            viewData.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(SaveProfileInformation.this, ViewProfileInformation.class);
                    startActivity(intent);
                }
            });
            }


    @Override
    public void onClick(View v) {
        if(v==saveInformation)
        {
            finish();
            startActivity(new Intent(this,ProfileActivity.class));
        }
    }

}
