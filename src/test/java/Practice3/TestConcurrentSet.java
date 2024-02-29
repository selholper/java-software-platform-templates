package Practice3;

import org.junit.jupiter.api.Test;
import java.util.concurrent.CountDownLatch;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestConcurrentSet {
    @Test
    void testConcurrentSetClass_shouldBeThreadSafe() throws InterruptedException {
        ConcurrentSet<String> concurrentSet = new ConcurrentSet<>();

        int numberOfThreads = 10;
        int iterationsPerThread = 1000;
        CountDownLatch startLatch = new CountDownLatch(1);
        CountDownLatch endLatch = new CountDownLatch(numberOfThreads);
        for (int i = 0; i < numberOfThreads; i++) {
            final int n = i;
            new Thread(() -> {
                try {
                    startLatch.await();

                    for (int j = n * iterationsPerThread; j < (n + 1) * iterationsPerThread; j++) {
                        concurrentSet.remove("Element" + (j - 1));
                        concurrentSet.add("Element" + j);
                    }

                    endLatch.countDown();
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }).start();
        }
        startLatch.countDown();
        endLatch.await();

        assertEquals(numberOfThreads, concurrentSet.size());
    }
}
