package com.example.foodorderapplication;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;

import static com.example.foodorderapplication.FinalCartPreview.grandTotal;
import static com.example.foodorderapplication.FinalCartPreview.grandTotalplus;




public class FinalCartAdapter extends RecyclerView.Adapter<FinalCartAdapter.ViewHolder> {

    public static  ArrayList<ModelStoreFood> modelStoreFoods;
    Context context;

    public FinalCartAdapter(ArrayList<ModelStoreFood> modelStoreFoods, Context context) {
        this.context = (Context) context;
        this.modelStoreFoods = modelStoreFoods;
    }


    @Override
    public FinalCartAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.cart_view, parent, false);
        return new FinalCartAdapter.ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(final FinalCartAdapter.ViewHolder holder, final int position) {
        holder.productCartPrice.setText(String.valueOf("$"+modelStoreFoods.get(position).getPrice()));
        holder.productCartCode.setText(modelStoreFoods.get(position).getName());
        holder.productCartQuantity.setText(String.valueOf(modelStoreFoods.get(position).getQuantity()));
        RequestOptions requestOptions = new RequestOptions();
        requestOptions.placeholder(R.drawable.crispychicenburger_a1);
        requestOptions.error(R.drawable.crispychicenburger_a1);
        Log.d("imageurl", String.valueOf(modelStoreFoods.get(position).getImage()));
        Glide.with(context)
                .setDefaultRequestOptions(requestOptions)
                .load(modelStoreFoods.get(position).getImage()).into(holder.productCartImage);
        holder.productCartImage.setImageResource(modelStoreFoods.get(position).getImage());

        holder.deleteItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (modelStoreFoods.size() == 1) {
                    modelStoreFoods.remove(position);
                    notifyItemRemoved(position);
                    notifyItemRangeChanged(position, modelStoreFoods.size());
                    grandTotalplus = 0;
                    grandTotal.setText(String.valueOf(grandTotalplus));
                }

                if (modelStoreFoods.size() > 0) {
                    modelStoreFoods.remove(position);
                    notifyItemRemoved(position);
                    notifyItemRangeChanged(position, modelStoreFoods.size());
                    grandTotalplus = 0;
                    for (int i = 0; i < modelStoreFoods.size(); i++) {
                        grandTotalplus = grandTotalplus + modelStoreFoods.get((int) i).getPrice()*modelStoreFoods.get((int)i).getQuantity();
                    }

                    Log.d("totalcashthegun", String.valueOf(grandTotalplus));
                    grandTotal.setText(String.valueOf(grandTotalplus));

                } else {
                    Toast.makeText(context, "", Toast.LENGTH_SHORT).show();
                }
            }
        });


        // increment quantity and update quamtity and total cash
        holder.cartIncrement.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                grandTotalplus = 0;
                holder.cartDecrement.setEnabled(true);

                int cartUpdateCounter = (modelStoreFoods.get(position).getQuantity());
                Log.d("counterthegun", String.valueOf(modelStoreFoods.get(position).getQuantity()));

                holder.cartIncrement.setEnabled(true);
                cartUpdateCounter += 1;

                modelStoreFoods.get(position).setQuantity((cartUpdateCounter));
                double cash = modelStoreFoods.get(position).getPrice() * (modelStoreFoods.get(position).getQuantity());

                holder.productCartQuantity.setText(String.valueOf(modelStoreFoods.get(position).getQuantity()));

                modelStoreFoods.get(position).setTotalPrice(cash);
                holder.productCartPrice.setText(String.valueOf(cash));


                for (double i = 0; i < modelStoreFoods.size(); i++) {
                    grandTotalplus = grandTotalplus + modelStoreFoods.get((int) i).getPrice()*modelStoreFoods.get((int)i).getQuantity();
                }
                Log.d("totalcashthegun", String.valueOf(grandTotalplus));
                grandTotal.setText(String.valueOf(grandTotalplus));

            }

        });
        holder.cartDecrement.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //total_cash=0;
                grandTotalplus = 0;
                holder.cartIncrement.setEnabled(true);

                int cartUpdateCounter = (modelStoreFoods.get(position).getQuantity());
                Log.d("counterthegun", String.valueOf(modelStoreFoods.get(position).getQuantity()));


                if (cartUpdateCounter == 1) {
                    holder.cartDecrement.setEnabled(false);
                    Toast.makeText(context, "quantity can't be zero", Toast.LENGTH_SHORT).show();
                } else {
                    holder.cartDecrement.setEnabled(true);
                    cartUpdateCounter -= 1;
                    modelStoreFoods.get(position).setQuantity((cartUpdateCounter));
                    holder.productCartQuantity.setText(String.valueOf(modelStoreFoods.get(position).getQuantity()));
                    double cash = (modelStoreFoods.get(position).getPrice()) * (modelStoreFoods.get(position).getQuantity());

                    modelStoreFoods.get(position).setTotalPrice(cash);
                    holder.productCartPrice.setText(String.valueOf(cash));
                    for (int i = 0; i < modelStoreFoods.size(); i++) {
                        grandTotalplus = grandTotalplus + modelStoreFoods.get((int) i).getPrice()*modelStoreFoods.get((int)i).getQuantity();
                    }

                    Log.d("totalcashthegun", String.valueOf(grandTotalplus));
                    grandTotal.setText(String.valueOf(grandTotalplus));

                }
            }
        });
    }

    @Override
    public int getItemCount() {
        Log.d("sizecart", String.valueOf(modelStoreFoods.size()));
        return modelStoreFoods.size();
    }
    public interface CallBackUs {
        void addCartItemView();
    }
    // this interface creates for call the invalidateoptionmenu() for refresh the menu item
    public interface HomeCallBack {
        void updateCartCount(Context context);
    }
    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView productCartImage, cartIncrement, cartDecrement, deleteItem;
        TextView productCartCode, productCartPrice, productCartQuantity;

        public ViewHolder(View itemView) {
            super(itemView);
            productCartImage = itemView.findViewById(R.id.list_image_cart);
            productCartCode = itemView.findViewById(R.id.product_cart_code);
            productCartPrice = itemView.findViewById(R.id.product_cart_price);
            deleteItem = itemView.findViewById(R.id.delete_item_from_cart);
            productCartQuantity = itemView.findViewById(R.id.cart_product_quantity_tv);
            cartDecrement = itemView.findViewById(R.id.cart_decrement);
            cartIncrement = itemView.findViewById(R.id.cart_increment);
        }
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
