
package com.mayank.onebancassignment_1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;

public class PlaceOrderActivity extends AppCompatActivity {

    private RecyclerView orderRecyclerView;
    private OrderAdapter orderAdapter;
    private List<Dish> orderList;
    private TextView netTotalTextView, cgstTextView, sgstTextView, grandTotalTextView;
    private Button confirmOrderButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_place_order);

        orderRecyclerView = findViewById(R.id.order_recycler_view);
        netTotalTextView = findViewById(R.id.net_total);
        cgstTextView = findViewById(R.id.cgst);
        sgstTextView = findViewById(R.id.sgst);
        grandTotalTextView = findViewById(R.id.grand_total);
        confirmOrderButton = findViewById(R.id.confirm_order_button);

        orderRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        // Get the order list from the intent
        orderList = (List<Dish>) getIntent().getSerializableExtra("orderList");

        orderAdapter = new OrderAdapter(orderList);
        orderRecyclerView.setAdapter(orderAdapter);

        calculateTotals();

        confirmOrderButton.setOnClickListener(v -> {
            // Implement order confirmation logic here
        });
    }

    private void calculateTotals() {
        double netTotal = 0;
        for (Dish dish : orderList) {
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