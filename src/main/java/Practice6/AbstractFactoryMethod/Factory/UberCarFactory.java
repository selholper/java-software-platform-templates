package Practice6.AbstractFactoryMethod.Factory;


import Practice6.AbstractFactoryMethod.Product.UberCar;
import Practice6.AbstractFactoryMethod.Product.Vehicle;

public class UberCarFactory extends AbstractCarFactory {
    @Override
    public Vehicle createVehicle() {
        return new UberCar();
    }
}
