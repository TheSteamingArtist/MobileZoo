package com.bloomfield.android.mobilezoo.models;

import android.net.Uri;

import com.bloomfield.android.mobilezoo.R;

/**
 * Animal data object
 */
public class Animal {
    private String name;
    private String imagePath;
    private String species; // e.g., Lion, Giant Panda
    private String diet; // e.g., carnivore, herbivore, or omnivore
    private int age;
    private String sex;

    public Animal(){

    }

    /***** getters *****/
    public String getName() {
        return name;
    }

    public String getImagePath() {
        return imagePath;
    }


    public String getSpecies() {
        return species;
    }

    public int getAge() {
        return age;
    }

    public String getDiet() {
        return diet;
    }

    public String getSex() {
        return sex;
    }

    /*******************/


    /***** setters (safe to ignore) *****/

    public void setSpecies(String species) {
        this.species = species;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public void setDiet(String diet) {
        this.diet = diet;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = getURLForResource(R.drawable.animal_logo);
    }



    /*******************/

    @Override
    public String toString() {
        return "Animal{" +
                "name='" + name + '\'' +
                ", species='" + species + '\'' +
                ", sex='" + sex + '\'' +
                '}';
    }

    /**
     * utility method to retrieve animal icon
     * @param resourceId drawable resource to retrieve
     * @return drawable resource path
     */
    public String getURLForResource (int resourceId) {
        //use BuildConfig.APPLICATION_ID instead of R.class.getPackage().getName() if both are not same
        return Uri.parse("android.resource://"+ R.class.getPackage().getName()+"/" +resourceId).toString();
    }
}
