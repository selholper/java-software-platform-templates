package Practice3;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class TestSynchronizedMap {
    @Test
    public void testSynchronizedMapClass_shouldBeThreadSafe() throws Exception {
        Map<Integer, Integer> synchronizedMap = new SynchronizedMap<>();
        Map<Integer, Integer> map = new HashMap<>();

        int key = 1;
        int numThreads = 5;
        Thread[] threads = new Thread[numThreads];
        for (int i = 0; i < numThreads; i++) {
            threads[i] = new Thread(() -> {
                for (int j = 0; j < 1000; j++) {
                    synchronizedMap.compute(key, (k, v) -> (v == null) ? 1 : v + 1);
                    map.compute(key, (k, v) -> (v == null) ? 1 : v + 1);
                }
            });
        }

        for (Thread thread : threads) {
            thread.start();
        }
        for (Thread thread : threads) {
            thread.join();
        }

        assertThat(synchronizedMap.get(key)).isEqualTo(5000);
        assertThat(map.get(key)).isNotEqualTo(5000);
    }
}
