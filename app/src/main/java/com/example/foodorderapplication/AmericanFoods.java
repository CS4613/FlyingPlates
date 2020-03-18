package com.example.foodorderapplication;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;


import java.util.ArrayList;


public class AmericanFoods extends AppCompatActivity  {
    RecyclerView recyclerView;
    TextView textView;
    RecyclerView.LayoutManager rvlayoutManager;
    public static ArrayList<ModelFood> foodsList = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_american_foods);
        recyclerView = findViewById(R.id.rv);
        Toolbar toolbar = (Toolbar) findViewById(R.id.total_main_bar);
        toolbar.setTitle("Home");
        setSupportActionBar(toolbar);
        ActionBar ab = getSupportActionBar();
        if (ab != null) {
            ab.setDisplayHomeAsUpEnabled(true);
        } else {
            throw new NullPointerException("Something went wrong");
        }
        foodsList = new ArrayList<>();
        foodsList.add(new ModelFood(R.drawable.crispychicenburger_a1, "Chicken Burger", "Fast Foods", 4.99, 1, 20));
        foodsList.add(new ModelFood(R.drawable.bbqchickenpizza_a2, "Chicken Pizza", "Fast Foods", 5.99, 2, 20));
        foodsList.add(new ModelFood(R.drawable.frenchfries_a3, "French Fries", "Fast Foods", 6.99, 3, 20));
        foodsList.add(new ModelFood(R.drawable.chickennuggets_a4, "Chicken Nuggets", "Fast Foods", 9.99, 4, 20));
        foodsList.add(new ModelFood(R.drawable.waldrofsalad_a5, "Waldrof salads", "Fast Foods", 5.99, 5, 20));
        recyclerView.setHasFixedSize(true);
        rvlayoutManager = new LinearLayoutManager(this);
        AmericanFoodAdapter foodAdapter = new AmericanFoodAdapter(this, foodsList);
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
