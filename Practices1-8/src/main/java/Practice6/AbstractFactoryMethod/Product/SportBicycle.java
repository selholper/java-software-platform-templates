package Practice6.AbstractFactoryMethod.Product;

import Practice6.FactoryMethod.Product.Vehicle;

public class SportBicycle extends AbstractBicycle {

    @Override
    public void ride() {
        System.out.println("Sport bicycle is riding");
    }

    @Override
    public void park() {
        System.out.println("Sport bicycle is parking");
    }
}
