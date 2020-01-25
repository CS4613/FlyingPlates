
package com.example.foodorderapplication;

        import androidx.appcompat.app.AppCompatActivity;
        import androidx.recyclerview.widget.LinearLayoutManager;
        import androidx.recyclerview.widget.RecyclerView;

        import android.os.Bundle;
        import android.widget.TextView;

        import java.util.ArrayList;

public class IndianFoods extends AppCompatActivity {
    RecyclerView recyclerView;
    RecyclerView.LayoutManager rvlayoutManager;
    ArrayList<ModelFood> foodsList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_indian_foods);
        recyclerView = findViewById(R.id.rv);
        foodsList = new ArrayList<>();
        foodsList.add(new ModelFood(R.drawable.chickenbiryani_ind01,"Chicken Biryani","Indian Foods","12.99"));
        foodsList.add(new ModelFood(R.drawable.redlentildal_ind02,"Red Lentil Dal","Indian Foods","9.99"));
        foodsList.add(new ModelFood(R.drawable.pannertikkmasala_ind03,"Panner Tikka Masala","Indian Foods","11.99"));
        foodsList.add(new ModelFood(R.drawable.gulabjamun_ind04,"Indian Sweet","Indian Foods","5.99"));
        foodsList.add(new ModelFood(R.drawable.rasmalai_traditional_ind05,"Indian Sweet","Indian Foods","4"));

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);

        recyclerView.setHasFixedSize(true);
        rvlayoutManager = new LinearLayoutManager(this);
        FoodAdapter foodAdapter = new FoodAdapter(this,foodsList);
        recyclerView.setAdapter(foodAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));



    }
}
