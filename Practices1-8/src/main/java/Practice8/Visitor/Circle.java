package Practice8.Visitor;

public class Circle implements Shape {
    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}
