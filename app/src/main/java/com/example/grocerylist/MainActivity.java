package com.example.grocerylist;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void addItem(View view) {
        Intent intent = new Intent(MainActivity.this, AddItemActivity.class);
        startActivity(intent);
    }

    public void listItem(View view) {
        Intent intent = new Intent(MainActivity.this, ItemList.class);
        startActivity(intent);
    }

    public void closeApp(View view) {
        finishAffinity();
        System.exit(0);
    }
}