package Practice6.BuilderPattern;

public class Director {
    public void constructSportCar(Builder builder) {
        builder.reset();
        builder.setBrand("Porsche");
        builder.setModel("Panamera");
        builder.setColor("White");
        builder.setYear(2024);
    }

    public void constructUberCar(Builder builder) {
        builder.reset();
        builder.setBrand("Volkswagen");
        builder.setModel("Passat");
        builder.setColor("Silver");
        builder.setYear(2023);
    }
}
