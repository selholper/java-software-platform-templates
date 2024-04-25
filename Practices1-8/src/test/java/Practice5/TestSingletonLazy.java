package Practice5;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class TestSingletonLazy {
    @Test
    public void testSingletonLazyClass_shouldWorkCorrectly() {
        SingletonLazy singleton1 = SingletonLazy.getInstance();
        SingletonLazy singleton2 = SingletonLazy.getInstance();

        assertThat(singleton1).isSameAs(singleton2);
    }
}
