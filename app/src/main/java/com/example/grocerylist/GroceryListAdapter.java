package com.example.grocerylist;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class GroceryListAdapter extends RecyclerView.Adapter<GroceryListAdapter.GroceryViewHolder> {
    private List<GroceryItem> groceryItems;
    private Context context;

    public GroceryListAdapter(List<GroceryItem> groceryItems, Context context) {
        this.groceryItems = groceryItems;
        this.context = context;
    }

    @NonNull
    @Override
    public GroceryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_grocery, parent, false);
        return new GroceryViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull GroceryViewHolder holder, int position) {
        GroceryItem groceryItem = groceryItems.get(position);
        holder.txtItemName.setText(groceryItem.getName());
        holder.txtItemQuantity.setText(String.valueOf(groceryItem.getQuantity()));
    }

    @Override
    public int getItemCount() {
        return groceryItems.size();
    }

    public static class GroceryViewHolder extends RecyclerView.ViewHolder {
        TextView txtItemName;
        TextView txtItemQuantity;

        public GroceryViewHolder(@NonNull View itemView) {
            super(itemView);
            txtItemName = itemView.findViewById(R.id.txtItemName);
            txtItemQuantity = itemView.findViewById(R.id.txtItemQuantity);
        }
    }
}
