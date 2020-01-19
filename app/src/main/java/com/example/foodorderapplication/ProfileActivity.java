package com.example.foodorderapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.content.Intent;
import android.view.View;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;


public class ProfileActivity extends AppCompatActivity implements View.OnClickListener{
    private Button buttonlogout;
    private TextView userdata;
    private FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        firebaseAuth=FirebaseAuth.getInstance();
        if(firebaseAuth.getCurrentUser()==null)
        {
            finish();
            startActivity(new Intent(this,LoginActivity.class));
        }
        FirebaseUser user=firebaseAuth.getCurrentUser();
        buttonlogout =(Button)findViewById(R.id.buttonSignOut);
        userdata =(TextView) findViewById(R.id.textProfile);
        userdata.setText("Welcome "+user.getEmail());
        buttonlogout.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v==buttonlogout)
        {
            firebaseAuth.signOut();
            finish();
            startActivity(new Intent(this,LoginActivity.class));
        }

    }
}
