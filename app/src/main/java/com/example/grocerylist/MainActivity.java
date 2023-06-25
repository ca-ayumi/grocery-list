package com.example.grocerylist;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private GroceryListAdapter adapter;
    private List<GroceryItem> itemList;
    private DatabaseHelper databaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void addItem(View view){
        Intent intent = new Intent(MainActivity.this, AddItemActivity.class);
        startActivity(intent);
    }

    public void listItem(View view){
        Intent intent = new Intent(MainActivity.this, ItemList.class);
        startActivity(intent);
    }

    public void closeApp(View view){
        finish(); System.exit(0);
}
}
