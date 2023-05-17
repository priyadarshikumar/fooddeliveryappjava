package com.example.myapplication;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class CartActivity extends AppCompatActivity {

    private ListView cartListView;
    private List<String> cartItems;
    private ArrayAdapter<String> cartAdapter;
    private Button checkoutButton;
    private TextView totalPriceTextView;
    private double totalPrice = 0.0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);

        cartListView = findViewById(R.id.cartListView);
        checkoutButton = findViewById(R.id.checkoutButton);
        totalPriceTextView = findViewById(R.id.totalPriceTextView);

        cartItems = new ArrayList<>();
        cartItems.add("Item 1");
        cartItems.add("Item 2");
        cartItems.add("Item 3");
        cartItems.add("Item 4");

        cartAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, cartItems);
        cartListView.setAdapter(cartAdapter);

        cartListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String selectedItem = cartItems.get(position);
                Toast.makeText(CartActivity.this, "Clicked on " + selectedItem, Toast.LENGTH_SHORT).show();
                // Add your logic to handle the selection, such as removing the item from the cart
            }
        });

        updateTotalPrice();

        checkoutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Add your logic to handle the checkout process here
                Toast.makeText(CartActivity.this, "Checkout clicked", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void updateTotalPrice() {
        totalPrice = calculateTotalPrice();
        totalPriceTextView.setText("Total: $" + totalPrice);
    }

    private double calculateTotalPrice() {
        // Add your logic to calculate the total price based on the cart items
        // This is just a sample calculation, replace it with your own implementation
        return cartItems.size() * 10.0;
    }
}

