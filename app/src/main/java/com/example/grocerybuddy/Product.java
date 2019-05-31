package com.example.grocerybuddy;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
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
    @Ignore
    public String getPname() {
        return pname;
    }

    //stores the bitmap image for the product
    @Ignore
    public Bitmap pImage;

    /*Author: Calli Bicknese
            creates the PantryList for the pantry recyclerList
            eventually will populate from database information
         */
    public static ArrayList<Product> createPantryList(){
        ArrayList<Product> products = new ArrayList<>();

        Product p1 = new Product();
        p1.pname = "Lettuce";
       // p1.pImage =
        Product p2 = new Product();
        p2.pname = "Tomato";
        Product p3 = new Product();
        p3.pname = "Potato";
        Product p4 = new Product();
        p4.pname = "Milk";
        Product p5 = new Product();
        p5.pname = "Juice";
        Product p6 = new Product();
        p6.pname = "Eggs";
        Product p7 = new Product();
        p7.pname = "Flour";
        Product p8 = new Product();
        p8.pname = "Sugar";

        products.add(p1);
        products.add(p2);
        products.add(p3);
        products.add(p4);
        products.add(p5);
        products.add(p6);
        products.add(p7);
        products.add(p8);
        return products;
    }

    public static ArrayList<Product> createShoppingList(){
        ArrayList<Product> shoppingList = new ArrayList<>();

        Product p1 = new Product();
        p1.pname = "Lettuce";
        Product p2 = new Product();
        p2.pname = "Tomato";
        Product p3 = new Product();
        p3.pname = "Potato";
        Product p4 = new Product();
        p4.pname = "Milk";
        Product p5 = new Product();
        p5.pname = "Juice";
        Product p6 = new Product();
        p6.pname = "Eggs";
        Product p7 = new Product();
        p7.pname = "Flour";
        Product p8 = new Product();
        p8.pname = "Sugar";

        shoppingList.add(p1);
        shoppingList.add(p2);
        shoppingList.add(p3);
        shoppingList.add(p4);
        shoppingList.add(p5);
        shoppingList.add(p6);
        shoppingList.add(p7);
        shoppingList.add(p8);

        return shoppingList;
    }
}

