package hrakuun.ja.lekce5.ukol;

import java.time.LocalDate;

public class Plant {

//    region variables

    private String name;
    private String notes;
    private LocalDate plantedOn;
    private LocalDate lastWatering;
    private int frequencyOfWatering;

//    endregion
//    region constructors
    public Plant(String name, String notes, LocalDate plantedOn, LocalDate lastWatering, int frequencyOfWatering){
        this.name = name;
        this.notes = notes;
        this.plantedOn = plantedOn;
        this.lastWatering = lastWatering;
        setFrequencyOfWatering(frequencyOfWatering);
    }
    public Plant(String name, LocalDate plantedOn, int frequencyOfWatering){
        this(name,"",plantedOn,LocalDate.now(),frequencyOfWatering);
    }
    public Plant(String name){
        this(name,LocalDate.now(),7);
    }

//    endregion

//    region methods

    public String getWateringInfo(){
        LocalDate nextWatering = lastWatering.plusDays(frequencyOfWatering);
        return "Název: "+name+", Poslední zálivka: "+lastWatering+", Příští zálivka: "+nextWatering+".";
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

    public void setLastWatering(LocalDate lastWatering) {
        this.lastWatering = lastWatering;
    }

    public int getFrequencyOfWatering() {
        return frequencyOfWatering;
    }

    public void setFrequencyOfWatering(int frequencyOfWatering) {
        this.frequencyOfWatering = frequencyOfWatering;
    }

//    endregion
}
