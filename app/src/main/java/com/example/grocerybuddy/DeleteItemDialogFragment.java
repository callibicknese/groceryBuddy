package com.example.grocerybuddy;

import android.content.DialogInterface;
import androidx.core.app.DialogFragment;
import android.app.Dialog;
import android.app.AlertDialog;
import android.os.Bundle;

public class DeleteItemDialogFragment extends DialogFragment {
    @Override
    public Dialog onCreateDialog (Bundle savedInstance) {

        AlertDialog.Builder builder = new AlertDialog.Builder (getActivity());
        builder.setMessage("Do you want to delete this item?")
            .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            public void onClick ( DialogInterface dia , int id ) {
                //Remove the item from the database
                //TODO - connect the delete item dialog to the database
            }
        })
                .setNegativeButton ("No" , new DialogInterface . OnClickListener () {
            public void onClick ( DialogInterface dia , int id ) {
                //User decided not to delete the item
                dia.cancel();
            }
        });
            return builder.show();
    }
}
