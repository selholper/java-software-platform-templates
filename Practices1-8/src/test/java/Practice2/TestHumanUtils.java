package Practice2;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

public class TestHumanUtils {

    public static void main(String[] args) {
        List<Human> humanList = HumanUtils.createHumanList(
            new Human(
                22,
                "Ilya",
                "Orlov",
                LocalDate.of(2001, Month.JULY, 21),
                76
            ),

            new Human(
                12,
                "Ivan",
                "Popov",
                LocalDate.of(2012, Month.JANUARY, 1),
                61
            ),

            new Human(
                19,
                "Darya",
                "Zimina",
                LocalDate.of(2004, Month.AUGUST, 12),
                45
            ),

            new Human(
                30,
                "Egor",
                "Titov",
                LocalDate.of(1993, Month.DECEMBER, 9),
                93
            ),

            new Human(
                90,
                "Denis",
                "Borisov",
                LocalDate.of(1933, Month.DECEMBER, 12),
                72
            )
        );

        HumanUtils.applyModificationsToHumanList(humanList);
    }
}
