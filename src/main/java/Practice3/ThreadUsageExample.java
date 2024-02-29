package Practice3;

import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ThreadUsageExample {
    private static volatile int buf;
    private static final Lock lock = new ReentrantLock();
    private static final ReadWriteLock readWriteLock = new ReentrantReadWriteLock();
    private static final Semaphore semaphore = new Semaphore(1, true);


    private synchronized static void increment() {
        try {
            semaphore.acquire();
            buf++;
            semaphore.release();
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }

    }

    private synchronized static void decrement() {
        readWriteLock.writeLock().lock();
        buf--;
        readWriteLock.writeLock().unlock();
    }

    public synchronized void print() {
        synchronized(this) {
            System.out.println(1);
            lock.lock();
            System.out.println(2);
            System.out.println(3);
            lock.unlock();
        }
    }

    public static void main(String[] args) throws Exception {
        buf = 0;

        Thread one = new Thread(() -> {
            for (int i = 0; i < 1e7; ++i) {
                increment();
            }
        });

        Thread two = new Thread(() -> {
            for (int i = 0; i < 1e7; ++i) {
                decrement();
            }
        });

        one.start();
        one.join();
        two.start();
        two.join();

        System.out.println(buf);
    }
}
