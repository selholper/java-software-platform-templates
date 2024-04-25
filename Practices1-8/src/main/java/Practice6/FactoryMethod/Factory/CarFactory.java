package Practice6.FactoryMethod.Factory;

import Practice6.FactoryMethod.Product.Car;
import Practice6.FactoryMethod.Product.Vehicle;

public class CarFactory implements VehicleFactory {

    @Override
    public Vehicle createVehicle() {
        return new Car();
    }
}
