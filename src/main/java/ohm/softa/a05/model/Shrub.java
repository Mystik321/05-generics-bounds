package ohm.softa.a05.model;

public class Shrub extends Plant {

    public Shrub(String name, String family, double height) {
        super(name, family, height);
    }

    @Override
    public PlantColor getColor() {
        return PlantColor.GREEN;
    }
}
