package com.realdolmen;


//TODO: EXTRA add a createTiger, removeTiger, updateTiger methode in TigerRepository + the whole implementation

import com.realdolmen.domain.Tiger;
import com.realdolmen.services.TigerService;

import java.util.List;
import java.util.Scanner;

public class MyApplication {

    private static Scanner scanner = new Scanner(System.in);
    private static TigerService tigerService = new TigerService();

    public static void main(String[] args) {
        System.out.println("Welcome to my humble world of programming\n");
        while (true) {
            showInitialOptions();
        }
    }

    private static void showInitialOptions() {
        System.out.println("Please select an option :");
        System.out.println("\t 1. Fetch Tiger list");
        int choiceNumber = scanner.nextInt();
        switch (choiceNumber) {
            case 1:
                showListOfTiger();
                break;
        }
    }

    private static void showListOfTiger() {
        System.out.println("----------------------");
        System.out.println("List of tigers:");
        List<Tiger> tigerList = tigerService.getTigers();
        for (Tiger t : tigerList) {
            System.out.println(t);
        }
        System.out.println("----------------------");
    }

}
