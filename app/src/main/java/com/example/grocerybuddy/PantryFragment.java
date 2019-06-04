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

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.List;

public class PantryFragment extends Fragment {

    private OnFragmentInteractionListener mListener;
    private List<Product> products;
    public GBDatabase pDb;

    public PantryFragment() {
        // Required empty public constructor
    }

    public static PantryFragment newInstance() {
        PantryFragment fragment = new PantryFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    /**
        Author: Calli Bicknese
        This inflates the recycler view for the pantry fragment
     */
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        final View rootView = inflater.inflate(R.layout.fragment_pantry, container, false);
        RecyclerView pantryRecyclerView = rootView.findViewById(R.id.pantryRecyclerView);

        /**
         * Author: Kevin Z
         *
         * This is the code for the user manually entering a product.
         * The content of the AlertDialog is the LinearLayout add_product.xml
         */
        Button addProductBtn = rootView.findViewById(R.id.button_add_product);
        addProductBtn.setOnClickListener(new View.OnClickListener()
        {
            public void onClick (View v) {

                AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
                LayoutInflater inflater = getActivity().getLayoutInflater();
                builder.setTitle("Manually add a product");
                builder.setMessage("Please enter product information below:");
                builder.setView(R.layout.add_product);
                builder.setNegativeButton("Cancel", null);
                builder.setPositiveButton("Add", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dInterface, int which) {
                        Dialog dialog = Dialog.class.cast(dInterface);


                        EditText itemName = (EditText) dialog.findViewById(R.id.product_name);
                        EditText itemDesc = (EditText) dialog.findViewById(R.id.product_desc);
                        EditText expirDate = (EditText) dialog.findViewById(R.id.product_expir_date);
                        EditText buyDate = (EditText) dialog.findViewById(R.id.product_buy_date);

                        Product newProduct = new Product();
                        newProduct.pname = itemName.getText().toString();
                        newProduct.pdesc = itemDesc.getText().toString();
                        newProduct.pBuyDate = buyDate.getText().toString();
                        newProduct.pExDate = expirDate.getText().toString();
                        // Calli Bicknese - inserts product into database
                        //pDb.productDao().insertProduct(newProduct);
                        Product.updatePantryList(newProduct);

                        Toast toast = Toast.makeText(getContext(), "Added product",
                                Toast.LENGTH_SHORT);
                        //toast.setMargin(50,50);
                        toast.show();

                        dInterface.dismiss();
                    }
                });

                builder.create();
                builder.show();
            }
        });



        products = Product.getPantryList();

        PantryProductsAdapter pantryProductsAdapter = new PantryProductsAdapter(products);
        pantryRecyclerView.setAdapter(pantryProductsAdapter);
        pantryRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        //This allows for the swipe to delete functionality4
        ItemTouchHelper itHelper = new ItemTouchHelper(new SwipeToDeleteCallback_pantry(pantryProductsAdapter));
        itHelper.attachToRecyclerView(pantryRecyclerView);

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
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
