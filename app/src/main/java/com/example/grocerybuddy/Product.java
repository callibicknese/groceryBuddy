package com.example.grocerybuddy;

import android.graphics.Bitmap;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

import java.util.ArrayList;
import java.util.List;


// reference https://developer.android.com/training/data-storage/room/index.html#java
@Entity
public class Product {
    @Ignore
    public static List<Product> products, shoppingList;

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
    @Ignore
    public String getPname() {
        return pname;
    }

    @Ignore
    public static List<Product> getPantryList(){
        return products;
    }
    @Ignore
    public static List<Product> getShoppingList(){
        return shoppingList;
    }

    //stores the bitmap image for the product
    @Ignore
    public Bitmap pImage;

    /**
     * Author: Calli Bicknese
     * creates the PantryList for the pantry recyclerList
     * eventually will populate from database information
     */
    public static void createPantryList(){
        products = new ArrayList<>();
    }

    public static void updatePantryList(Product product){
        if(products == null){
            products = new ArrayList<>();
            products.add(product);
        }
        products.add(product);
    }

    /**
     * Author: Calli Bicknese
     * creates the shoppinglist
     */
    public static void createShoppingList(){
        shoppingList = new ArrayList<>();
    }

    public static void updateShoppingList(Product product){
        if(shoppingList == null){
            shoppingList = new ArrayList<>();
            shoppingList.add(product);
        }
        shoppingList.add(product);
    }
}

