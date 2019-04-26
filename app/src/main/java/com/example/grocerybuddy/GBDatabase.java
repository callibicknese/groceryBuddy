package com.example.grocerybuddy;

import androidx.room.Database;
import androidx.room.RoomDatabase;

//reference https://developer.android.com/training/data-storage/room/index.html#java

@Database(entities = {Product.class}, version = 1)
public abstract class GBDatabase extends RoomDatabase {
    public abstract ProductDao productDao();
}
