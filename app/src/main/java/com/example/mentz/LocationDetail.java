package com.example.mentz;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.example.mentz.databinding.ActivityLocationDetailBinding;
import com.example.mentz.model.Location;


import java.util.ArrayList;
import java.util.List;

public class LocationDetail extends AppCompatActivity {

    ActivityLocationDetailBinding binding;
    List<Location> locationList;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityLocationDetailBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        locationList = new ArrayList<>();
        locationList = GlobalVars.locationList;
        int position = getIntent().getIntExtra("position", 0);
        try {
            binding.tvType.setText(locationList.get(position).getType());
            binding.tvName.setText(locationList.get(position).getParent().getName());
            binding.tvLocation.setText(locationList.get(position).getName());
        } catch (Exception e) {
            Log.d("TAG", "onCreateError: " + e.getMessage());
        }
    }
}
