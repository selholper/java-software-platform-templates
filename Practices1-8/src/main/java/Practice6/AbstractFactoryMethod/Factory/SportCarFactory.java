package Practice6.AbstractFactoryMethod.Factory;

import Practice6.AbstractFactoryMethod.Product.SportCar;
import Practice6.AbstractFactoryMethod.Product.Vehicle;

public class SportCarFactory extends AbstractCarFactory {
    @Override
    public Vehicle createVehicle() {
        return new SportCar();
    }
}
