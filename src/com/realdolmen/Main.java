package com.realdolmen;

import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in);


    public static void main(String[] args) {
        System.out.println("Welcome to my humble world of programming");
        showInitialOptions();
    }

    private static void showInitialOptions() {
        System.out.println("Please select an option :");
        System.out.println("1. Add animal");
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

    }
}
