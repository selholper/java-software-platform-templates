package Practice2;

import lombok.experimental.UtilityClass;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.Iterator;

// Приложение для работы с классом Human
@UtilityClass
public final class HumanUtils {

    // Метод для создания списка из объектов класса Human
    public static List<Human> createHumanList(Human ... humans) {
        Objects.requireNonNull(humans);

        List<Human> humanList = new ArrayList<>(humans.length);
        Collections.addAll(humanList, humans);

        return humanList;
    }

    // Метод для применения изменений к списку объектов класса  Human
    public static void applyModificationsToHumanList(List<Human> humanList) {
        Objects.requireNonNull(humanList);

        System.out.println("Original list:\n{");
        for (int i = 0; i < humanList.size() - 1; ++i) {
            System.out.println("\t" + humanList.get(i) + ",");
        }
        System.out.println("\t" + humanList.getLast());
        System.out.println("}\n");

        humanList = humanList
            .stream()
            .sorted((o1, o2) -> Character.compare(o2.firstName().charAt(1), o1.firstName().charAt(1)))
            .toList();

        System.out.println("Original list after sorting by second letter of name in reverse order:\n{");
        Iterator<Human> humanListIterator = humanList.iterator();
        if (humanListIterator.hasNext()) {
            System.out.print("\t" + humanListIterator.next());
        }
        while (humanListIterator.hasNext()) {
            System.out.print(",\n\t" + humanListIterator.next());
        }
        System.out.println("\n}\n");

        humanList = humanList
            .stream()
            .filter(o -> o.weight() > 60)
            .toList();

        System.out.println("Previous list after filtration by weight more than 60:\n{");
        humanListIterator = humanList.iterator();
        if (humanListIterator.hasNext()) {
            System.out.print("\t" + humanListIterator.next());
        }
        while (humanListIterator.hasNext()) {
            System.out.print(",\n\t" + humanListIterator.next());
        }
        System.out.println("\n}\n");

        long product = humanList
            .stream()
            .map(human -> (long)human.age())
            .reduce(1L, (p, age) -> p * age);

        System.out.println("Product of all ages of the previous list: " + product);
    }
}
