package com.example.foodorderapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class IndianFoodAdapter extends RecyclerView.Adapter<IndianFoodAdapter.ViewHolder> {

    private Context mcontext;
    private ArrayList<ModelFood> mlist;
    IndianFoodAdapter(Context context, ArrayList<ModelFood> list){
        mcontext=context;
        mlist=list;
    }

    public  class  ViewHolder extends RecyclerView.ViewHolder{
        ImageView itemImage;
        TextView item_name,item_place,item_price;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            itemImage = itemView.findViewById(R.id.item_image_indian1);
            item_name = itemView.findViewById(R.id.item_name_indian1);
            item_place = itemView.findViewById(R.id.item_place_indian1);
            item_price = itemView.findViewById(R.id.item_price_indian1);
        }
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.activity_foods_2,parent,false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        ModelFood foodItem = mlist.get(position);
        ImageView image = holder.itemImage;
        TextView name,place,price;
        name = holder.item_name;
        place = holder.item_place;
        price = holder.item_price;

        image.setImageResource(foodItem.getImage());
        name.setText(foodItem.getName());
        place.setText(foodItem.getPlace());
        price.setText(foodItem.getPrice());
    }




    @Override
    public int getItemCount() {
        return mlist.size();
    }
}
