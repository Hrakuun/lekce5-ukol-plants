package hrakuun.ja.lekce5.ukol;

import java.util.Comparator;

public class PlantWateringComparator implements Comparator<Plant> {


    @Override
    public int compare(Plant o1, Plant o2) {
        return o1.getLastWatering().compareTo(o2.getLastWatering());
    }
}
