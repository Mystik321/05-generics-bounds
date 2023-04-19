package ohm.softa.a05.tests.utils;

import ohm.softa.a05.collections.SimpleList;
import ohm.softa.a05.model.*;
import ohm.softa.a05.utils.PlantBedUtility;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PlantBedUtilityTests {

    private PlantBed<Flower> flowerBed;

    @BeforeEach
    void setup() {
        flowerBed = new PlantBed<>();

        flowerBed.add(new Flower("Rosa", "Golden Celebration", 0.4, PlantColor.YELLOW));
        flowerBed.add(new Flower("Rosa", "Abracadabra", 0.5, PlantColor.RED));
        flowerBed.add(new Flower("Rosa", "Golden Celebration", 0.3, PlantColor.YELLOW));
        flowerBed.add(new Flower("Rosa", "Golden Celebration", 0.35, PlantColor.YELLOW));
        flowerBed.add(new Flower("Rosa", "Abracadabra", 0.35, PlantColor.RED));
        flowerBed.add(new Flower("Rosa", "Rosa chinensis", 0.35, PlantColor.ORANGE));
    }

    @Test
    void testSplitByBedByColorResultingSize() {
        Map<PlantColor, SimpleList<Flower>> split = PlantBedUtility.splitBedByColor(flowerBed);
        assertEquals(3, split.keySet().size());
    }

    @Test
    void testSplitByBedByColorPureness() {
        Map<PlantColor, SimpleList<Flower>> split = PlantBedUtility.splitBedByColor(flowerBed);
        for (Flower f : split.get(PlantColor.YELLOW)) {
            assertEquals(PlantColor.YELLOW, f.getColor());
        }
    }

    @Test
    void testSplitByBedByColorPureness2() {
        Map<PlantColor, SimpleList<? extends Flower>> split = PlantBedUtility.splitBedByColor2(flowerBed);
        for (Flower f : split.get(PlantColor.YELLOW)) {
            assertEquals(PlantColor.YELLOW, f.getColor());
        }
    }

    @Test
    void testRepot1() {
        PlantBed<Plant> output1 = new PlantBed<>();
        PlantBed<Flower> output2 = new PlantBed<>();
//         PlantBed<Shrub> output3 = new PlantBed<>();
        PlantBed<Shrub> input4 = new PlantBed<>();

        PlantBedUtility.repot(flowerBed, PlantColor.YELLOW, output1);
        PlantBedUtility.repot(flowerBed, PlantColor.YELLOW, output2);
//         PlantBedUtility.repot(flowerBed, PlantColor.YELLOW, output3); // Das klappt nicht!
        PlantBedUtility.repot(input4, PlantColor.YELLOW, output1);
    }
}
