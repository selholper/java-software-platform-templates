package Practice5;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class TestSingletonBillPugh {
    @Test
    public void testSingleBillPughClass_shouldWorkCorrectly() {
        SingletonBillPugh singleton1 = SingletonBillPugh.getInstance();
        SingletonBillPugh singleton2 = SingletonBillPugh.getInstance();

        assertThat(singleton1).isSameAs(singleton2);
    }
}
