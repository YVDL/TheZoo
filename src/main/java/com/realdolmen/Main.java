package com.realdolmen;

import com.realdolmen.domain.Tiger;
import com.realdolmen.services.AnimalService;

import java.util.List;
import java.util.Scanner;


public class Main {
    private static final Scanner scanner = new Scanner(System.in);
    private static final AnimalService animalService = new AnimalService();

    public static void main(String[] args) {
        System.out.println("Welcome to my humble world of programming\n");
        while (true) {
            showInitialOptions();
        }
    }

    private static void showInitialOptions() {
        System.out.println("Please select an option :");
        System.out.println("\t 1. Fetch Tiger list");
        int choice = scanner.nextInt();
        switch (choice) {
            case 1:
                System.out.println("----------------------");
                System.out.println("List of tigers:"); 
                List<Tiger> tigers = animalService.getTigers();
                System.out.println(tigers);
                System.out.println("----------------------");
                break;

        }

    }

}
