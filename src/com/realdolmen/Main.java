package com.realdolmen;

import com.realdolmen.domain.*;

import java.util.ArrayList;
import java.util.Scanner;


public class Main {
    private static Scanner scanner = new Scanner(System.in);
    private static ArrayList<Animal> animals = new ArrayList<Animal>();


    public static void main(String[] args) {
        System.out.println("Welcome to my humble world of programming");
        while (true) {
            showInitialOptions();

        }

    }

    private static void showInitialOptions() {
        System.out.println("Please select an option :");
        System.out.println("\t 1. Add animal");
        System.out.println("\t 2. Show list of animals");
        System.out.println("\t 3. Make sound ");
        System.out.println("\t 4. Remove animal");
        int choice = scanner.nextInt();
        switch (choice) {
            case 1:
                addAnAnimal();
                break;
            case 2:
                showAnimals();
                break;
            case 3:
                makeSound();
                break;
            case 4:
                removeAnimal();
                break;

            default:
                System.out.println("Type in a valid input!");
                showInitialOptions();
                break;
        }

    }

    private static void removeAnimal() {
        System.out.println("Which animal do you want to remove? ");
        showAnimals();
        int animalNumber = scanner.nextInt();
        animals.remove(animalNumber);

    }

    private static void makeSound() {
        System.out.println("Which animal should make sound");
        String animalType = scanner.next();

        for (Animal animal: animals) {
            Audible animalSound = animal;

            if (animal.getAnimalType().equalsIgnoreCase(animalType)){
                System.out.println(animal.toString() + " " + animalSound.makeSound());
                System.out.println("******************************************");
            }


        }

    }

    private static void showAnimals() {
        System.out.println("This is the animal list");
        for (int i = 0; i < animals.size() ; i++) {
            System.out.println(" Animal number: "+ i + " " +animals.get(i).toString());
        }
    }

    private static void addAnAnimal() {
        System.out.println("Please select an option: ");
        System.out.println("\t 1. Add a lion");
        System.out.println("\t 2. Add a tiger");
        System.out.println("\t 3. Add an ape");
        int choice = scanner.nextInt();
        switch (choice) {
            case 1:
                Animal lion = askForAgeName(new Lion());
                animals.add(lion);
                break;
            case 2:
                Animal tiger = askForAgeName(new Tiger());
                animals.add(tiger);
                break;
            case 3:
                Animal ape = askForAgeName(new Ape());
                animals.add(ape);
                break;
            default:
                System.out.println("Type in a valid input");
                addAnAnimal();
                break;
        }

    }

    private static Animal askForAgeName(Animal animal) {
        System.out.println("Please give a name and an age for the animal");
        System.out.print("Name ");
        String name = scanner.next();
        System.out.print("Age ");
        int age = scanner.nextInt();
        animal.setAge(age);
        animal.setName(name);

        return animal;
    }
}
