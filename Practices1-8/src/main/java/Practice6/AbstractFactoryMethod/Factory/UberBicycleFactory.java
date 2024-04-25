package Practice6.AbstractFactoryMethod.Factory;

import Practice6.AbstractFactoryMethod.Product.UberBicycle;
import Practice6.AbstractFactoryMethod.Product.Vehicle;

public class UberBicycleFactory extends AbstractBicycleFactory {

    @Override
    public Vehicle createVehicle() {
        return new UberBicycle();
    }
}
