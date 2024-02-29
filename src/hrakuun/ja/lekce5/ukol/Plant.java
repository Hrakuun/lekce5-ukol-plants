package hrakuun.ja.lekce5.ukol;

import java.time.LocalDate;

public class Plant implements Comparable<Plant> {

//    region variables

    private String name;
    private String notes;
    private LocalDate plantedOn;
    private LocalDate lastWatering;
    private int frequencyOfWatering;

    //    endregion
//    region constructors
    public Plant(String name, String notes, LocalDate plantedOn, LocalDate lastWatering, int frequencyOfWatering) throws PlantException {
        this.name = name;
        this.notes = notes;
        this.plantedOn = plantedOn;
        setLastWatering(lastWatering);
        setFrequencyOfWatering(frequencyOfWatering);
    }

    public Plant(String name, LocalDate plantedOn, int frequencyOfWatering) throws PlantException {
        this(name, "", plantedOn, LocalDate.now(), frequencyOfWatering);
    }

    public Plant(String name) throws PlantException {
        this(name, LocalDate.now(), 7);
    }

//    endregion

//    region methods

    public String getWateringInfo() {
        LocalDate nextWatering = lastWatering.plusDays(frequencyOfWatering);
        return "Název: " + name + ", Poslední zálivka: " + lastWatering + ", Příští zálivka: " + nextWatering + ".";
    }

    @Override
    public int compareTo(Plant otherPlant) {
        return this.name.compareTo(otherPlant.getName());
    }

//    endregion

// region get/set

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public LocalDate getPlantedOn() {
        return plantedOn;
    }

    public void setPlantedOn(LocalDate plantedOn) {
        this.plantedOn = plantedOn;
    }

    public LocalDate getLastWatering() {
        return lastWatering;
    }

    public void setLastWatering(LocalDate lastWatering) throws PlantException {
        if (lastWatering.isBefore(plantedOn)) {
            throw new PlantException("Date of last watering cannot be before date of planting!");
        }
        this.lastWatering = lastWatering;
    }

    public int getFrequencyOfWatering() {
        return frequencyOfWatering;
    }

    public void setFrequencyOfWatering(int frequencyOfWatering) throws PlantException {
        if (frequencyOfWatering <= 0) {
            throw new PlantException("Frequency of watering must be higher than 0!");
        }
        this.frequencyOfWatering = frequencyOfWatering;
    }

//    endregion

}
