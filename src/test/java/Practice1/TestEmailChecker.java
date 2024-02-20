package Practice1;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import static org.assertj.core.api.Assertions.assertThat;

public class TestEmailChecker {
    @ParameterizedTest
    @ValueSource(
        strings = {"example@domain.org", "123@as.ru", "sadjkfhsd@jkadsfh.cm"}
    )
    public void testMethodTest_whenEmailIsCorrect_shouldReturnTrue(String email) {
        assertThat(
            new EmailChecker().test(email)
        ).isTrue();
    }

    @ParameterizedTest
    @ValueSource(
        strings = {"123@.ru", "justtext", "@mail.ru"}
    )
    public void testMethodTest_whenEmailIsIncorrect_shouldReturnFalse(String email) {
        assertThat(
            new EmailChecker().test(email)
        ).isFalse();
    }
}
