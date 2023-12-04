package com.example.lab4.Activity;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.lab4.R;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_activity);

        TextView itemNameTextView = findViewById(R.id.ShipId);
        TextView itemIdTextView = findViewById(R.id.ShipName);

        String itemName = getIntent().getStringExtra("ITEM_NAME");
        String itemId = getIntent().getStringExtra("ITEM_ID");

        itemNameTextView.setText(itemName);
        itemIdTextView.setText(String.valueOf(itemId));
    }
}
