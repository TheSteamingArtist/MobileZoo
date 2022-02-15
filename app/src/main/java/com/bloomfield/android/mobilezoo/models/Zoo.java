package com.bloomfield.android.mobilezoo.models;

import com.bloomfield.android.mobilezoo.R;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

// A special class that lasts as long as the app does
// The data source for this project
public class Zoo {
    private static Zoo sZoo;

    List<Animal> animals;
    String[] species;

    public static Zoo getZoo() {
        if (sZoo == null)
            sZoo = new Zoo();
        return sZoo;
    }

    // private constructor to prevent creating multiple of this class
    private Zoo() {
        animals = new ArrayList<>();
        species = new String[] {"Tiger", "Whale", "Bird", "Ostrich",
                "Peacock", "Dog", "Bear", "Elephant"};

        Random rand = new Random();

        for (int i = 0; i < 100; i++) {
            Animal animal = new Animal();
            animal.setName("Animal #" + i);
            animal.setAge((i * 3) % 100);
            animal.setSex(i % 2 == 0 ? "Male" : "Female");
            animal.setDiet (i % 3 == 0 ? "Carnivore" : i % 3 == 1 ? "Herbivore" : "Omnivore");
            animal.setImagePath("drawable://" + R.drawable.animal_logo);
            animal.setSpecies(species[rand.nextInt(species.length)]);

            animals.add(animal);
        }
    }

    public List<Animal> getAnimals() {
        return animals;
    }
}
