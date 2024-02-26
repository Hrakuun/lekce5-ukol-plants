package hrakuun.ja.lekce5.ukol;

public class Main {

    public static void main(String[] args) {

        ListOfPlants listOfPlants1 = new ListOfPlants();
        try {
            listOfPlants1.loadPlantsFromFile(Settings.getFilename());
        } catch (PlantException e) {
            System.err.println("Nepodařilo se načíst obsah košíku ze souboru:" +Settings.getFilename()+":\n"+e.getLocalizedMessage());
        }

        for (Plant plant : listOfPlants1.getPlants()) {
            System.out.println(plant);
        }

    }

}
