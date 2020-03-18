package com.example.foodorderapplication;


import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridLayout;
import android.widget.TimePicker;
import android.widget.Toast;

public class HomeFragment extends Fragment {


    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home,container,false);
        GridLayout gridLayout = (GridLayout)view.findViewById(R.id.mainGrid);

        for(int i=0;i<gridLayout.getChildCount();i++)
        {
            CardView cardView = (CardView)gridLayout.getChildAt(i);
            final int finalValue=i;
            cardView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                   // getActivity().startActivity(HomeFragment.this,AmericanFoods.class);
                    // Toast.makeText(HomeDashBoard.this,"clicked at index "+finalValue,Toast.LENGTH_SHORT).show();
                    if(finalValue==0)
                    {
                        Intent intent = new Intent(getActivity(), AmericanFoods.class);
                        startActivity(intent);
                    }
                   else if(finalValue==1)
                    {
                       Intent intent = new Intent(getActivity(),IndianFoods.class);
                        startActivity(intent);
                    }
                   else if(finalValue==2)
                    {
                        Intent intent = new Intent(getActivity(),MexicanFoods.class);
                        startActivity(intent);
                    }
                    else if(finalValue==3)
                    {
                        Intent intent = new Intent(getActivity(),ItalianFoods.class);
                        startActivity(intent);
                    }
                    else if(finalValue==4)
                    {
                        Intent intent = new Intent(getActivity(),ChineseFoods.class);
                        startActivity(intent);
                    }
                    else if(finalValue==5)
                    {
                        Intent intent = new Intent(getActivity(),JapaneseFoods.class);
                        startActivity(intent);
                    }
                    else
                    {
                        Toast.makeText(getActivity(),"Please select an item",Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        GridLayout gridLayout;
        super.onViewCreated(view, savedInstanceState);
   }
}
