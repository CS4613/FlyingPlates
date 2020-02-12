
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

public class JapaneseFoods extends AppCompatActivity  {
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
        setContentView(R.layout.activity_japanese_foods);
        recyclerView = findViewById(R.id.rv);
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
        JapaneseFoods.cart_count = 0;
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
}
