package com.example.foodorderapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.content.Intent;
import android.view.View;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;


public class ProfileActivity extends AppCompatActivity implements View.OnClickListener{
    private Button buttonlogout;
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
        buttonlogout =(Button)findViewById(R.id.buttonSignOut);
        userdata =(TextView) findViewById(R.id.textProfile);
        username=(EditText) findViewById(R.id.TextName);
        address=(EditText) findViewById(R.id.textAddress);
        phonenumber=(EditText)findViewById(R.id.textPhoneNumber);
        saveInformation=(Button)findViewById(R.id.saveInformation);

        userdata.setText("Welcome "+user.getEmail());
        buttonlogout.setOnClickListener(this);
        saveInformation.setOnClickListener(this);
    }

    private void setSaveInformation()
    {
        String name=username.getText().toString().trim();
        String addressdata=address.getText().toString().trim();
        int number=Integer.parseInt(phonenumber.getText().toString().trim());

        ProfileInformation profileInformation=new ProfileInformation(name,addressdata,number);
        FirebaseUser eUser=firebaseAuth.getCurrentUser();
        databaseReference.push().setValue("value");
        databaseReference.child(eUser.getUid()).setValue(profileInformation);
        if(databaseReference!=null) {
            Toast.makeText(this, "Information Saved....", Toast.LENGTH_LONG).show();
        }
    }
    @Override
    public void onClick(View v) {
        if(v==buttonlogout)
        {
            firebaseAuth.signOut();
            finish();
            startActivity(new Intent(this,LoginActivity.class));
        }
        if(v==saveInformation)
        {
            setSaveInformation();
            finish();
            startActivity(new Intent(this,HomeActivity.class));
        }
    }
}
