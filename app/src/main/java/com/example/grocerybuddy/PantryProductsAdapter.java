package com.example.grocerybuddy;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

/*Author: Calli Bicknese
    This is the adapter for the PantryRecyclerView that lists out the pantry items
 */
public class PantryProductsAdapter  extends RecyclerView.Adapter<PantryProductsAdapter.PantryViewHolder> {

    /*
        Viewholder class for the pantry recyclerview
        this holds the product item view for the list
     */
    public class PantryViewHolder extends RecyclerView.ViewHolder{
        public TextView nameTV;

        public PantryViewHolder(View productView){
            super(productView);

            nameTV = productView.findViewById(R.id.product_name);
        }
    }

    private List<Product> products;

    //Constructor for the PantryProductsAdapter
    public PantryProductsAdapter(List<Product> prods){
        products = prods;
    }

    //This inflates the pantry_list_item layout and returns the view with it inside of it
    @Override
    public PantryProductsAdapter.PantryViewHolder onCreateViewHolder(ViewGroup rootView, int viewType){
        Context ctxt = rootView.getContext();

        LayoutInflater inflater = LayoutInflater.from(ctxt);

        View pantryProductView = inflater.inflate(R.layout.pantry_list_item, rootView, false);

        PantryViewHolder pviewHolder = new PantryViewHolder(pantryProductView);
        return pviewHolder;
    }

    //this method binds the data from the object to the viewholder
    @Override
    public void onBindViewHolder(PantryProductsAdapter.PantryViewHolder pantryViewHolder, int mposition){
        //gets the object based on the position in the array
        Product product = products.get(mposition);

        TextView nameTV = pantryViewHolder.nameTV;
        nameTV.setText(product.getPname());
    }

    //this method returns the size of the productsList
    @Override
    public int getItemCount(){
        return products.size();
    }

}
