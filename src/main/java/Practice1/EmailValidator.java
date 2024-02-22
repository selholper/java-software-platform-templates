package Practice1;

import java.util.function.Predicate;
import java.util.regex.Pattern;

// Класс, реализующий интерфейс Predicate
public class EmailValidator implements Predicate<String> {

    // Регулярное выражение, проверяющее является ли строка email-адресом
    private static final String REGEX = "^([a-zA-Z0-9._-]+@[a-zA-Z0-9._-]+\\.[a-zA-Z0-9_-]+)$";

    @Override
    public boolean test(String email) {
        // Проверяем строку, используя класс Pattern
        return Pattern.matches(REGEX, email);
    }
}
