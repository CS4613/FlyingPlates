package com.example.foodorderapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.TextView;

import java.util.ArrayList;

public class AmericanFoods extends AppCompatActivity {
    RecyclerView recyclerView;
    RecyclerView.LayoutManager rvlayoutManager;
    ArrayList<ModelFood> foodsList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_american_foods);
            recyclerView = findViewById(R.id.rv);
            foodsList = new ArrayList<>();
            foodsList.add(new ModelFood(R.drawable.crispychicenburger_a1,"Chicken Burger","Fast Foods","4"));
            foodsList.add(new ModelFood(R.drawable.bbqchickenpizza_a2,"bbq chickenpizza_a2","Fast Foods","5"));
            foodsList.add(new ModelFood(R.drawable.frenchfries_a3,"French Fries","Fast Foods","8"));
            foodsList.add(new ModelFood(R.drawable.chickennuggets_a4,"Chicken Nuggets","Fast Foods","9"));
            foodsList.add(new ModelFood(R.drawable.waldrofsalad_a5,"Waldrof salads","Fast Foods","4"));

            LinearLayoutManager layoutManager = new LinearLayoutManager(this);

            recyclerView.setHasFixedSize(true);
            rvlayoutManager = new LinearLayoutManager(this);
            FoodAdapter foodAdapter = new FoodAdapter(this,foodsList);
            recyclerView.setAdapter(foodAdapter);
            recyclerView.setLayoutManager(new LinearLayoutManager(this));



    }
}
