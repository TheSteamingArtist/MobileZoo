package com.bloomfield.android.mobilezoo.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.bloomfield.android.mobilezoo.R;
import com.bloomfield.android.mobilezoo.adapters.ZooAdapter;
import com.bloomfield.android.mobilezoo.models.Animal;
import com.bloomfield.android.mobilezoo.models.Zoo;
import com.bumptech.glide.Glide;

import java.util.List;

public class AnimalListActivity extends AppCompatActivity {
    // pre-populated list of animals (search logs for "AnimalListActivity")
    private List<Animal> animals;

    ZooAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView zooView = findViewById(R.id.zooView);

        adapter = new ZooAdapter(this, animals);

        zooView.setAdapter(adapter);

        zooView.setLayoutManager(new LinearLayoutManager(this));

        LinearLayoutManager layout = new LinearLayoutManager(this);

        zooView.setLayoutManager(layout);

        animals = Zoo.getZoo().getAnimals();
        Log.i("AnimalListActivity", animals.toString());
    }
}