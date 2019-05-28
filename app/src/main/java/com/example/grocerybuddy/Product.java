package com.example.grocerybuddy;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.util.ArrayList;


// reference https://developer.android.com/training/data-storage/room/index.html#java
@Entity
public class Product {

    @PrimaryKey
    public int pid;

    @ColumnInfo(name = "product_name")
    public String pname;

    @ColumnInfo(name = "desc")
    public String pdesc;

    @ColumnInfo(name ="date_bought")
    public String pBuyDate;

    @ColumnInfo(name ="expiration_date")
    public String pExDate;

    //Ignored Methods - Getters and Setters
    public String getPname() {
        return pname;
    }

    /*Author: Calli Bicknese
            creates the PantryList for the pantry recyclerList
            eventually will populate from database information
         */
    public static ArrayList<Product> createPantryList(){
        ArrayList<Product> products = new ArrayList<>();

        Product p1 = new Product();
        p1.pname = "Lettuce";
        Product p2 = new Product();
        p2.pname = "Tomato";

        products.add(p1);
        products.add(p2);

        return products;
    }
}

