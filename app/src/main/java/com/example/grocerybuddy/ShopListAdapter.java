package com.example.grocerybuddy;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.snackbar.Snackbar;

import java.util.List;

/*Author: Calli Bicknese
    This is the adapter for the PantryRecyclerView that lists out the pantry items
 */
public class ShopListAdapter  extends RecyclerView.Adapter<ShopListAdapter.ShopListViewHolder> {

    /*
        Viewholder class for the shopping list recyclerview
        this holds the product item view for the list
     */
    public class ShopListViewHolder extends RecyclerView.ViewHolder{
        public TextView nameTV;
        public ImageView sIV;

        public ShopListViewHolder(View shopListView){
            super(shopListView);

            nameTV = shopListView.findViewById(R.id.product_name);
            sIV = shopListView.findViewById(R.id.shopListImage);
        }
    }

    private List<Product> shopListItems;
    private Product recentlyDeleted;
    private int recentlyDeletedItemPosition;

    //Constructor for the ShopListAdapter
    public ShopListAdapter(List<Product> prods){
        shopListItems = prods;
    }

    //This inflates the shop_list_item layout and returns the view with it inside of it
    @Override
    public ShopListAdapter.ShopListViewHolder onCreateViewHolder(ViewGroup rootView, int viewType){
        Context ctxt = rootView.getContext();

        LayoutInflater inflater = LayoutInflater.from(ctxt);

        View shopListView = inflater.inflate(R.layout.shop_list_item, rootView, false);

        ShopListViewHolder sviewHolder = new ShopListViewHolder(shopListView);

        return sviewHolder;
    }

    //this method binds the data from the object to the viewholder
    @Override
    public void onBindViewHolder(ShopListAdapter.ShopListViewHolder shopListViewHolder, int mposition){
        //gets the object based on the position in the array
        Product product = shopListItems.get(mposition);

        TextView nameTV = shopListViewHolder.nameTV;
        nameTV.setText(product.getPname());
    }

    //this method returns the size of the productsList
    @Override
    public int getItemCount(){
        return shopListItems.size();
    }

    /*
        This method is for the swipe to delete the item out of the shopping list
     */
    public void deleteItem(int position){
        recentlyDeleted = shopListItems.get(position);
        recentlyDeletedItemPosition = position;
        shopListItems.remove(position);
        notifyItemRemoved(position);
        //showUndoSnackbar();
    }

    /*private void showUndoSnackbar() {
        View view = mContext.g
        Snackbar snackbar = Snackbar.make(view, R.string.snack_bar_text,
                Snackbar.LENGTH_LONG);
        snackbar.setAction(R.string.snack_bar_undo, v -> undoDelete());
        snackbar.show();
    }*/

    private void undoDelete() {
        shopListItems.add(recentlyDeletedItemPosition,
                recentlyDeleted);
        notifyItemInserted(recentlyDeletedItemPosition);
    }


}
