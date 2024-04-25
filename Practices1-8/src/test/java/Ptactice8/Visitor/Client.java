package Ptactice8.Visitor;

import Practice8.Visitor.*;

public class Client {
    public static void main(String[] args) {
        Shape square = new Square();
        Shape circle = new Circle();

        Visitor nameGetter = new NameGetter();

        square.accept(nameGetter);
        circle.accept(nameGetter);
    }
}
