package Practice6.AbstractFactoryMethod.Product;

public class SportMotorcycle extends AbstractMotorcycle {
    @Override
    public void ride() {
        System.out.println("Sport motorcycle is riding");
    }

    @Override
    public void park() {
        System.out.println("Sport motorcycle is parking");
    }
}
