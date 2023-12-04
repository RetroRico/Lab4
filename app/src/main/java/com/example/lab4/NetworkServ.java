//package com.example.lab4;
//
//import com.fasterxml.jackson.databind.ObjectMapper;
//
//import org.jetbrains.annotations.NotNull;
//
//import java.io.IOException;
//
//import okhttp3.Call;
//import okhttp3.Callback;
//import okhttp3.OkHttpClient;
//import okhttp3.Request;
//import okhttp3.Response;
//
//public class NetworkServ {
//
//    private OkHttpClient client;
//    public NetworkServ(){
//        this.client = new OkHttpClient();
//    }
//
//    Request request = new Request.Builder()
//            .get()
//            .url("https://docs.spacexdata.com/?version=latest#e520e500-0421-4774-8bcb-8d07b7dfa222")
//            .build();
//
//
//    client.newCall(request).enqueue(new Callback() {
//        @Override
//        public void onResponse(@NotNull Call call, @NotNull Response response) throws IOException {
//            // Отримання даних з response.body() та обробка їх за допомогою Jackson
//            String jsonData = response.body().string();
//            ObjectMapper mapper = new ObjectMapper();
//            YourDataClass data = mapper.readValue(jsonData, YourDataClass.class);
//
//            // Оновлення інтерфейсу користувача на основі отриманих даних
//            // (наприклад, виклик методу, який оновлює UI з отриманими даними)
//        }
//
//        @Override
//        public void onFailure(@NotNull Call call, @NotNull IOException e) {
//            e.printStackTrace();
//            // Обробка помилок під час виконання запиту
//        }
//    });
//}
