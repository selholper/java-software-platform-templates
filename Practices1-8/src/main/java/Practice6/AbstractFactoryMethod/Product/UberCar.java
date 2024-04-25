package Practice6.AbstractFactoryMethod.Product;

import Practice6.FactoryMethod.Product.Vehicle;

public class UberCar extends AbstractBicycle{
    @Override
    public void ride() {
        System.out.println("Uber car is riding");
    }

    @Override
    public void park() {
        System.out.println("Uber car is parking");
    }
}
