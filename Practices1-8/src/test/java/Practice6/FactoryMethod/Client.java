package Practice6.FactoryMethod;

import Practice6.FactoryMethod.Factory.BicycleFactory;
import Practice6.FactoryMethod.Factory.CarFactory;
import Practice6.FactoryMethod.Factory.MotorcycleFactory;
import Practice6.FactoryMethod.Factory.VehicleFactory;
import Practice6.FactoryMethod.Product.Vehicle;

public class Client {
    public static void main(String[] args) {
        VehicleFactory bicycleFactory = new BicycleFactory();
        VehicleFactory carFactory = new CarFactory();
        VehicleFactory motorcycleFactory = new MotorcycleFactory();

        Vehicle bicycle = bicycleFactory.createVehicle();
        Vehicle car = carFactory.createVehicle();
        Vehicle motorcycle = motorcycleFactory.createVehicle();

        bicycle.ride();
        bicycle.park();

        car.ride();
        car.park();

        motorcycle.ride();
        motorcycle.park();
    }
}
