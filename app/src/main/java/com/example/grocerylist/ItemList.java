package com.example.grocerylist;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ItemList extends AppCompatActivity {
    private RecyclerView recyclerView;
    private GroceryListAdapter adapter;
    private List<GroceryItem> itemList;
    private DatabaseHelper databaseHelper;
    ImageView returnButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_list);
        returnButton = findViewById(R.id.ic_return);

        recyclerView = findViewById(R.id.RecyclerViewItens);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);

        databaseHelper = new DatabaseHelper(this);
        itemList = databaseHelper.getAllGroceryItems();
//        adapter = new GroceryListAdapter(lista, this);
        adapter = new GroceryListAdapter(itemList, this);
        recyclerView.setAdapter(adapter);

        returnButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ItemList.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}