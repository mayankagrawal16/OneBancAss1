package com.mayank.onebancassignment_1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class CartActivity extends AppCompatActivity {

    private RecyclerView cartRecyclerView;
    private CartAdapter cartAdapter;
    private List<Dish> cartList;
    private TextView netTotalTextView, cgstTextView, sgstTextView, grandTotalTextView;
    private Button placeOrderButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);

        cartRecyclerView = findViewById(R.id.cart_recycler_view);
        netTotalTextView = findViewById(R.id.net_total);
        cgstTextView = findViewById(R.id.cgst);
        sgstTextView = findViewById(R.id.sgst);
        grandTotalTextView = findViewById(R.id.grand_total);
        placeOrderButton = findViewById(R.id.place_order_button);

        cartRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        // Get the selected dishes from the intent
        cartList = (List<Dish>) getIntent().getSerializableExtra("cartList");

        cartAdapter = new CartAdapter(cartList);
        cartRecyclerView.setAdapter(cartAdapter);

        calculateTotals();

        placeOrderButton.setOnClickListener(v -> {
            Intent intent = new Intent(CartActivity.this, PlaceOrderActivity.class);
            intent.putExtra("orderList", (ArrayList<Dish>) cartList);
            startActivity(intent);
        });
    }

    private void calculateTotals() {
        double netTotal = 0;
        for (Dish dish : cartList) {
            netTotal += dish.getPrice();
        }

        double cgst = netTotal * 0.025;
        double sgst = netTotal * 0.025;
        double grandTotal = netTotal + cgst + sgst;

        netTotalTextView.setText("Net Total: Rs. " + netTotal);
        cgstTextView.setText("CGST: Rs. " + cgst);
        sgstTextView.setText("SGST: Rs. " + sgst);
        grandTotalTextView.setText("Grand Total: Rs. " + grandTotal);
    }
}