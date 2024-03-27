package Practice6.FactoryMethod.Product;

public class Motorcycle implements Vehicle {

    @Override
    public void ride() {
        System.out.println("Motorcycle is riding");
    }

    @Override
    public void park() {
        System.out.println("Motorcycle is parking");
    }
}
