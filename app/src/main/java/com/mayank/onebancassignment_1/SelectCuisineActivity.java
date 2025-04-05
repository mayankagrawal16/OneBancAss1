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

public class SelectCuisineActivity extends AppCompatActivity {

    private RecyclerView dishRecyclerView;
    private DishAdapter dishAdapter;
    private List<Dish> dishList;
    private List<Dish> cartList;
    private Button viewCartButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_cuisine);

        dishRecyclerView = findViewById(R.id.dish_recycler_view);
        viewCartButton = findViewById(R.id.view_cart_button);
        dishRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        // Get the selected cuisine from the intent
        String selectedCuisine = getIntent().getStringExtra("cuisine");

        // Populate the dish list based on the selected cuisine
        dishList = new ArrayList<>();
        cartList = new ArrayList<>();
        if (selectedCuisine.equals("North Indian")) {
            dishList.add(new Dish("Butter Chicken", R.drawable.butter_chicken, 350));
            dishList.add(new Dish("Paneer Tikka", R.drawable.paneer_tikka, 200));
            dishList.add(new Dish("Chole Bhature", R.drawable.chole_bhature, 150));
        } else if (selectedCuisine.equals("Chinese")) {
            dishList.add(new Dish("Fried Rice", R.drawable.fried_rice, 120));
            dishList.add(new Dish("Manchurian", R.drawable.manchurian, 180));
            dishList.add(new Dish("Spring Rolls", R.drawable.spring_rolls, 100));
        }
        // Add more cuisines and dishes as needed

        dishAdapter = new DishAdapter(dishList, new DishAdapter.OnItemClickListener() {
            @Override
            public void onAddClick(Dish dish) {
                cartList.add(dish);
            }
        });
        dishRecyclerView.setAdapter(dishAdapter);

        viewCartButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SelectCuisineActivity.this, CartActivity.class);
                intent.putExtra("cartList", (ArrayList<Dish>) cartList);
                startActivity(intent);
            }
        });
    }
}
