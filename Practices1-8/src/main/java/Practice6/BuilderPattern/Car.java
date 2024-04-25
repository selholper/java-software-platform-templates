package Practice6.BuilderPattern;

import lombok.Setter;

@Setter
public class Car {
    private int year;
    private String model;
    private String color;
    private String brand;

    @Override
    public String toString() {
        return String.format("Car={brand=%s, model=%s, color=%s, year=%d}", brand, model, color, year);
    }
}
