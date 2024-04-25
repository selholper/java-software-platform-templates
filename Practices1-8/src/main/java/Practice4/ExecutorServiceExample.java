package Practice4;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorServiceExample {
    public static void main(String[] args) {
        try (ExecutorService executorService = Executors.newSingleThreadExecutor()) {
            executorService.submit(() -> {
                try {
                    Thread.sleep(200);
                } catch (InterruptedException e) {
                    System.out.println(e.getMessage());
                }
                System.out.println("We run it!");
            });

            executorService.submit(() -> System.out.println("Start"));
        }

        try (ExecutorService executorService = Executors.newFixedThreadPool(2)) {
            executorService.submit(() -> {
                try {
                    Thread.sleep(200);
                } catch (InterruptedException e) {
                    System.out.println(e.getMessage());
                }
                System.out.println("We run it!");
            });

            executorService.submit(() -> System.out.println("Start"));
        }
    }
}
