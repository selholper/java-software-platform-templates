package Practice6.AbstractFactoryMethod.Product;

import Practice6.FactoryMethod.Product.Vehicle;

public class SportCar extends AbstractCar {
    @Override
    public void ride() {
        System.out.println("Sport car is riding");
    }

    @Override
    public void park() {
        System.out.println("Sport car is parking");
    }
}
