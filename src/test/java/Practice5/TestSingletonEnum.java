package Practice5;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class TestSingletonEnum {
    @Test
    public void testSingletonEnum_shouldWorkCorrectly() {
        SingletonEnum singleton1 = SingletonEnum.INSTANCE;
        SingletonEnum singleton2 = SingletonEnum.INSTANCE;

        assertThat(singleton1).isSameAs(singleton2);
    }
}
