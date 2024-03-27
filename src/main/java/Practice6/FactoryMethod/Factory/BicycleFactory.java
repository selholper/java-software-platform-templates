package Practice6.FactoryMethod.Factory;

import Practice6.FactoryMethod.Product.Bicycle;
import Practice6.FactoryMethod.Product.Vehicle;

public class BicycleFactory implements VehicleFactory {

    @Override
    public Vehicle createVehicle() {
        return new Bicycle();
    }
}
