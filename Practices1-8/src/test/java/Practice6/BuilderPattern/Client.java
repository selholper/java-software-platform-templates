package Practice6.BuilderPattern;

public class Client {
    public static void main(String[] s) {
        Director director = new Director();
        CarBuilder carBuilder = new CarBuilder();

        director.constructUberCar(carBuilder);
        Car uberCar = carBuilder.build();
        System.out.println(uberCar);

        director.constructSportCar(carBuilder);
        Car sportCar = carBuilder.build();
        System.out.println(sportCar);
    }
}
