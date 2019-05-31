package com.example.grocerybuddy;

import android.content.ClipData;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;
import java.util.List;

public class ShoppingList extends Fragment {
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    private ArrayList<Product> shoppingList;

    public ShoppingList() {
        // Required empty public constructor
    }

    public static ShoppingList newInstance(String param1, String param2) {
        ShoppingList fragment = new ShoppingList();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    /*
        Author: Calli Bicknese
        This inflates the recycler view for the shopping list to display the list
     */
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_shopping_list, container, false);

        RecyclerView shopListRecyclerView = rootView.findViewById(R.id.shopListRecyclerView);

        shoppingList = Product.createShoppingList();

        ShopListAdapter shopListAdapter = new ShopListAdapter(shoppingList);

        shopListRecyclerView.setAdapter(shopListAdapter);
        shopListRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        //This allows for the swipe to delete functionality4
        ItemTouchHelper itHelper = new ItemTouchHelper(new SwipeToDeleteCallback(shopListAdapter));
        itHelper.attachToRecyclerView(shopListRecyclerView);

        return rootView;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    public interface OnFragmentInteractionListener {
        void onFragmentInteraction(Uri uri);
    }
}
