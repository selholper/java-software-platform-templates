package Practice6.BuilderPattern;

public final class CarBuilder implements Builder {
    private Car car;

    @Override
    public void reset() {
        car = new Car();
    }

    @Override
    public void setYear(int year) {
        car.setYear(year);
    }

    @Override
    public void setModel(String model) {
        car.setModel(model);
    }

    @Override
    public void setColor(String color) {
        car.setColor(color);
    }

    @Override
    public void setBrand(String brand) {
        car.setBrand(brand);
    }

    public Car build() {
        return car;
    }
}
