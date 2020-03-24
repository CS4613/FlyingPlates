package com.example.foodorderapplication;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class ViewProfileInformation extends AppCompatActivity {
    private FirebaseAuth firebaseAuth;
    private  FirebaseDatabase firebaseDatabase;
    private DatabaseReference databaseReference;
    private FirebaseAuth mAuth;
    private FirebaseAuth.AuthStateListener mAuthListener;
    private String userId;
    private ListView listView;
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.view_database_layout);
        listView=(ListView)findViewById(R.id.listview);
        mAuth=FirebaseAuth.getInstance();
        firebaseDatabase= FirebaseDatabase.getInstance();
        textView = (TextView)findViewById(R.id.norecords);
        textView.setVisibility(View.GONE);
        databaseReference =firebaseDatabase.getReference().child("profile").child("profile information");
        FirebaseUser user = mAuth.getCurrentUser();
        ArrayList<String> arrayList=new ArrayList<>();
        ArrayAdapter adapter=new ArrayAdapter(this,android.R.layout.simple_list_item_1,arrayList);
        if(listView!=null) {
            listView.setAdapter(adapter);
        }

       databaseReference.addChildEventListener(new ChildEventListener() {
           @Override
           public void onChildAdded(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
                   String name = dataSnapshot.getValue(String.class);
                   arrayList.add(name);
                   adapter.notifyDataSetChanged();


                  // textView.setVisibility(View.VISIBLE);

           }

           @Override
           public void onChildChanged(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

           }

           @Override
           public void onChildRemoved(@NonNull DataSnapshot dataSnapshot) {

           }

           @Override
           public void onChildMoved(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

           }

           @Override
           public void onCancelled(@NonNull DatabaseError databaseError) {

           }
       });

    }
}