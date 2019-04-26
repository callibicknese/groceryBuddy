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

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
    }

    @Override
    protected void onStop(){
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}
