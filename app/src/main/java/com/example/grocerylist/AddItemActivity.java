package com.example.grocerylist;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.UUID;

public class AddItemActivity extends AppCompatActivity {
    private EditText edtItemName;
    private EditText edtItemQuantity;
    private Button btnAddItem;
    private DatabaseHelper databaseHelper;
    ImageView returnButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_item);

        edtItemName = findViewById(R.id.edtItemName);
        edtItemQuantity = findViewById(R.id.edtItemQuantity);
        btnAddItem = findViewById(R.id.btnAddItem);
        returnButton = findViewById(R.id.ic_return);

        databaseHelper = new DatabaseHelper(this);

        btnAddItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = edtItemName.getText().toString();
                int quantity = Integer.parseInt(edtItemQuantity.getText().toString());
                String id = UUID.randomUUID().toString();

                GroceryItem item = new GroceryItem(id, name, quantity);

                // Salvar o item no banco de dados
                long result = databaseHelper.insertGroceryItem(item);
                if (result != -1) {
                    Toast.makeText(AddItemActivity.this, "Item adicionado com sucesso", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(AddItemActivity.this, "Erro ao adicionar o item", Toast.LENGTH_SHORT).show();
                }

                Intent intent = new Intent();
                intent.putExtra("item", (CharSequence) item);
                setResult(RESULT_OK, intent);
                finish();
            }
        });

        returnButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(AddItemActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}
