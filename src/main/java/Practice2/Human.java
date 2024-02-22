package Practice2;

import java.time.LocalDate;

// Класс (запись) человека
public record Human(
        int age,
        String firstName,
        String lastName,
        LocalDate birthDate,
        int weight
) {

    // Переопределяем метод для вывода объекта Human в консоль
    @Override
    public String toString() {
        return String.format(
            "Human = {age: %d, firstName: %s, lastName: %s, birthDate: %s, weight: %d}",
            age(),
            firstName(),
            lastName(),
            birthDate().toString(),
            weight()
        );
    }
}
