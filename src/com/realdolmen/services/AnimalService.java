package com.realdolmen.services;

import com.realdolmen.domain.*;
import com.realdolmen.repositories.AnimalRepository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class AnimalService {


    private Scanner scanner;
    private AnimalRepository animalRepository = new AnimalRepository();


    public AnimalService(Scanner scanner) {

        this.scanner = scanner;
    }

    public void addAnAnimal(Animal animal) {
        animalRepository.addAnimalToList(animal);
    }


    public void removeAnimal() {
        showAnimals();
        int animalNumber = scanner.nextInt();
        animalRepository.getAnimals().remove(animalNumber);

    }

    public void makeSound() {
        String animalType = scanner.next();

        for (Animal animal : animalRepository.getAnimals()) {
            Audible animalSound = animal;

            if (animal.getAnimalType().equalsIgnoreCase(animalType)) {
                System.out.println(animal.toString() + " " + animalSound.makeSound());
                System.out.println("******************************************");
            }


        }

    }

    public void showAnimals() {
        for (int i = 0; i < animalRepository.getAnimals().size(); i++) {
            System.out.println(" Animal number: " + (i+1)+ " " + animalRepository.getAnimals().get(i).toString());
        }
    }


    public Animal createAnimal(AnimalType animalType) {
        System.out.println("Please give a name for the animal");
        System.out.print("Name ");
        String name = scanner.next();
        animalType.getAnimal().setName(name);

        return animalType.getAnimal();
    }

    public void addBirthDate() {
        System.out.println("for which animal you want to add a birthdate");
        showAnimals();
        int animalNumber = scanner.nextInt();
        ArrayList<Animal> animals = animalRepository.getAnimals();
        if (animalNumber >= animals.size()) {
            System.out.println("Choose a correct number!");
            addBirthDate();

            return;
        }
        System.out.printf("please provide the birth date");
        String birthdate = scanner.next();

        Animal animal = animals.get(animalNumber);
        animal.setBirthdate(LocalDate.parse(birthdate));
        animals.set(animalNumber, animal);

    }
}
