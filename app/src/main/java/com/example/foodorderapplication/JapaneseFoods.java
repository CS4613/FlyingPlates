
package com.example.foodorderapplication;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import java.util.ArrayList;
import static com.example.foodorderapplication.AmericanFoodAdapter.modelStoreFoods;
//import static com.example.foodorderapplication.IndianCartActivity.temparraylist;

public class JapaneseFoods extends AppCompatActivity  {
    RecyclerView recyclerView;
    TextView textView;
    RecyclerView.LayoutManager rvlayoutManager;
    public static ArrayList<ModelFood> foodsList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_japanese_foods);
        recyclerView = findViewById(R.id.rv);
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
        foodsList.add(new ModelFood(R.drawable.chicken_katsu_curry_j01, "Chicken Katsu Curry", "Curry", 11.99, 20, 20));
        foodsList.add(new ModelFood(R.drawable.karaagejapanesefriedchicken_j02, "Karaage Japanese Fried Chicken", "Fast Foods", 6.99, 21, 20));
        foodsList.add(new ModelFood(R.drawable.honey_toast_j03, "HoneyToast", "Sweet", 6.99, 22, 20));
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setHasFixedSize(true);
        rvlayoutManager = new LinearLayoutManager(this);
        JapaneseFoodAdapter foodAdapter = new JapaneseFoodAdapter(this, foodsList);
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
