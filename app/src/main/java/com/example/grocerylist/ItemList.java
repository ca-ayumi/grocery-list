package com.example.grocerylist;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;

public class ItemList extends AppCompatActivity {
    private RecyclerView recyclerView;
    private GroceryListAdapter adapter;
    private List<GroceryItem> itemList;
    private DatabaseHelper databaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_list);

//        // Lista de Teste
//        List<GroceryItem> lista = new ArrayList<>();
//        lista.add(new GroceryItem("1", "Item 1",10));
//        lista.add(new GroceryItem("2", "Item 2",3));
//        lista.add(new GroceryItem("3", "Item 3",52));

        recyclerView = findViewById(R.id.RecyclerViewItens);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);

        databaseHelper = new DatabaseHelper(this);
        itemList = databaseHelper.getAllGroceryItems();
//        adapter = new GroceryListAdapter(lista, this);
        adapter = new GroceryListAdapter(itemList, this);
        recyclerView.setAdapter(adapter);
    }
}