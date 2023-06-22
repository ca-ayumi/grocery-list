package com.example.grocerylist;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

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

//        recyclerView = findViewById(R.id.RecyclerViewerMenu);
//        recyclerView.setLayoutManager(new LinearLayoutManager(this));
//
//        databaseHelper = new DatabaseHelper(this);
//        itemList = databaseHelper.getAllGroceryItems();
//        adapter = new GroceryListAdapter(itemList, this);
//        recyclerView.setAdapter(adapter);
    }

    public void addItem(View view){
        Intent intent = new Intent(MainActivity.this, AddItemActivity.class);
        startActivity(intent);
    }

    public void listItem(View view){
        Intent intent = new Intent(MainActivity.this, GroceryListAdapter.class);
        startActivity(intent);
    }

    public void closeApp(View view){
        finish();
    }
}
