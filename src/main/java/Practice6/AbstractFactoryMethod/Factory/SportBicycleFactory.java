package Practice6.AbstractFactoryMethod.Factory;

import Practice6.AbstractFactoryMethod.Product.SportBicycle;
import Practice6.AbstractFactoryMethod.Product.Vehicle;

public class SportBicycleFactory extends AbstractBicycleFactory {
    @Override
    public Vehicle createVehicle() {
        return new SportBicycle();
    }
}
