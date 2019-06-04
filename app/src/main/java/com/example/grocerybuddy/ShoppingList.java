package com.example.grocerybuddy;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class ShoppingList extends Fragment {
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    private List<Product> shoppingList;

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

        Button addItemBtn = rootView.findViewById(R.id.addshopitem);
        addItemBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                LayoutInflater layoutInflater = LayoutInflater.from(getContext());

                View addView = layoutInflater.inflate(R.layout.add_shop_item, null);
                AlertDialog.Builder alertInput = new AlertDialog.Builder(getContext());
                alertInput.setView(addView);
                alertInput.setNegativeButton("Cancel", null);
                alertInput.setPositiveButton("Add", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dInterface, int which) {
                        Dialog dialog = Dialog.class.cast(dInterface);


                        EditText itemName = (EditText) dialog.findViewById(R.id.si_name);


                        Product newProduct = new Product();
                        newProduct.pname = itemName.getText().toString();
                        // Calli Bicknese - inserts product into database
                        //pDb.productDao().insertProduct(newProduct);
                        Product.updateShoppingList(newProduct);

                        Toast toast = Toast.makeText(getContext(), "Added Item",
                                Toast.LENGTH_SHORT);
                        //toast.setMargin(50,50);
                        toast.show();

                        dInterface.dismiss();
                    }
                });
                AlertDialog alertDialog = alertInput.create();
                alertDialog.show();
            }
        });
        shoppingList = Product.getShoppingList();
        ShopListAdapter shopListAdapter = new ShopListAdapter(shoppingList);

        shopListRecyclerView.setAdapter(shopListAdapter);
        shopListRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        //This allows for the swipe to delete functionality4
        ItemTouchHelper itHelper = new ItemTouchHelper(new SwipeToDeleteCallback_shop(shopListAdapter));
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
