package Practice6.AbstractFactory;

import Practice6.AbstractFactoryMethod.Factory.*;
import Practice6.AbstractFactoryMethod.Product.Vehicle;

public class Client {
    public static void main(String[] args) {
        AbstractBicycleFactory bicycleFactory = new SportBicycleFactory();
        AbstractCarFactory carFactory = new UberCarFactory();
        AbstractMotorcycleFactory motorcycleFactory =  new SportMotorcycleFactory();

        Vehicle sportBicycle = bicycleFactory.createVehicle();
        Vehicle uberCar = carFactory.createVehicle();
        Vehicle sportMotorcycle = motorcycleFactory.createVehicle();

        sportBicycle.ride();
        uberCar.park();
        sportMotorcycle.park();
    }
}
