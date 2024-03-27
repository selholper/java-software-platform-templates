package Practice6.AbstractFactoryMethod.Product;

import Practice6.FactoryMethod.Product.Vehicle;

public class UberBicycle extends AbstractCar {
    @Override
    public void ride() {
        System.out.println("Uber bicycle is riding");
    }

    @Override
    public void park() {
        System.out.println("Uber bicycle is parking");
    }
}
