package com.example.foodorderapplication;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.cepheuen.elegantnumberbutton.view.ElegantNumberButton;

import java.util.ArrayList;
import java.util.HashSet;

import static com.example.foodorderapplication.FinalCartPreview.finalarray;

public class MexicanFoodAdapter extends RecyclerView.Adapter<MexicanFoodAdapter.ViewHolder> implements  View.OnClickListener{
    ItemClickListener itemClickListener;
    TextView textView,Des;
    public static ArrayList<ModelStoreFood> modelStoreFoods = new ArrayList<ModelStoreFood>();
    public static ArrayList<ModelFood> modelFoods;
    public ModelStoreFood foodItem;
    ModelFood modelFood;
    private Context mcontext;
    MexicanFoodAdapter(Context context, ArrayList<ModelFood> list){
        mcontext=context;
        modelFoods=list;
    }

    @Override
    public void onClick(View view) {

    }

    public  class  ViewHolder extends RecyclerView.ViewHolder{
        ImageView itemImage;
        TextView item_name,item_place,item_price;
        ElegantNumberButton elegantNumberButton;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            itemImage = itemView.findViewById(R.id.item_image_mexican1);
            item_name = itemView.findViewById(R.id.item_name_mexican1);
            item_place = itemView.findViewById(R.id.item_place_mexican);
            item_price = itemView.findViewById(R.id.item_price_mexican1);
            elegantNumberButton=(ElegantNumberButton)itemView.findViewById(R.id.number_button);
        }
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.activity_foods_3,parent,false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        modelFood = modelFoods.get(position);
        ImageView image = holder.itemImage;
        TextView name,place,price;
        name = holder.item_name;
        place = holder.item_place;
        price = holder.item_price;

        image.setImageResource(modelFood.getImage());
        name.setText(modelFood.getName());
        place.setText(modelFood.getPlace());
        price.setText(String.valueOf(modelFood.getPrice()));
        HashSet hs = new HashSet();
        holder.elegantNumberButton.setOnValueChangeListener(new ElegantNumberButton.OnValueChangeListener() {
            @Override
            public void onValueChange(ElegantNumberButton view, int oldValue, int newValue) {
                if(newValue==1) {
                    Toast.makeText(view.getContext(), newValue + " item added to cart", Toast.LENGTH_LONG).show();
                }
                if(newValue>1) {
                    Toast.makeText(view.getContext(), newValue + " items added to cart", Toast.LENGTH_LONG).show();
                }
                foodItem =new ModelStoreFood();
                foodItem.setImage(modelFoods.get(position).getImage());
                foodItem.setName(modelFoods.get(position).getName());
                foodItem.setPlace(modelFoods.get(position).getPlace());
                foodItem.setQuantity(newValue);
                foodItem.setPrice(modelFoods.get(position).getPrice());
                foodItem.setProductId(modelFoods.get(position).getProductId());
                foodItem.setTotalPrice(modelFoods.get(position).getPrice()*newValue);
                for (int i = 0; i < modelStoreFoods.size(); i++) {
                    for (int j = i + 1; j < modelStoreFoods.size(); j++) {
                        if (modelStoreFoods.get(i).getProductId()==modelStoreFoods.get(j).getProductId()) {
                            modelStoreFoods.get(i).setQuantity(modelStoreFoods.get(j).getQuantity());
                            modelStoreFoods.get(i).setPrice(modelStoreFoods.get(j).getPrice());
                            modelStoreFoods.remove(j);
                            j--;
                            Log.d("remove", String.valueOf(modelStoreFoods.size()));
                        }
                    }

                }
                modelStoreFoods.add(foodItem);
                Log.d("total",String.valueOf(modelFoods.get(position).getQuantity()));
                hs.addAll(modelStoreFoods);
                modelStoreFoods.clear();
                finalarray.addAll(hs);
            }

        });


    }

    @Override
    public int getItemCount() {
        return modelFoods.size();
    }
    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public int getItemViewType(int position) {
        return position;
    }

}
