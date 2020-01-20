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


public class ProfileToggle extends AppCompatActivity implements View.OnClickListener{
    private TextView userdata;
    private Button viewData;
    private Button buttonlogout;
    private Button saveInformation;
    private FirebaseAuth firebaseAuth;
    private DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_toggle);
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
        viewData=(Button)findViewById(R.id.buttonView);
        buttonlogout.setOnClickListener(this);
        saveInformation=(Button)findViewById(R.id.saveInformation);
        saveInformation.setOnClickListener(this);
        if(userdata!=null) {
            viewData.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(ProfileToggle.this, ViewDataBase.class);
                    startActivity(intent);
                }
            });
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
            finish();
            startActivity(new Intent(this,ProfileActivity.class));
        }
    }

}
