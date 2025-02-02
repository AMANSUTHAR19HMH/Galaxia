package com.mazor.galaxia;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.mazor.galaxia.Adaptor.ExoplanetAdapter;
import com.mazor.galaxia.ApiService.ApiService;
import com.mazor.galaxia.ApiService.RetrofitClient;
import com.mazor.galaxia.ModelClass.Exoplanet;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private ExoplanetAdapter adapter;
    private List<Exoplanet> exoplanetList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new ExoplanetAdapter(exoplanetList);
        recyclerView.setAdapter(adapter);

        fetchExoplanets();
    }

    private void fetchExoplanets() {
        ApiService apiService = RetrofitClient.getApiService();
        Call<JsonArray> call = apiService.getExoplanets();

        call.enqueue(new Callback<JsonArray>() {
            @Override
            public void onResponse(Call<JsonArray> call, Response<JsonArray> response) {
                if (response.isSuccessful() && response.body() != null) {
                    Log.d("NASA_API", response.body().toString());

                    // Parse the response and update RecyclerView
                    exoplanetList.clear();
                    for (int i = 0; i < response.body().size(); i++) {
                        JsonObject planet = response.body().get(i).getAsJsonObject();

                        // Safely check if the field exists and is not null
                        String name = planet.has("pl_name") && !planet.get("pl_name").isJsonNull() ? planet.get("pl_name").getAsString() : "Unknown Name";
                        String size = planet.has("pl_size") && !planet.get("pl_size").isJsonNull() ? planet.get("pl_size").getAsString() : "Unknown Size";
                        double mass = planet.has("pl_masse") && !planet.get("pl_masse").isJsonNull() ? planet.get("pl_masse").getAsDouble() : 0.0;  // Default mass if null
                        double radius = planet.has("pl_rade") && !planet.get("pl_rade").isJsonNull() ? planet.get("pl_rade").getAsDouble() : 0.0;  // Default radius if null
                        int discoveryYear = planet.has("disc_year") && !planet.get("disc_year").isJsonNull() ? planet.get("disc_year").getAsInt() : 0;  // Default year if null
                        String hostStar = planet.has("hostname") && !planet.get("hostname").isJsonNull() ? planet.get("hostname").getAsString() : "Unknown Star";

                        // Create an Exoplanet object and add it to the list
                        exoplanetList.add(new Exoplanet(name, size, mass, radius, discoveryYear, hostStar));
                    }

                    adapter.notifyDataSetChanged();
                    Toast.makeText(MainActivity.this, "Data Loaded!", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(MainActivity.this, "Response Error: " + response.code(), Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<JsonArray> call, Throwable t) {
                Toast.makeText(MainActivity.this, "Failed to Load Data", Toast.LENGTH_SHORT).show();
                Log.e("NASA_API_ERROR", t.getMessage());
            }
        });
    }


}
