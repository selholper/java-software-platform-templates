package Practice7.Component;

public class Leaf implements Component {
    private final String name;

    public Leaf(String name) {
        this.name = name;
    }

    @Override
    public void operation() {
        System.out.println("Call operation on " + name);
    }

    @Override
    public void add(Component component) {
    }

    @Override
    public void remove(Component component) {
    }
}
