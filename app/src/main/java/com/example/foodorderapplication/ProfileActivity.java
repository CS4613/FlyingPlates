package com.example.foodorderapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.content.Intent;
import android.view.View;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


public class ProfileActivity extends AppCompatActivity implements View.OnClickListener{

    private TextView userdata;
    private EditText username;
    private EditText address;
    private EditText phonenumber;
    private Button saveInformation;
    private FirebaseAuth firebaseAuth;
    private DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        firebaseAuth=FirebaseAuth.getInstance();
        databaseReference= FirebaseDatabase.getInstance().getReference().child("data");
        if(firebaseAuth.getCurrentUser()==null)
        {
            finish();
            startActivity(new Intent(this,LoginActivity.class));
        }
        FirebaseUser user=firebaseAuth.getCurrentUser();
        userdata =(TextView) findViewById(R.id.textProfile);
        username=(EditText) findViewById(R.id.TextName);
        address=(EditText) findViewById(R.id.textAddress);
        phonenumber=(EditText)findViewById(R.id.textPhoneNumber);
        saveInformation=(Button)findViewById(R.id.saveInformation);
        saveInformation.setOnClickListener(this);
    }

    private void setSaveInformation()
    {
        String name=username.getText().toString().trim();
        String addressdata=address.getText().toString().trim();
        String value = phonenumber.getText().toString().trim();
        int number=Integer.parseInt(phonenumber.getText().toString().trim());
        if(TextUtils.isEmpty(name))
        {
            Toast.makeText(this,"Please enter your name",Toast.LENGTH_SHORT).show();
            return;
        }
        if(TextUtils.isEmpty(addressdata))
        {
            Toast.makeText(this,"Please enter your address",Toast.LENGTH_SHORT).show();
            return;
        }

        if(TextUtils.isEmpty(Integer.toString(number)))
        {
            Toast.makeText(this,"Please enter your mobile number",Toast.LENGTH_SHORT).show();
            return;
        }
        ProfileModel profileInformation=new ProfileModel(name,addressdata,number);
        FirebaseUser eUser=firebaseAuth.getCurrentUser();
        databaseReference.child(eUser.getUid()).setValue(profileInformation);
        if(databaseReference!=null&&!name.isEmpty()&&!addressdata.isEmpty()) {
            Toast.makeText(this, "Information Saved....", Toast.LENGTH_LONG).show();
        }
    }
    @Override
    public void onClick(View v) {
        if(v==saveInformation)
        {
            setSaveInformation();
            finish();
            startActivity(new Intent(this,HomeDashBoard.class));
        }

    }

}
