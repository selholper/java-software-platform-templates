package Practice6.AbstractFactoryMethod.Factory;


import Practice6.AbstractFactoryMethod.Product.UberMotorcycle;
import Practice6.AbstractFactoryMethod.Product.Vehicle;

public class UberMotorcycleFactory extends AbstractMotorcycleFactory {
    @Override
    public Vehicle createVehicle() {
        return new UberMotorcycle();
    }
}
