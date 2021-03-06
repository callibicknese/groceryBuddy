package com.example.grocerybuddy;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

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
        public ImageView productIV;
        private PantryRecyclerViewClickListener mListener;

        public PantryViewHolder(View productView){
            super(productView);

            nameTV = productView.findViewById(R.id.product_name);
            productIV = productView.findViewById(R.id.imageView2);

        }
    }

    /**
     * Author: Calli Bicknese
     * Adapter for PantryRecyclerView
     */
    private List<Product> products;
    private Product recentlyDeleted;
    private int recentlyDeletedItemPosition;
    public GBDatabase pDb;


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
    public void onBindViewHolder(final PantryProductsAdapter.PantryViewHolder pantryViewHolder, final int mposition){
        //gets the object based on the position in the array
        Product product = products.get(mposition);

        TextView nameTV = pantryViewHolder.nameTV;
        nameTV.setText(product.pname);

        //trying to get the image to load from the BitMap field inside of Product object
        //ImageView productIV = pantryViewHolder.productIV;
        //Log.w(productIV.toString(), "HERE");
        //productIV.setImageBitmap(product.pImage);
    }

    //this method returns the size of the productsList
    @Override
    public int getItemCount(){
            return products.size();
    }


    /*
        This method is for the swipe to delete the item out of the shopping list
     */
    public void deleteItem(int position){
        recentlyDeleted = products.get(position);
        recentlyDeletedItemPosition = position;
        products.remove(position);
        notifyItemRemoved(position);
    }


}


