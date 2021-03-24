package com.realdolmen;

//TODO: add 3 packages domain, services, repositories
//TODO: add the classes Tiger, TigerService, TigerRepository in their corresponding packages
//TODO: add a name field in the Tiger class + constructor + getter
//TODO: add a getTigers methode in TigerRepository which returns a list of tigers + implement it with JDBC code
//TODO: add a getTigers methode in TigerService which returns a list of tigers + TigerService has a TigerRepository

//TODO: EXTRA add a createTiger, removeTiger, updateTiger methode in TigerRepository + the whole implementation

public class Main {

    // TODO: Add static scanner field
    // TODO: Add Static field AnimalService + initialize it

    public static void main(String[] args) {
        System.out.println("Welcome to my humble world of programming\n");
        while (true) {
            showInitialOptions();
        }
    }

    private static void showInitialOptions() {
        System.out.println("Please select an option :");
        System.out.println("\t 1. Fetch Tiger list");
//      TODO: use scanner to get the number of choice and put it in a variable
        switch (0) {/*TODO: Add the choice variable between ()*/
            case 1:
                System.out.println("----------------------");
                System.out.println("List of tigers:");
                //TODO: call the getTigers() methode from the TigerService and print the list out
                System.out.println("----------------------");
                break;

        }

    }

}
