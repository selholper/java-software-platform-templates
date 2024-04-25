package Practice6.FactoryMethod.Product;

public class Bicycle implements Vehicle {
    @Override
    public void ride() {
        System.out.println("Bicycle is riding");
    }

    @Override
    public void park() {
        System.out.println("Bicycle is parking");
    }
}
