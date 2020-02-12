
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
import static com.example.foodorderapplication.MexicanFoodAdapter.modelStoreFoods;


public class MexicanFoods extends AppCompatActivity  {
    RecyclerView recyclerView;
    Button check_mexican;
    TextView textView;
    private Toolbar mToolbar;
    RecyclerView.LayoutManager rvlayoutManager;
    public static double grandTotalplus;
    public static int cart_count = 0;
    public static ArrayList<ModelFood> foodsList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mexican_foods);
        recyclerView = findViewById(R.id.rv_mexican);
       // check_mexican = (Button) findViewById(R.id.checkout_mexican);
        mToolbar = findViewById(R.id.toolbar);
        mToolbar.setNavigationIcon(getResources().getDrawable(R.drawable.ic_back_arrow));
        mToolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // these lines of code for show the same  cart for future refrence
                grandTotalplus = 0;
              /*  for (int i = 0; i < temparraylist.size(); i++) {

                }
                modelStoreFoods.addAll(temparraylist);
                MexicanFoods.cart_count = (temparraylist.size());*/
                finish();
            }
        });
        MexicanFoods.cart_count = 0;
        //check_mexican.setOnClickListener(this);
        foodsList = new ArrayList<>();
        foodsList.add(new ModelFood(R.drawable.tacos_de_pollo_m01, "Tacos De Pollo", "Mexican Foods", 12.99, 11, 20));
        foodsList.add(new ModelFood(R.drawable.worth_whisking_caramel_cinnamon_apple_enchiladas_m02, "Caramel apple enchiladas", "Mexican Foods", 5.99, 12, 20));
        foodsList.add(new ModelFood(R.drawable.kurros_m03, "Kurros", "Mexican Foods", 6.99, 13, 20));

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setHasFixedSize(true);
        rvlayoutManager = new LinearLayoutManager(this);
        MexicanFoodAdapter foodAdapter = new MexicanFoodAdapter(this, foodsList);
        recyclerView.setAdapter(foodAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

    }

/*    @Override
    public void onClick(View view) {
        if(view==check_mexican)
            startActivity(new Intent(this,MexicanCartActivity.class));
    }*/
}
