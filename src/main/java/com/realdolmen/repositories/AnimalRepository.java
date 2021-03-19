package com.realdolmen.repositories;

import com.realdolmen.domain.Animal;

import java.util.ArrayList;

public class AnimalRepository {

    private static ArrayList<Animal> animals = new ArrayList<Animal>();

    public ArrayList<Animal> getAnimals() {
        return animals;
    }

    public void setAnimals(ArrayList<Animal> animals) {
        AnimalRepository.animals = animals;
    }

    public void addAnimalToList(Animal animal) {
        animals.add(animal);
    }
}
