package com.example.lab4.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.lab4.R;

import java.util.Objects;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_activity);

        TextView itemNameTextView = findViewById(R.id.Name_TextView);
        TextView itemIdTextView = findViewById(R.id.Id_TextView);
        TextView itemModelTextView = findViewById(R.id.Model_TextView);
        TextView itemTypeTextView = findViewById(R.id.Type_TextView);
        TextView itemRoleTextView = findViewById(R.id.Role_TextView);
        TextView itemActiveTextView = findViewById(R.id.Active_TextView);
        Button ok_button = findViewById(R.id.ok_button);

        String itemName = getIntent().getStringExtra("ITEM_NAME");
        String itemId = getIntent().getStringExtra("ITEM_ID");
        String itemModel = getIntent().getStringExtra("ITEM_MODEL");
        String itemType = getIntent().getStringExtra("ITEM_TYPE");
        String itemRole = getIntent().getStringExtra("ITEM_ROLE");
        String itemActive = getIntent().getStringExtra("ITEM_ACTIVE");
        if(Objects.equals(itemModel, "null"))
        {
            itemModel = "Doesn't have";
        }
        if(Objects.equals(itemActive, "true")){
            itemActive = "yes";
        }
        else{
            itemActive = "no";
        }

        itemNameTextView.setText(itemName);
        itemIdTextView.setText(itemId);
        itemModelTextView.setText(itemModel);
        itemTypeTextView.setText(itemType);
        itemRoleTextView.setText(itemRole);
        itemActiveTextView.setText(itemActive);

        ok_button.setOnClickListener(view -> {
            //Переход к списку
            Intent intent1 = new Intent(SecondActivity.this, MainActivity.class);
            startActivity(intent1);
        });
    }
}
