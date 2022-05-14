package com.example.mentz;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import androidx.appcompat.widget.SearchView;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import com.example.mentz.databinding.ActivityMainBinding;
import com.example.mentz.model.Fahrplan;


public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;
    private MyAdapter myAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);
        binding.mainSearchView.onActionViewExpanded();
        binding.mainSearchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                getSuperHeroes(query);
                binding.mainSearchView.clearFocus();
                return true;
            }
            @Override
            public boolean onQueryTextChange(String newText) {
                getSuperHeroes(newText);
                return true;
            }
        });
    }

    private void getSuperHeroes(String query) {
        Call<Fahrplan> call = RetrofitClient.getInstance().getMyApi().getList("de", "RapidJSON", "any", query);
        call.enqueue(new Callback<Fahrplan>() {
            @Override
            public void onResponse(Call<Fahrplan> call, Response<Fahrplan> response) {
                if (response.isSuccessful()) {
                    myAdapter = new MyAdapter(MainActivity.this, response.body().getLocations());
                    binding.rvFahrplan.setAdapter(myAdapter);
                    Log.d("TAG", "onResponse: " + response.body().getVersion());
                }
            }
            @Override
            public void onFailure(Call<Fahrplan> call, Throwable t) {
                Log.d("TAG", "onFailure: " + t.getMessage());
            }
        });
    }
}