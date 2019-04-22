package com.example.grocerybuddy;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;

import androidx.room.Room;

public class MainActivity extends AppCompatActivity {

    GBDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    //Creates the Database.
    protected void createDatabase(){
        db = Room.databaseBuilder(getApplicationContext(),
                GBDatabase.class, "Product Database").build();


    }

}
