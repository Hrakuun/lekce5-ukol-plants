package hrakuun.ja.lekce5.ukol;

import java.util.ArrayList;
import java.util.List;

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
}
