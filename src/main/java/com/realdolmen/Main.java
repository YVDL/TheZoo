package com.realdolmen;

import com.realdolmen.domain.*;
import com.realdolmen.services.AnimalService;
import org.alcibiade.asciiart.coord.TextBoxSize;
import org.alcibiade.asciiart.raster.CharacterRaster;
import org.alcibiade.asciiart.raster.ExtensibleCharacterRaster;
import org.alcibiade.asciiart.raster.RasterContext;
import org.alcibiade.asciiart.widget.ChartWidget;
import org.alcibiade.asciiart.widget.TableWidget;
import org.alcibiade.asciiart.widget.model.TableModel;
import org.alcibiade.asciiart.widget.model.TableModelCollectionAdapter;

import java.awt.image.Raster;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Main {
    private static Scanner scanner = new Scanner(System.in);



    public static void main(String[] args) {
//        System.out.println("Welcome to my humble world of programming");
//        while (true) {
//            showInitialOptions();
//
//        }

        List<String> items = new ArrayList<String>();
        items.add("Orange");
        items.add("Apple");
        items.add("Lemon");

        TableModel tableModel = new TableModelCollectionAdapter(items, "Fruit");
        TableWidget tableWidget = new TableWidget(tableModel);

        CharacterRaster raster = new ExtensibleCharacterRaster(' ');
        tableWidget.render(new RasterContext(raster));

        System.out.println(raster);
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
