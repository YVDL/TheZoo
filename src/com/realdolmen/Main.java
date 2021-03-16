package com.realdolmen;

import com.realdolmen.domain.Animal;
import com.realdolmen.domain.Lion;
import com.realdolmen.domain.Tiger;

import java.util.ArrayList;
import java.util.Scanner;


public class Main {
    private static Scanner scanner = new Scanner(System.in);
    private static ArrayList<Animal>animals = new ArrayList<Animal>();


    public static void main(String[] args) {
        System.out.println("Welcome to my humble world of programming");
        while (true){
            showInitialOptions();
        }

    }

    private static void showInitialOptions() {
        System.out.println("Please select an option :");
        System.out.println("\t 1. Add animal");
        System.out.println("\t 2. Show list of animals");
        int choice = scanner.nextInt();
        switch (choice){
            case 1:
                addAnAnimal();
                break;
            case 2:
                showAnimals();
                break;
            default:
                System.out.println("Type in a valid input!");
                showInitialOptions();
                break;
        }

    }

    private static void showAnimals() {
        System.out.println("This is the animal list");
        for (Animal animal : animals){
            System.out.println("Name: "+animal.getName()+" Age: "+animal.getAge());
        }
    }

    private static void addAnAnimal() {
        System.out.println("Please select an option: ");
        System.out.println("\t 1. Add a lion");
        System.out.println("\t 2. Add a tiger");
        int choice = scanner.nextInt();
        switch (choice){
            case 1:
                System.out.println("Please give a name and an age for the lion");
                System.out.print("Name ");
                String name = scanner.next();
                System.out.print("Age ");
                int age = scanner.nextInt();
                Lion lion = new Lion(name, age);
                animals.add(lion);
                break;
            case 2:
                System.out.println("Please give a name and an age for the tiger");
                Tiger tiger = new Tiger(scanner.next(), scanner.nextInt());
                animals.add(tiger);
                break;
            default:
                System.out.println("Type in a valid input");
                addAnAnimal();
                break;
        }

    }
}
