package Practice6.AbstractFactoryMethod.Product;

import Practice6.FactoryMethod.Product.Vehicle;

public class UberMotorcycle extends AbstractMotorcycle {

    @Override
    public void ride() {
        System.out.println("Uber motorcycle is riding");
    }

    @Override
    public void park() {
        System.out.println("Uber motorcycle is parking");
    }
}
