package hrakuun.ja.lekce5.ukol;

import java.io.*;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ListOfPlants {
    // region variables
    private List<Plant> plants = new ArrayList<>();
//    endregion

//    region methods

    public void addPlant(Plant plant) {
        plants.add(plant);
    }

    public Plant getPlantOnIndex(int index) {
        return plants.get(index);
    }

    public void removePlant(Plant plant) {
        plants.remove(plant);
    }

//    endregion
//    region file handling

    public void loadPlantsFromFile(String fileName) throws PlantException {
        int lineCounter = 0;
        try (Scanner scanner = new Scanner(new BufferedReader(new FileReader(fileName)))) {
            while (scanner.hasNextLine()) {
                lineCounter++;
                String line = scanner.nextLine();
                String[] parts = line.split(Settings.getDelimiter());
                if (parts.length != 5) {
                    throw new PlantException("Nesprávný počet parametrů na řádku č." + lineCounter + ": " + line + "!");
                }
                String name = parts[0];
                String note = parts[1];
                int frequencyOfWatering = Integer.parseInt(parts[2]);
                LocalDate lastWatering = LocalDate.parse(parts[3]);
                LocalDate plantedOn = LocalDate.parse(parts[4]);
                Plant plant = new Plant(name, note, plantedOn, lastWatering, frequencyOfWatering);
                plants.add(plant);
            }
        } catch (FileNotFoundException e) {
            throw new PlantException("Soubor " + fileName + " nebyl nalezen!\n" + e.getLocalizedMessage());
        } catch (NumberFormatException e) {
            throw new PlantException("Frekvence zálevání musí být zapsána v celých číslech! Chyba na řádku číslo: " + lineCounter + "\n" + e.getLocalizedMessage());
        } catch (DateTimeParseException e) {
            throw new PlantException("Data uvedena v neplatném formátu. Vyžadován formát YYYY-MM-DD! Chyba na řádku číslo: " + lineCounter + "\n" + e.getLocalizedMessage());
        }
    }

    public void saveListToFile(String fileName) throws PlantException {
        String newFileName = "new_".concat(fileName);
        String delimiter = Settings.getDelimiter();
        try (PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter(fileName)))) {
            for (Plant plant : plants) {
                writer.println(
                        plant.getName() + delimiter
                                + plant.getNotes() + delimiter
                                + plant.getFrequencyOfWatering() + delimiter
                                + plant.getLastWatering() + delimiter
                                + plant.getPlantedOn()
                );
            }
        } catch (FileNotFoundException e) {
            throw new PlantException("Soubor "+fileName+" nenalezen!\n"+e.getLocalizedMessage());
        } catch (IOException e) {
            throw new PlantException("Chyba při zápisu do souboru: "+fileName+":\n" +e.getLocalizedMessage());
        }
    }

//    endregion
}
