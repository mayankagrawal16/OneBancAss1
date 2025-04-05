package com.mayank.onebancassignment_1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private RecyclerView cuisineRecyclerView;
    private CuisineAdapter cuisineAdapter;
    private List<Cuisine> cuisineList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cuisineRecyclerView = findViewById(R.id.cuisine_recycler_view);
        cuisineRecyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));

        cuisineList = new ArrayList<>();
        cuisineList.add(new Cuisine("North Indian", R.drawable.north_indian));
        cuisineList.add(new Cuisine("Chinese", R.drawable.chinese));
        cuisineList.add(new Cuisine("Mexican", R.drawable.mexican));
        cuisineList.add(new Cuisine("South Indian", R.drawable.south_indian));
        cuisineList.add(new Cuisine("Italian", R.drawable.italian));

        cuisineAdapter = new CuisineAdapter(cuisineList, new CuisineAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(Cuisine cuisine) {
                Intent intent = new Intent(MainActivity.this, SelectCuisineActivity.class);
                intent.putExtra("cuisine", cuisine.getName());
                startActivity(intent);
            }
        });
        cuisineRecyclerView.setAdapter(cuisineAdapter);

        Button cartButton = findViewById(R.id.cart_button);
        cartButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, PlaceOrderActivity.class);
                startActivity(intent);
            }
        });

        Button languageButton = findViewById(R.id.language_button);
        languageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Implement language switching logic here
            }
        });
    }
}