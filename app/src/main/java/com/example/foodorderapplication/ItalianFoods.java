
package com.example.foodorderapplication;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;

import java.util.ArrayList;



public class ItalianFoods extends AppCompatActivity  {
    RecyclerView recyclerView;
    TextView textView;
    RecyclerView.LayoutManager rvlayoutManager;
    public static ArrayList<ModelFood> foodsList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_italian_foods);
        recyclerView = findViewById(R.id.rv_italian);
        androidx.appcompat.widget.Toolbar toolbar =  findViewById(R.id.total_main_bar);
        toolbar.setTitle("Home");
        setSupportActionBar(toolbar);
        ActionBar ab = getSupportActionBar();
        if (ab != null) {
            ab.setDisplayHomeAsUpEnabled(true);
        } else {
            throw new NullPointerException("Something went wrong");
        }

        foodsList = new ArrayList<>();
        foodsList.add(new ModelFood(R.drawable.basil_blur_close_up_i01, "Basil Blur Close Up", "Italian Foods", 12.99, 14, 20));
        foodsList.add(new ModelFood(R.drawable.italianchickenpasta_i02, "Italian Chicken Pasta", "Italian Foods", 7.99, 15, 20));
        foodsList.add(new ModelFood(R.drawable.honey_semifreddo_frozen_italian_dessert_i03, "Honet frozen Italian Dessert", "Italian Foods", 5.99, 16, 20));

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setHasFixedSize(true);
        rvlayoutManager = new LinearLayoutManager(this);
        ItalianFoodAdapter foodAdapter = new ItalianFoodAdapter(this, foodsList);
        recyclerView.setAdapter(foodAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Intent myIntent = new Intent(getApplicationContext(), HomeDashBoard.class);
        startActivityForResult(myIntent, 0);
        return true;

    }
}
