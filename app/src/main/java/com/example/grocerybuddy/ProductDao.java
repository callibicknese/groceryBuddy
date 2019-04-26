package com.example.grocerybuddy;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import java.util.List;

//reference https://developer.android.com/training/data-storage/room/index.html#java
@Dao
public interface ProductDao {

    //Gets all the products available
    @Query("SELECT * FROM Product")
    List<Product> getAll();

    //Get all the products with a select product id contained in the array
    @Query("SELECT * FROM Product WHERE pid IN (:ProductIds)")
    List<Product> loadAllByIds(int[] ProductIds);


    //Inserts a individual Product
    //Will abort if identical object already exists
    @Insert(onConflict = OnConflictStrategy.ABORT)
    void insertProduct(Product product);

    @Insert
    void insertAll(Product... products);

    //Deletes a individual product.
    @Delete
    void delete(Product product);

}
