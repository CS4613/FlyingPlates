package com.example.foodorderapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.GridLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.rowland.cartcounter.view.CartCounterActionView;

import static com.example.foodorderapplication.FinalCartPreview.cart_count;
import static com.example.foodorderapplication.FinalCartPreview.finalarray;


public class HomeDashBoard extends AppCompatActivity implements FinalCartAdapter.HomeCallBack,FinalCartAdapter.CallBackUs {

    GridLayout gridLayout;

    private FirebaseAuth firebaseAuth;
    private DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_dash_board);
        firebaseAuth=FirebaseAuth.getInstance();
        databaseReference= FirebaseDatabase.getInstance().getReference().child("data");
        if(firebaseAuth.getCurrentUser()==null)
        {
            finish();
            startActivity(new Intent(this,LoginActivity.class));
        }
        FirebaseUser user=firebaseAuth.getCurrentUser();

        gridLayout = (GridLayout) findViewById(R.id.mainGrid);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        TextView textName = navigationView.getHeaderView(0).findViewById(R.id.name);
        TextView textemail = navigationView.getHeaderView(0).findViewById(R.id.textView);
        /// textemail.setText(db.getString("email"));
        //textName.setText(db.getString("name"));
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new HomeFragment()).commit();
            navigationView.setCheckedItem(R.id.nav_home);
        }
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                int id = menuItem.getItemId();
                if (id == R.id.nav_home) {

                    getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new HomeFragment()).commit();

                } else if (id == R.id.nav_orders) {

                    Intent intent = new Intent(HomeDashBoard.this, MyOrders.class);
                    startActivity(intent);

                } else if (id == R.id.nav_profile) {
                    Intent intent = new Intent(HomeDashBoard.this, SaveProfileInformation.class);
                    startActivity(intent);

                } else if (id == R.id.nav_signout) {
                    firebaseAuth.signOut();
                    startActivity(new Intent(HomeDashBoard.this,LoginActivity.class));

                }
                DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
                drawer.closeDrawer(GravityCompat.START);
                return true;
            }
        });
    }


    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        MenuItem menuItem = menu.findItem(R.id.action_addcart);
        return true;

    }

    @Override
    protected void onStart() {
        super.onStart();
        invalidateOptionsMenu();
    }


    /*    @Override
        public boolean onOptionsItemSelected(MenuItem item) {
            // Handle action bar item clicks here. The action bar will
            // automatically handle clicks on the Home/Up button, so long
            // as you specify a parent activity in AndroidManifest.xml.
            int id = item.getItemId();

            //noinspection SimplifiableIfStatement
            if (id == R.id.action_addcart) {
                if (cart_count < 1) {
                    Toast.makeText(this, "there is no item in cart", Toast.LENGTH_SHORT).show();
                } else {
                    startActivity(new Intent(this, FinalCartPreview.class));
                }
            }

            return super.onOptionsItemSelected(item);
        }*/
    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
        MenuItem itemData = menu.findItem(R.id.action_addcart);
        CartCounterActionView actionView = (CartCounterActionView) itemData.getActionView();
        actionView.setItemData(menu, itemData);
        for (int i = 0; i < finalarray.size(); i++) {
            for (int j = i + 1; j < finalarray.size(); j++) {
                if (finalarray.get(i).getProductId()==finalarray.get(j).getProductId()) {
                    finalarray.get(i).setQuantity(finalarray.get(j).getQuantity());
                    finalarray.get(i).setPrice(finalarray.get(j).getPrice());
                    finalarray.remove(j);
                    j--;

                }
            }
            cart_count=finalarray.size();
        }
        actionView.setCount(FinalCartPreview.cart_count);
       // Toast.makeText(getApplicationContext(),"Cart Count"+FinalCartPreview.cart_count,Toast.LENGTH_LONG).show();
        itemData.setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.action_addcart:
                        if (cart_count < 1) {
                            Toast.makeText(getApplicationContext(), "there is no item in cart", Toast.LENGTH_SHORT).show();
                        } else {
                            startActivity(new Intent(getApplicationContext(), FinalCartPreview.class));
                        }
                        break;
                }

                return true;
            }
        });
        return super.onPrepareOptionsMenu(menu);
    }


    @Override
    public void addCartItemView() {

    }

    @Override
    public void updateCartCount(Context context) {
        invalidateOptionsMenu();
    }
}
