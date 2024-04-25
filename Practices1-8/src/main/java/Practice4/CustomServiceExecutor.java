package Practice4;

import org.jetbrains.annotations.NotNull;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.*;

// Пользовательская реализация интерфейса ExecutorService
public class CustomServiceExecutor implements ExecutorService {
    // Подложка ThreadPoolExecutor для выполнения задач
    private final ThreadPoolExecutor executorService;

    // Конструктор для инициализации ThreadPoolExecutor с указанным размером пула
    public CustomServiceExecutor(int poolSize) {
        executorService = new ThreadPoolExecutor(poolSize, poolSize,
                0L, TimeUnit.MILLISECONDS,
                new LinkedBlockingQueue<>());
    }

    // Остановить выполнение службы, позволяя ранее отправленным задачам выполниться
    @Override
    public void shutdown() {
        executorService.shutdown();
    }

    // Попытка остановить все активно выполняющиеся задачи, прервать обработку ожидающих задач и вернуть список задач, ожидающих выполнения
    @NotNull
    @Override
    public List<Runnable> shutdownNow() {
        return executorService.shutdownNow();
    }

    // Проверить, было ли завершено выполнение Executor
    @Override
    public boolean isShutdown() {
        return executorService.isShutdown();
    }

    // Проверить, завершено ли выполнение всех задач после запроса на завершение
    @Override
    public boolean isTerminated() {
        return executorService.isTerminated();
    }

    // Заблокировать выполнение до завершения всех задач после запроса на завершение, или до истечения времени, или до прерывания текущего потока, что произойдет раньше
    @Override
    public boolean awaitTermination(long timeout, @NotNull TimeUnit unit) throws InterruptedException {
        return executorService.awaitTermination(timeout, unit);
    }

    // Подать на выполнение задачу типа Callable и вернуть Future, представляющий ожидаемые результаты задачи
    @NotNull
    @Override
    public <T> Future<T> submit(@NotNull Callable<T> task) {
        return executorService.submit(task);
    }

    // Подать на выполнение задачу типа Runnable и вернуть Future, представляющий эту задачу с указанным результатом
    @NotNull
    @Override
    public <T> Future<T> submit(@NotNull Runnable task, T result) {
        return executorService.submit(task, result);
    }

    // Подать на выполнение задачу типа Runnable и вернуть Future, представляющий эту задачу
    @NotNull
    @Override
    public Future<?> submit(@NotNull Runnable task) {
        return executorService.submit(task);
    }

    // Выполнить все задачи из коллекции, возвращая список Future с их статусами и результатами после завершения всех задач
    @NotNull
    @Override
    public <T> List<Future<T>> invokeAll(@NotNull Collection<? extends Callable<T>> tasks)
            throws InterruptedException {
        return executorService.invokeAll(tasks);
    }

    // Выполнить все задачи из коллекции, возвращая список Future с их статусами и результатами после завершения всех задач или по истечении таймаута
    @NotNull
    @Override
    public <T> List<Future<T>> invokeAll(@NotNull Collection<? extends Callable<T>> tasks, long timeout,
                                         @NotNull TimeUnit unit) throws InterruptedException {
        return executorService.invokeAll(tasks, timeout, unit);
    }

    // Выполнить задачи из коллекции и вернуть результат одной из них, которая завершилась успешно (без выброса исключения), если таковая имеется
    @NotNull
    @Override
    public <T> T invokeAny(@NotNull Collection<? extends Callable<T>> tasks)
            throws InterruptedException, ExecutionException {
        return executorService.invokeAny(tasks);
    }

    // Выполнить задачи из коллекции и вернуть результат одной из них, которая завершилась успешно (без выброса исключения), или дождаться, если необходимо, указанного таймаута
    @Override
    public <T> T invokeAny(@NotNull Collection<? extends Callable<T>> tasks, long timeout, @NotNull TimeUnit unit)
            throws InterruptedException, ExecutionException, TimeoutException {
        return executorService.invokeAny(tasks, timeout, unit);
    }

    // Выполнить переданную команду в будущем
    @Override
    public void execute(@NotNull Runnable command) {
        executorService.execute(command);
    }
}
