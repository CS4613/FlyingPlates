
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
        import static com.example.foodorderapplication.IndianFoodAdapter.modelStoreFoods;
        //import static com.example.foodorderapplication.IndianCartActivity.temparraylist;

public class IndianFoods extends AppCompatActivity  {
    RecyclerView recyclerView;
    Button check_indian;
    TextView textView;
    private Toolbar mToolbar;
    RecyclerView.LayoutManager rvlayoutManager;
    public static ArrayList<ModelFood> foodsList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_indian_foods);
        recyclerView = findViewById(R.id.rv_indian);
        //check_indian = (Button) findViewById(R.id.checkout_indian);
        androidx.appcompat.widget.Toolbar toolbar = findViewById(R.id.total_main_bar);
        toolbar.setTitle("Home");
        setSupportActionBar(toolbar);
        ActionBar ab = getSupportActionBar();
        //mToolbar.setNavigationIcon(getResources().getDrawable(R.drawable.ic_arrow_back_black_24dp));
        if (ab != null) {
            ab.setDisplayHomeAsUpEnabled(true);
        } else {
            throw new NullPointerException("Something went wrong");
        }
        foodsList = new ArrayList<>();
        foodsList.add(new ModelFood(R.drawable.chickenbiryani_ind01, "Chicken Biryani", "Indian Foods", 12.99, 6, 20));
        foodsList.add(new ModelFood(R.drawable.redlentildal_ind02, "Red Lentil Dal", "Indian Foods", 9.99, 7, 20));
        foodsList.add(new ModelFood(R.drawable.pannertikkmasala_ind03, "Panner Tikka Masala", "Indian Foods", 11.99, 8, 20));
        foodsList.add(new ModelFood(R.drawable.gulabjamun_ind04, "Indian Sweet", "Indian Foods", 5.99, 9, 20));
        foodsList.add(new ModelFood(R.drawable.rasmalai_traditional_ind05, "Indian Sweet", "Indian Foods", 4.99, 10, 20));
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setHasFixedSize(true);
        rvlayoutManager = new LinearLayoutManager(this);
        IndianFoodAdapter foodAdapter = new IndianFoodAdapter(this, foodsList);
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
