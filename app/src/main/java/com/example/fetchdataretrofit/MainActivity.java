package com.example.fetchdataretrofit;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    public static String api = "https://jsonplaceholder.typicode.com/";

    RecyclerView recyclerView;
    List<Posts> postsList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       setContentView(R.layout.activity_main);
       recyclerView = findViewById(R.id.recyclerId);
       recyclerView.setHasFixedSize(true);
       recyclerView.setLayoutManager(new LinearLayoutManager(this));


     RetrofitInstance.getInstance().apiInterface.getPost().enqueue(new Callback<List<Posts>>() {
         @Override
         public void onResponse(Call<List<Posts>> call, Response<List<Posts>> response) {
             postsList = response.body();
             PostAdapter postAdapter = new PostAdapter(getApplicationContext(),postsList);
             recyclerView.setAdapter(postAdapter);

             for(int i =0; i<postsList.size(); i++)     {
                 Log.e("api","onFailure :" +postsList.get(i).getTitle());
             }

         }

         @Override
         public void onFailure(Call<List<Posts>> call, Throwable t) {
             Log.e("api","onFailure :" +t.getLocalizedMessage());

         }
     });
    }
}