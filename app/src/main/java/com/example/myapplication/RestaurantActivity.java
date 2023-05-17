package com.example.myapplication;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class RestaurantActivity extends AppCompatActivity {

    private ListView restaurantListView;
    private String[] restaurants = {"Restaurant 1", "Restaurant 2", "Restaurant 3", "Restaurant 4"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restaurant);

        restaurantListView = findViewById(R.id.restaurantListView);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, restaurants);
        restaurantListView.setAdapter(adapter);

        restaurantListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String selectedRestaurant = restaurants[position];
                Toast.makeText(RestaurantActivity.this, "Clicked on " + selectedRestaurant, Toast.LENGTH_SHORT).show();
                // Add your logic to handle the selection and navigate to the restaurant details screen if needed
            }
        });
    }
}
