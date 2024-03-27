package Practice7.Component;

import java.util.ArrayList;
import java.util.List;

public class Composite implements Component {
    List<Component> children = new ArrayList<>();

    @Override
    public void operation() {
        System.out.println("Composite operation call");
        for (Component component : children) {
            component.operation();
        }
    }

    @Override
    public void add(Component component) {
        children.add(component);
    }

    @Override
    public void remove(Component component) {
        children.remove(component);
    }
}
