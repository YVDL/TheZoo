package com.realdolmen;


//TODO: EXTRA add a createTiger, removeTiger, updateTiger methode in TigerRepository + the whole implementation

import com.realdolmen.domain.Tiger;
import com.realdolmen.services.TigerService;

import java.util.List;
import java.util.Scanner;


//Has an instance of TigerService (MyApplication only calls methods from service NOT repositories)
public class MyApplication {

    private static Scanner scanner = new Scanner(System.in); //private static outside of main, so can be used in every method
    private static TigerService tigerService = new TigerService();// this creates an instance of TigerService

    public static void main(String[] args) {
        System.out.println("Welcome to my humble world of programming\n");
        while (true) { //keeps running until false
            showInitialOptions();
        }
    }

    private static void showInitialOptions() {
        System.out.println("Please select an option :");
        System.out.println("\t 1. Fetch Tiger list" +
                "\n\t 2. Add a new Tiger");
        //TODO: add a new option to delete food by its id
        //TODO: add a new option to update a foodName by its id
        int choiceNumber = scanner.nextInt();
        switch (choiceNumber) {
            case 1:
                showListOfTiger();
                break;
            case 2:
                System.out.println("What's the name of the new Tiger?");
                addNewTiger();
                break;
        }
    }

    private static void showListOfTiger() {
        System.out.println("----------------------");
        System.out.println("List of tigers:");
        List<Tiger> tigerList = tigerService.getTigers();
        tigerList.stream().forEach(tiger -> System.out.println(tiger));
        System.out.println("----------------------"); //out of loop, only adds one line (not after each tiger)
    }


    private static void addNewTiger() {
        scanner.nextLine();
        String name = scanner.nextLine(); //scans tiger name
        Tiger tiger = new Tiger(name); // creates new tiger with scanned name
        tigerService.addATiger(tiger); // adds new tiger to tigerService
    }

}
