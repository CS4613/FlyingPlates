
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

public class AmericanFoods extends AppCompatActivity  {
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
        setContentView(R.layout.activity_american_foods);
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
        IndianFoods.cart_count = 0;
        foodsList = new ArrayList<>();
        foodsList.add(new ModelFood(R.drawable.crispychicenburger_a1, "Chicken Burger", "Fast Foods", 4.99, 1, 20));
        foodsList.add(new ModelFood(R.drawable.bbqchickenpizza_a2, "Chicken Pizza", "Fast Foods", 5.99, 2, 20));
        foodsList.add(new ModelFood(R.drawable.frenchfries_a3, "French Fries", "Fast Foods", 6.99, 3, 20));
        foodsList.add(new ModelFood(R.drawable.chickennuggets_a4, "Chicken Nuggets", "Fast Foods", 9.99, 4, 20));
        foodsList.add(new ModelFood(R.drawable.waldrofsalad_a5, "Waldrof salads", "Fast Foods", 5.99, 5, 20));
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setHasFixedSize(true);
        rvlayoutManager = new LinearLayoutManager(this);
        AmericanFoodAdapter foodAdapter = new AmericanFoodAdapter(this, foodsList);
        recyclerView.setAdapter(foodAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

    }
}
