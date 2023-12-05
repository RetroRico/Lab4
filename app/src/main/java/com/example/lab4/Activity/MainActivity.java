package com.example.lab4.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.lab4.Adapter;
import com.example.lab4.Data;
import com.example.lab4.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class MainActivity extends AppCompatActivity implements Adapter.OnItemClickListener{
    private RecyclerView recyclerView;
    private Adapter adapter;
    private List<Data> dataList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        dataList = new ArrayList<>();
        adapter = new Adapter(dataList, this);
        recyclerView.setAdapter(adapter);
        fetchDataFromApi();

        Button exit_button = findViewById(R.id.exit_button);
        exit_button.setOnClickListener(view -> finishAffinity());
    }

    private void fetchDataFromApi() {
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .get()
                .url("https://api.spacexdata.com/v3/ships")
                .build();

        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(@NonNull Call call, @NonNull IOException e) {
                showToast("Network error: " + e.getMessage());
            }

            @Override
            public void onResponse(@NonNull Call call, @NonNull Response response) throws IOException {
                if (response.isSuccessful()) {
                    String responseData = response.body().string();
                    parseData(responseData);
                } else {
                    showToast("Failed to fetch data");
                }
            }
        });
    }

    private void parseData(String responseData) {
        try {
            JSONArray jsonArray = new JSONArray(responseData);
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                String ShipName = jsonObject.getString("ship_name");
                String ShipId = jsonObject.getString("ship_id");
                String ShipModel = jsonObject.getString("ship_model");
                String ShipType = jsonObject.getString("ship_type");
                String ShipRole = jsonObject.getString("roles");
                String ShipActive = Boolean.toString(jsonObject.getBoolean("active"));
                Data data = new Data(ShipId, ShipName, ShipModel, ShipType, ShipRole, ShipActive);
                dataList.add(data);
            }
            runOnUiThread(() -> adapter.notifyDataSetChanged());
        } catch (JSONException e) {
            e.printStackTrace();
            showToast("JSON Parsing error: " + e.getMessage());
        }
    }

    private void showToast(String message) {
        runOnUiThread(() -> Toast.makeText(this, message, Toast.LENGTH_SHORT).show());
    }

    @Override
    public void onItemClick(int position){
        Data clickedItem = dataList.get(position);
        Intent intent = new Intent(MainActivity.this, SecondActivity.class);
        intent.putExtra("ITEM_NAME", clickedItem.getShipName());
        intent.putExtra("ITEM_ID", clickedItem.getShipId());
        intent.putExtra("ITEM_MODEL", clickedItem.getShipModel());
        intent.putExtra("ITEM_TYPE", clickedItem.getShipType());
        intent.putExtra("ITEM_ROLE", clickedItem.getShipRole());
        intent.putExtra("ITEM_ACTIVE", clickedItem.getShipActive());
        startActivity(intent);
    }
}
