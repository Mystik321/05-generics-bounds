package ohm.softa.a05.model;

import ohm.softa.a05.collections.SimpleList;
import ohm.softa.a05.collections.SimpleListImpl;

public class PlantBed<T extends Plant> {

    private SimpleList<T> plants;

    public PlantBed() {
        plants = new SimpleListImpl<>();
    }

    public void add(T plant) {
        plants.add((plant));
    }

    public int size() {
        return plants.size();
    }

    public void remove(T p) {

        SimpleList<T> result = new SimpleListImpl<>();

        for (T plant: plants) {
            if (!plant.equals(p))
                result.add(plant);
        }

        plants = result;
    }

    public SimpleList<T> getPlants() {
        return plants.map(p -> p);
    }

    public SimpleList<T> getPlantsByColor(PlantColor color) {
        return plants.filter(p -> p.getColor().equals(color));
    }
}
