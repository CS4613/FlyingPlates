package com.example.foodorderapplication;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class ViewProfileInformation extends AppCompatActivity {
    private FirebaseAuth firebaseAuth;
    private  FirebaseDatabase firebaseDatabase;
    private DatabaseReference databaseReference;
    private FirebaseAuth mAuth;
    private FirebaseAuth.AuthStateListener mAuthListener;
    private String userId;
    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.view_database_layout);
        listView=(ListView)findViewById(R.id.listview);
        mAuth=FirebaseAuth.getInstance();
        firebaseDatabase= FirebaseDatabase.getInstance();
        databaseReference =firebaseDatabase.getReference();
        FirebaseUser user = mAuth.getCurrentUser();
        userId=user.getUid();

        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                showData(dataSnapshot);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });


    }

    private void showData(DataSnapshot dataSnapshot) {
        for(DataSnapshot ds :dataSnapshot.getChildren())
        {
        ProfileModel profileInformation = new ProfileModel();
        profileInformation.setName(ds.child(userId).getValue(ProfileModel.class).getName());
        profileInformation.setAddress(ds.child(userId).getValue(ProfileModel.class).getAddress());
        profileInformation.setPhonenumber(ds.child(userId).getValue(ProfileModel.class).getPhonenumber());

            ArrayList<String> arrayList=new ArrayList<>();
            arrayList.add(profileInformation.getName());
            arrayList.add(profileInformation.getAddress());
            arrayList.add(Integer.toString(profileInformation.getPhonenumber()));
            ArrayAdapter adapter=new ArrayAdapter(this,android.R.layout.simple_list_item_1,arrayList);
            if(listView!=null) {
                listView.setAdapter(adapter);
            }
            else
            {
                finish();
                startActivity(new Intent(this,ProfileActivity.class));
            }

        }
    }
}