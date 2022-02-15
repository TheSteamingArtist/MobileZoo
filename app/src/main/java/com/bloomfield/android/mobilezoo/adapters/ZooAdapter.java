package com.bloomfield.android.mobilezoo.adapters;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bloomfield.android.mobilezoo.R;
import com.bloomfield.android.mobilezoo.models.Animal;
import com.bumptech.glide.Glide;

import java.util.List;

public class ZooAdapter extends RecyclerView.Adapter<ZooAdapter.ZooHolder>
{
    Context context;

    List<Animal> animals;


    public ZooAdapter(Context context, List<Animal> animal)
    {
        this.context = context;
        this.animals = animal;
    }

    @NonNull
    @Override
    public ZooHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
    {
        Log.d("zooAdapter", "OnCreateViewHolder");

        View zooView = LayoutInflater.from(context).inflate(R.layout.zoo_list, parent, false);

        return new ZooHolder(zooView);
    }

    public void onBindViewHolder(@NonNull ZooAdapter.ZooHolder holder, int position)
    {
        Log.d("ZooAdapter", "OnBindViewHolder" + position);

        Animal animal = animals.get(position);

        holder.bind(animal);
    }

    @Override
    public int getItemCount() {
        return animals.size();
    }


    public class ZooHolder extends RecyclerView.ViewHolder
    {
        RelativeLayout container;
        TextView name;
        TextView species;
        ImageView zooPicture;

        public ZooHolder(@NonNull View itemView)
        {
            super(itemView);
            name = itemView.findViewById(R.id.name);
            species = itemView.findViewById(R.id.species);
            zooPicture = itemView.findViewById(R.id.zooImage);
            container = itemView.findViewById(R.id.container);

        }

        public void bind(Animal animal)
        {
            name.setText(animal.getName() + "");
            species.setText(animal.getSpecies() + "");
            String imageURL = animal.getImagePath();

            Glide.with(context).load(imageURL).into(zooPicture);
        }
    }


}
