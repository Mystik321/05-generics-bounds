package ohm.softa.a05.model;

public class Flower extends Plant {

    private PlantColor flowerColor;

    public Flower(String name, String family, double height, PlantColor flowerColor) {
        super( name, family, height);
        if (flowerColor == PlantColor.GREEN)
            throw new IllegalArgumentException();
        this.flowerColor = flowerColor;
    }

    @Override
    public PlantColor getColor() {
        return flowerColor;
    }
}