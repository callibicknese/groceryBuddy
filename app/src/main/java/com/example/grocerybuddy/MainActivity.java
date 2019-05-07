package com.example.grocerybuddy;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import androidx.room.Room;

public class MainActivity extends AppCompatActivity {

    GBDatabase db;
    Button jsonBtn;
    EditText jsonView;
    JSONParser jsonParser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        jsonParser = new JSONParser(this);
        jsonView = findViewById(R.id.jsonView);

        jsonBtn = findViewById(R.id.parserButton);
        jsonBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                jsonParser.parse(jsonView.getText().toString());
            }
        });
    }

    // Creates the Database.
    protected void createDatabase() {
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
    protected void onStop() {
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}
