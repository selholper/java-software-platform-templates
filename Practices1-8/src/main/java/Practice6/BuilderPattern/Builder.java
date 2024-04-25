package Practice6.BuilderPattern;

public sealed interface Builder permits CarBuilder {
    void reset();
    void setYear(int year);
    void setModel(String model);
    void setColor(String color);
    void setBrand(String brand);
}
