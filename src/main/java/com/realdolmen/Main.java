package com.realdolmen;

import com.realdolmen.services.AnimalService;

import java.util.Scanner;


public class Main {
    private static final Scanner scanner = new Scanner(System.in);


    public static void main(String[] args){
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
        int choice = scanner.nextInt();
        switch (choice) {
            case 1:
                animalService.addAnAnimal();
                break;
            case 2:
                animalService.showAnimals();
                break;
            case 3:
                animalService.makeSound();
                break;
            case 4:
                animalService.removeAnimal();
                break;

            default:
                System.out.println("Type in a valid input!");
                showInitialOptions();
                break;
        }

    }

}
