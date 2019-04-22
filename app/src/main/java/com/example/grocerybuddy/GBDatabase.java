package com.example.grocerybuddy;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {Product.class}, version = 1)
public abstract class GBDatabase extends RoomDatabase {
    public abstract ProductDao productDao();
}
