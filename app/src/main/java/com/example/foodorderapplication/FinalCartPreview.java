package com.example.foodorderapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import android.preference.PreferenceManager;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.Toolbar;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.rowland.cartcounter.view.CartCounterActionView;

import java.util.ArrayList;
import java.util.List;

public class FinalCartPreview extends AppCompatActivity implements  FinalCartAdapter.HomeCallBack,FinalCartAdapter.CallBackUs{
    RecyclerView recyclerView;
    Button check;
    TextView textView;
    RecyclerView.LayoutManager rvlayoutManager;
    RecyclerView cartRecyclerView;
    LinearLayout proceedToBook;
    Context context;
    private Toolbar mToolbar;
    public static int cart_count = 0;
    public static TextView grandTotal;
    public static double grandTotalplus;
    public static ArrayList<ModelStoreFood> temparraylist =null;
    public static ArrayList<ModelStoreFood> finalarray = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart_preview);
        recyclerView = findViewById(R.id.recycler_view_cart);
        context = this;
        temparraylist = new ArrayList<>();
        mToolbar =  findViewById(R.id.toolbar);
        proceedToBook = findViewById(R.id.proceed_to_book);
        grandTotal = findViewById(R.id.grand_total_cart);
        mToolbar.setNavigationIcon(getResources().getDrawable(R.drawable.ic_back_arrow));
        mToolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // these lines of code for show the same  cart for future refrence
              /*  grandTotalplus = 0;
                for (int i = 0; i < temparraylist.size(); i++) {

                }
                modelStoreFoods.addAll(temparraylist);
                AmericanFoods.cart_count = (temparraylist.size());
//                addItemInCart.clear();*/
                finish();
            }
        });
        FinalCartPreview.cart_count = 0;

        temparraylist.addAll(finalarray);
        finalarray.clear();
        Log.d("sizecart_11", String.valueOf(temparraylist.size()));
        Log.d("sizecart_22", String.valueOf(finalarray.size()));
        for (int i = 0; i < finalarray.size(); i++) {
            for (int j = i + 1; j < finalarray.size(); j++) {
                if (finalarray.get(i).getProductId() == finalarray.get(j).getProductId()) {
                    finalarray.get(i).setQuantity(finalarray.get(j).getQuantity());
                    finalarray.get(i).setPrice(finalarray.get(j).getPrice());
                    finalarray.remove(j);
                    j--;

                }
            }
            cart_count = finalarray.size();
        }
        // this code is for get total cash
        for (int i = 0; i < temparraylist.size(); i++) {
            grandTotalplus = (grandTotalplus + temparraylist.get(i).getPrice()*temparraylist.get(i).getQuantity());
        }
        Log.d("total",String.valueOf(grandTotalplus));
        grandTotal.setText("$ " + String.valueOf(grandTotalplus));
        cartRecyclerView = findViewById(R.id.recycler_view_cart);
        proceedToBook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Toast.makeText(FinalCartPreview.this, "order placed", Toast.LENGTH_SHORT).show();
                if(grandTotalplus>0) {
                    startActivity(new Intent(getApplicationContext(), ShippingDetails.class));
                }
                else
                {
                    Toast.makeText(FinalCartPreview.this,"Please add items to cart",Toast.LENGTH_SHORT).show();
                    return;
                }
            }
        });

        FinalCartAdapter cartAdapter = new FinalCartAdapter(temparraylist, this);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(this);
        cartRecyclerView.setLayoutManager(mLayoutManager);
        cartRecyclerView.setAdapter(cartAdapter);



/*       for(ModelStoreFood modelStoreFood:finalarray) {
            Log.d("name",modelStoreFood.getName());
            Log.d("id",String.valueOf(modelStoreFood.getProductId()));
            cart_count++;
        }*/
 /*       LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setHasFixedSize(true);
        rvlayoutManager = new LinearLayoutManager(this);
        FinalCartAdapter foodAdapter = new FinalCartAdapter(finalarray, this);
        recyclerView.setAdapter(foodAdapter);
        foodAdapter.notifyDataSetChanged();
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
*/
    }


    /*@Override
    public boolean onPrepareOptionsMenu(Menu menu) {
        MenuItem itemData = menu.findItem(R.id.action_addcart);
        CartCounterActionView actionView = (CartCounterActionView) itemData.getActionView();
        actionView.setItemData(menu, itemData);
        actionView.setCount(cart_count);
        itemData.setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                startActivity(new Intent(getApplicationContext(),FinalCartPreview.class));
                return false;
            }
        });
        return super.onPrepareOptionsMenu(menu);
    }*/
  /*  @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        MenuItem menuItem = menu.findItem(R.id.action_addcart);
        menuItem.setIcon(Converter.convertLayoutToImage(FinalCartPreview.this, cart_count, R.drawable.ic_shopping_cart_white_24dp));
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        //noinspection SimplifiableIfStatement
        switch (item.getItemId()) {
            case R.id.action_addcart:
                if (cart_count < 1) {
                    Toast.makeText(this, "there is no item in cart", Toast.LENGTH_SHORT).show();
                } else {
                    startActivity(new Intent(this, FinalCartActivity.class));
                }
                break;
            default:
                return super.onOptionsItemSelected(item);
        }

        return true;
    }
*/
    @Override
    public void updateCartCount(Context context) {
        invalidateOptionsMenu();
    }

    @Override
    protected void onStart() {
        super.onStart();
        invalidateOptionsMenu();
    }

    @Override
    public void addCartItemView() {

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        grandTotalplus = 0;
        for (int i = 0; i < temparraylist.size(); i++) {
            FinalCartPreview.cart_count = (temparraylist.size());

        }
        finalarray.addAll(temparraylist);
        //cartModels.clear();
    }

}

