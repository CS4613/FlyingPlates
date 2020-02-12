
package com.example.foodorderapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toolbar;

import java.util.ArrayList;
import static com.example.foodorderapplication.ItalianFoodAdapter.modelStoreFoods;
//import static com.example.foodorderapplication.ItalianCartActivity.temparraylist;

public class ItalianFoods extends AppCompatActivity  {
    RecyclerView recyclerView;
    Button check_italian;
    TextView textView;
    private Toolbar mToolbar;
    RecyclerView.LayoutManager rvlayoutManager;
    public static double grandTotalplus;
    public static int cart_count = 0;
    public static ArrayList<ModelFood> foodsList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_italian_foods);
        recyclerView = findViewById(R.id.rv_italian);
        //check_italian = (Button) findViewById(R.id.checkout_italian);
        mToolbar = findViewById(R.id.toolbar);
        mToolbar.setNavigationIcon(getResources().getDrawable(R.drawable.ic_back_arrow));
        mToolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // these lines of code for show the same  cart for future refrence
                grandTotalplus = 0;
                /*for (int i = 0; i < temparraylist.size(); i++) {

                }
                modelStoreFoods.addAll(temparraylist);
                ItalianFoods.cart_count = (temparraylist.size());*/
                finish();
            }
        });
        //ItalianFoods.cart_count = 0;
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
}
