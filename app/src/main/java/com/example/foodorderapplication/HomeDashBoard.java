package com.example.foodorderapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.GridLayout;
import android.widget.Toast;

public class HomeDashBoard extends AppCompatActivity {

    GridLayout gridLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_dash_board);
        gridLayout =(GridLayout) findViewById(R.id.mainGrid);
        setSingleEvent(gridLayout);
    }
    private void setSingleEvent(GridLayout gridLayout)
    {
        for(int i=0;i<gridLayout.getChildCount();i++)
        {
            CardView cardView = (CardView)gridLayout.getChildAt(i);
            final int finalValue=i;
            cardView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                   // Toast.makeText(HomeDashBoard.this,"clicked at index "+finalValue,Toast.LENGTH_SHORT).show();
                    if(finalValue==0)
                    {
                        Intent intent = new Intent(HomeDashBoard.this,AmericanFoods.class);
                        startActivity(intent);
                    }
                    else if(finalValue==1)
                    {
                        Intent intent = new Intent(HomeDashBoard.this,IndianFoods.class);
                        startActivity(intent);
                    }
                    else
                    {
                        Toast.makeText(HomeDashBoard.this,"Please select an item",Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }
    }
}
