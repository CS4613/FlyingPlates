package com.example.foodorderapplication;


import android.view.View;

public interface ItemClickListener {

    void onItemClickListener( int position);

    void onClick(View v, int adapterPosition, boolean b);
}
