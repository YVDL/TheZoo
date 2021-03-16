package com.realdolmen;

import com.realdolmen.domain.Lion;
import com.realdolmen.domain.Tiger;

import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in);


    public static void main(String[] args) {
        System.out.println("Welcome to my humble world of programming");
        showInitialOptions();
    }

    private static void showInitialOptions() {
        System.out.println("Please select an option :");
        System.out.println("\t 1. Add animal");
        int choice = scanner.nextInt();
        switch (choice){
            case 1:
                addAnAnimal();
                break;
            default:
                System.out.println("Type in a valid input!");
                showInitialOptions();
                break;
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
                Lion lion = new Lion(scanner.next(), scanner.nextInt());
                break;
            case 2:
                System.out.println("Please give a name and an age for the tiger");
                Tiger tiger = new Tiger(scanner.next(), scanner.nextInt());
                break;
            default:
                System.out.println("Type in a valid input");
                addAnAnimal();
                break;
        }

    }
}
