package Practice1;

import java.util.function.Predicate;
import java.util.regex.Pattern;

public class EmailValidator implements Predicate<String> {

    private static final String REGEX = "^([a-zA-Z0-9._-]+@[a-zA-Z0-9._-]+\\.[a-zA-Z0-9_-]+)$";

    @Override
    public boolean test(String email) {
        return Pattern.matches(REGEX, email);
    }
}
