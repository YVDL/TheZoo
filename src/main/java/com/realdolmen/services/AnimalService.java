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

    public  void addAnAnimal() {
        System.out.println("Please select an option: ");
        System.out.println("\t 1. Add a lion");
        System.out.println("\t 2. Add a tiger");
        System.out.println("\t 3. Add an ape");
        int choice = scanner.nextInt();
        switch (choice) {
            case 1:
                Animal lion = askForAgeName(new Lion());
                animalRepository.getAnimals().add(lion);
                break;
            case 2:
                Animal tiger = askForAgeName(new Tiger());
                animalRepository.getAnimals().add(tiger);
                break;
            case 3:
                Animal ape = askForAgeName(new Ape());
                animalRepository.getAnimals().add(ape);
                break;
            default:
                System.out.println("Type in a valid input");
                addAnAnimal();
                break;
        }

    }


    public  void removeAnimal() {
        System.out.println("Which animal do you want to remove? ");
        showAnimals();
        int animalNumber = scanner.nextInt();
        animalRepository.getAnimals().remove(animalNumber);

    }

    public  void makeSound() {
        System.out.println("Which animal should make sound");
        String animalType = scanner.next();

        for (Animal animal: animalRepository.getAnimals()) {
            Audible animalSound = animal;

            if (animal.getAnimalType().equalsIgnoreCase(animalType)){
                System.out.println(animal.toString() + " " + animalSound.makeSound());
                System.out.println("******************************************");
            }


        }

    }

    public  void showAnimals() {
        System.out.println("This is the animal list");
        for (int i = 0; i < animalRepository.getAnimals().size() ; i++) {
            System.out.println(" Animal number: "+ i + " " +animalRepository.getAnimals().get(i).toString());
        }
    }


    public  Animal askForAgeName(Animal animal) {
        System.out.println("Please give a name and an age for the animal");
        System.out.print("Name ");
        String name = scanner.next();
        System.out.print("Age ");
        int age = scanner.nextInt();
        animal.setAge(age);
        animal.setName(name);

        return animal;
    }

    public void addBirthDate() {
        System.out.println("for which animal you want to add a birthdate");
        showAnimals();
        int animalNumber = scanner.nextInt();
        ArrayList<Animal> animals = animalRepository.getAnimals();
        if(animalNumber >= animals.size() ){
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
