package com.example.grocerylist;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class EditItemActivity extends AppCompatActivity {
    private EditText edtItemName;
    private EditText edtItemQuantity;
    private Button btnUpdateItem;
    private Button btnDeleteItem;
    private String itemId;
    ImageView returnButton;

    private DatabaseHelper databaseHelper;
    private GroceryItem currentItem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_item);

        edtItemName = findViewById(R.id.editItemName);
        edtItemQuantity = findViewById(R.id.editItemQuantity);
        btnUpdateItem = findViewById(R.id.btnUpdateItem);
        btnDeleteItem = findViewById(R.id.btnDeleteItem);
        returnButton = findViewById(R.id.ic_return);

        String itemName = getIntent().getStringExtra("ItemName");
        String itemQuantity = getIntent().getStringExtra("ItemQuantity");
        itemId = getIntent().getStringExtra("ItemId");

        edtItemName.setText(itemName);
        edtItemQuantity.setText(itemQuantity);

        databaseHelper = new DatabaseHelper(this);

        btnUpdateItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateItem();

                Intent intent = new Intent(EditItemActivity.this, ItemList.class);
                startActivity(intent);
            }
        });
        btnDeleteItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                deleteItem();

                Intent intent = new Intent(EditItemActivity.this, ItemList.class);
                startActivity(intent);
            }
        });

        returnButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(EditItemActivity.this, ItemList.class);
                startActivity(intent);
            }
        });
    }

    private void updateItem() {
        String name = edtItemName.getText().toString().trim();
        int quantity = Integer.parseInt(edtItemQuantity.getText().toString().trim());

        currentItem = new GroceryItem(itemId, name, quantity);

        int rowsAffected = databaseHelper.updateGroceryItem(currentItem);

        if (rowsAffected > 0) {
            Toast.makeText(EditItemActivity.this, "Item atualizado com sucesso", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(EditItemActivity.this, "Falha ao atualizar o item", Toast.LENGTH_SHORT).show();
        }

        finish();
    }

    private void deleteItem() {
        databaseHelper.deleteGroceryItem(itemId);

        finish();
    }
}