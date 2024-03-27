package Practice6.FactoryMethod.Product;

public class Car implements Vehicle {
    @Override
    public void ride() {
        System.out.println("Car is riding");
    }

    @Override
    public void park() {
        System.out.println("Car is parking");
    }
}
