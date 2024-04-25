package Practice4;

import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class TestCustomServiceExecutor {
    @Test
    void testCustomServiceExecutorTask_shouldWorkCorrectly() {
        final List<Integer> a = new ArrayList<>();

        try (CustomServiceExecutor customServiceExecutor = new CustomServiceExecutor(2)) {
            customServiceExecutor.submit(() -> {
               try {
                   Thread.sleep(300);
                   a.add(1);
               } catch (InterruptedException e) {
                   Thread.currentThread().interrupt();
               }
            });

            customServiceExecutor.submit(() -> a.add(2));
        }

        assertThat(a).containsExactlyElementsOf(List.of(2, 1));

        try (CustomServiceExecutor customServiceExecutor = new CustomServiceExecutor(1)) {
            customServiceExecutor.submit(() -> {
                try {
                    Thread.sleep(300);
                    a.add(1);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            });

            customServiceExecutor.submit(() -> a.add(2));
        }

        assertThat(a).containsExactlyElementsOf(List.of(2, 1, 1, 2));
    }
}
