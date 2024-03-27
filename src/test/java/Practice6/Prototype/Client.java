package Practice6.Prototype;

public class Client {
    public static void main(String[] args) {
        Shape circle = new Circle(1.5, 0, 0, "red");
        Shape circleCopied = circle.clone();
        System.out.println(circle +  "\n" + circleCopied);

        Shape rectangle = new Rectangle(1.3, 2.4, 0.1, -12.3, "green");
        Shape rectangleCopied = rectangle.clone();
        System.out.println(rectangle + "\n" + rectangleCopied);
    }
}
