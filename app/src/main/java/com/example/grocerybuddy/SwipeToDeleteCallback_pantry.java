package com.example.grocerybuddy;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.RecyclerView;

/*
    Tutorial for Swipe to Delete taken from https://medium.com/@zackcosborn/step-by-step-recyclerview-swipe-to-delete-and-undo-7bbae1fce27e

    Edited by: Calli Bicknese

    Swipe to delete needed for the recyclerviews
 */
public class SwipeToDeleteCallback_pantry extends ItemTouchHelper.SimpleCallback {

    private PantryProductsAdapter pantryAdapter;

    public SwipeToDeleteCallback_pantry(PantryProductsAdapter ppAdapter){
        super(0, ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT);
        pantryAdapter = ppAdapter;
    }

    @Override
    public void onSwiped(RecyclerView.ViewHolder viewHolder, int direction){
        int position = viewHolder.getAdapterPosition();
        pantryAdapter.deleteItem(position);
    }


    /*
        Not Used
     */
    @Override
    public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder target) {
        return false;
    }
}
