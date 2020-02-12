
package com.example.foodorderapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toolbar;
import java.util.ArrayList;
import static com.example.foodorderapplication.AmericanFoodAdapter.modelStoreFoods;
//import static com.example.foodorderapplication.IndianCartActivity.temparraylist;

public class ChineseFoods extends AppCompatActivity  {
    RecyclerView recyclerView;
    Button check_indian;
    TextView textView;
    private Toolbar mToolbar;
    RecyclerView.LayoutManager rvlayoutManager;
    public static double grandTotalplus;
    public static int cart_count = 0;
    public static ArrayList<ModelFood> foodsList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chinese_foods);
        recyclerView = findViewById(R.id.rv);
        //check_indian = (Button) findViewById(R.id.checkout_indian);
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
                IndianFoods.cart_count = (temparraylist.size());*/
                finish();
            }
        });
        ChineseFoods.cart_count = 0;
        foodsList = new ArrayList<>();
        foodsList.add(new ModelFood(R.drawable.chickenmanchuria_c01, "Chicken Manchuria", "Fast Foods", 8.99, 17, 20));
        foodsList.add(new ModelFood(R.drawable.chickennoodles_c02, "Chicken Noodles", "Fast Foods", 7.99, 18, 20));
        foodsList.add(new ModelFood(R.drawable.sesameseedballschina_c03, "Sesamese Seed Balls", "Fast Foods", 6.99, 19, 20));
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setHasFixedSize(true);
        rvlayoutManager = new LinearLayoutManager(this);
        ChineseFoodAdapter foodAdapter = new ChineseFoodAdapter(this, foodsList);
        recyclerView.setAdapter(foodAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

    }
}
