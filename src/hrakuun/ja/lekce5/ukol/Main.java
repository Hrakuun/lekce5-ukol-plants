package hrakuun.ja.lekce5.ukol;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        ListOfPlants listOfPlants1 = new ListOfPlants();
        try {
            listOfPlants1.loadPlantsFromFile(Settings.getFilename());
        } catch (PlantException e) {
            System.err.println("Nepodařilo se načíst obsah košíku ze souboru:" + Settings.getFilename() + ":\n" + e.getLocalizedMessage());
        }

        for (Plant plant : listOfPlants1.getPlants()) {
            System.out.println(plant.getWateringInfo());
        }

        try {
            listOfPlants1.saveListToFile(Settings.getNewfilename());
        } catch (PlantException e) {
            System.err.println("Nepodařilo se uložit obsah seznamu do souboru.");
        }
        System.out.println();

        List<Plant> plantsSortedByName = new ArrayList<>(listOfPlants1.getPlants());
        Collections.sort(plantsSortedByName);
        for (Plant plant : plantsSortedByName) {
            System.out.println(plant.getName());
        }
        System.out.println();

        List<Plant> plantsSortedByWatering = new ArrayList<>(listOfPlants1.getPlants());
        plantsSortedByWatering.sort(new PlantWateringComparator());
        for (Plant plant : plantsSortedByWatering) {
            System.out.println(plant.getName());
        }
        System.out.println();

    }

}
