package com.example.grocerybuddy;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

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
}
