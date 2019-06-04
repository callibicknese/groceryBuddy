package com.example.grocerybuddy;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import androidx.room.Room;

import com.google.android.material.navigation.NavigationView;


public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener, PantryFragment.OnFragmentInteractionListener, ShoppingList.OnFragmentInteractionListener {

    GBDatabase db;
    Button jsonBtn, panButt;
    EditText jsonView;
    JSONParser jsonParser;
    ImageView cameraPhoto;  // for ImageView on add_product.xml

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cameraPhoto = (ImageView) findViewById(R.id.photo_view);
    }

    // Creates the Database.
    protected void createDatabase() {
        db = Room.databaseBuilder(getApplicationContext(),
                GBDatabase.class, "Product Database").build();
    }

    /**
     * Author: Kevin Z
     * This is code to launch an intent I found at
     * https://developer.android.com/training/camera/photobasics#java.
     *
     * Requires permissions for camera hardware in the manifest file.
     */
    static final int REQUEST_IMAGE_CAPTURE = 1;

    public void dispatchTakePictureIntent(View view) {
        Log.i("GroceryBuddy", "Taking photo test");
        Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        if (takePictureIntent.resolveActivity(getPackageManager()) != null) {
            startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE);
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == REQUEST_IMAGE_CAPTURE && resultCode == RESULT_OK) {
            Bundle extras = data.getExtras();
            Bitmap imageBitmap = (Bitmap) extras.get("data");
            Log.i("GroceryBuddy", "IMAGE IS IN!");

            // This doesn't work since the ImageView is null
            ImageView view = (ImageView) findViewById(R.id.photo_view);
            //view.setImageBitmap(imageBitmap);
        }
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
    protected void onStop() {
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        return false;
    }
}
