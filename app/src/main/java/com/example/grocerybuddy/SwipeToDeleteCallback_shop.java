package com.example.grocerybuddy;

import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.RecyclerView;

/*
    Tutorial for Swipe to Delete taken from https://medium.com/@zackcosborn/step-by-step-recyclerview-swipe-to-delete-and-undo-7bbae1fce27e

    Edited by: Calli Bicknese

    Swipe to delete needed for the recyclerviews
 */
public class SwipeToDeleteCallback_shop extends ItemTouchHelper.SimpleCallback {

    private ShopListAdapter shopListAdapter;

    private Drawable icon;
    private ColorDrawable background;

    public SwipeToDeleteCallback_shop(ShopListAdapter slAdapter){
        super(0, ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT);
        shopListAdapter = slAdapter;
    }

    @Override
    public void onSwiped(RecyclerView.ViewHolder viewHolder, int direction){
        int position = viewHolder.getAdapterPosition();
        shopListAdapter.deleteItem(position);
    }

    /*
        Not Used
     */
    @Override
    public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder target) {
        return false;
    }
}

