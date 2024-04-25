package Practice6.AbstractFactoryMethod.Factory;


import Practice6.AbstractFactoryMethod.Product.SportMotorcycle;
import Practice6.AbstractFactoryMethod.Product.Vehicle;

public class SportMotorcycleFactory extends AbstractMotorcycleFactory {
    @Override
    public Vehicle createVehicle() {
        return new SportMotorcycle();
    }
}
