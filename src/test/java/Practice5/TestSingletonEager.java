package Practice5;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class TestSingletonEager {
    @Test
    public void testSingletonEagerClass_shouldWorkCorrectly() {
        SingletonEager singleton1 = SingletonEager.getInstance();
        SingletonEager singleton2 = SingletonEager.getInstance();

        assertThat(singleton1).isSameAs(singleton2);
    }
}
