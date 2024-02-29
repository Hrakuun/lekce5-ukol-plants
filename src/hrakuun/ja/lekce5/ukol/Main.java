package hrakuun.ja.lekce5.ukol;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        ListOfPlants listOfPlants1 = new ListOfPlants();
        loadDataFromFile(Settings.getFilename(), listOfPlants1);

        for (Plant plant : listOfPlants1.getPlants()) {
            System.out.println(plant.getWateringInfo());
        }

        try {
            listOfPlants1.saveListToFile(Settings.getNewfilename());
        } catch (PlantException e) {
            System.err.println("Nepodařilo se uložit obsah seznamu do souboru.");
        }
        System.out.println();

        System.out.println("Seřazeno dle jména:");
        List<Plant> plantsSortedByName = new ArrayList<>(listOfPlants1.getPlants());
        Collections.sort(plantsSortedByName);
        for (Plant plant : plantsSortedByName) {
            System.out.println(plant.getName());
        }
        System.out.println();

        System.out.println("Seřazeno dle poslední zálivky:");
        List<Plant> plantsSortedByWatering = new ArrayList<>(listOfPlants1.getPlants());
        plantsSortedByWatering.sort(new PlantWateringComparator());
        for (Plant plant : plantsSortedByWatering) {
            System.out.println(plant.getName());
        }
        System.out.println();

        // načtení vadných vstupních dat ze souboru data/kvetiny-spatne-datum.txt
        loadDataFromFile(Settings.getWrongFilename(), listOfPlants1);
        System.out.println();

        // načtení vadných vstupních dat ze souboru  data/kvetiny-spatne-frekvence.txt
        loadDataFromFile(Settings.getWrongFilename2(),listOfPlants1);

    }

    public static void loadDataFromFile(String fileName, ListOfPlants listOfPlants) {
        try {
            listOfPlants.loadPlantsFromFile(fileName);
        } catch (PlantException e) {
            System.err.println("Nepodařilo se načíst obsah košíku ze souboru:" + fileName + ":\n" + e.getLocalizedMessage());
        }

    }

}
