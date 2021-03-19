package com.realdolmen;

import com.realdolmen.domain.*;
import com.realdolmen.services.AnimalService;

import java.util.ArrayList;
import java.util.Scanner;


public class Main {
    private static Scanner scanner = new Scanner(System.in);


    public static void main(String[] args) {
        System.out.println("Welcome to my humble world of programming");
        while (true) {
            showInitialOptions();

        }

    }

    private static void showInitialOptions() {
        AnimalService animalService = new AnimalService(scanner);
        System.out.println("Please select an option :");
        System.out.println("\t 1. Add animal");
        System.out.println("\t 2. Show list of animals");
        System.out.println("\t 3. Make sound ");
        System.out.println("\t 4. Remove animal");
        System.out.println("\t 5. add the birth date");
        int choice = scanner.nextInt();
        switch (choice) {
            case 1:
                System.out.println("Please select an animal to add: ");
                for (AnimalType animalType : AnimalType.values()) {
                    System.out.println("\t" + animalType.getIdentity() + " " + animalType.getDisplayName());
                }
                int animalNumber = scanner.nextInt();

                Animal animal = animalService.createAnimal(AnimalType.values()[animalNumber -1]);
                animalService.addAnAnimal(animal);
                break;
            case 2:
                System.out.println("This is the animal list");
                animalService.showAnimals();
                break;
            case 3:
                System.out.println("Which animal should make sound");
                animalService.makeSound();
                break;
            case 4:
                System.out.println("Which animal do you want to remove? ");
                animalService.removeAnimal();
                break;
            case 5:
                animalService.addBirthDate();
                break;

            default:
                System.out.println("Type in a valid input!");
                showInitialOptions();
                break;
        }

    }

}
