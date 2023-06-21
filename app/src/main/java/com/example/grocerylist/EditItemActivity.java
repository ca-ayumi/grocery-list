package com.example.grocerylist;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class EditItemActivity extends AppCompatActivity {
    private EditText edtItemName;
    private EditText edtItemQuantity;
    private Button btnUpdateItem;
    private Button btnDeleteItem;

    private DatabaseHelper databaseHelper;
    private GroceryItem currentItem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_item);

        edtItemName = findViewById(R.id.edtItemName);
        edtItemQuantity = findViewById(R.id.edtItemQuantity);
        btnUpdateItem = findViewById(R.id.btnUpdateItem);
        btnDeleteItem = findViewById(R.id.btnDeleteItem);

        databaseHelper = new DatabaseHelper(this);

        Intent intent = getIntent();
        if (intent.hasExtra("item")) {
            currentItem = intent.getParcelableExtra("item");
            edtItemName.setText(currentItem.getName());
            edtItemQuantity.setText(String.valueOf(currentItem.getQuantity()));
        }

        btnUpdateItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateItem();
            }
        });

        btnDeleteItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                deleteItem();
            }
        });
    }

    private void updateItem() {
        String name = edtItemName.getText().toString().trim();
        int quantity = Integer.parseInt(edtItemQuantity.getText().toString().trim());

        currentItem.setName(name);
        currentItem.setQuantity(quantity);

        databaseHelper.updateGroceryItem(currentItem);

        finish();
    }

    private void deleteItem() {
        databaseHelper.deleteGroceryItem(currentItem);

        finish();
    }
}