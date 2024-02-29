package Practice3;

import org.jetbrains.annotations.NotNull;

import java.lang.reflect.Array;
import java.util.Set;
import java.util.HashSet;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.concurrent.Semaphore;

// Потокобезопасная реализация интерфейса Set с использованием Semaphore
public class ConcurrentSet<T> implements Set<T> {
    // Внутреннее множество для хранения элементов
    private final Set<T> set = new HashSet<>();
    // Семафор для контроля доступа к внутреннему множеству
    private final Semaphore semaphore = new Semaphore(1, true);

    // Переопределенный метод для получения размера множества в потокобезопасной манере
    @Override
    public int size() {
        try {
            semaphore.acquire();
            int size = set.size();
            semaphore.release();

            return size;
        } catch (InterruptedException e) {
            // Восстановление прерванного статуса
            Thread.currentThread().interrupt();

            return 0;
        }
    }

    // Переопределенный метод для проверки, пусто ли множество в потокобезопасной манере
    @Override
    public boolean isEmpty() {
        try {
            semaphore.acquire();
            boolean isEmpty = set.isEmpty();
            semaphore.release();

            return isEmpty;
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();

            return true;
        }
    }

    // Переопределенный метод для проверки, содержит ли множество заданный объект в потокобезопасной манере
    @Override
    public boolean contains(Object object) {
        try {
            semaphore.acquire();
            boolean contains = set.contains(object);
            semaphore.release();

            return contains;
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();

            return false;
        }
    }

    // Переопределенный метод для получения итератора множества в потокобезопасной манере
    @Override
    public @NotNull Iterator<T> iterator() {
        try {
            semaphore.acquire();
            Iterator<T> iterator = set.iterator();
            semaphore.release();

            return iterator;
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();

            return Collections.emptyIterator();
        }
    }

    // Переопределенный метод для преобразования множества в массив в потокобезопасной манере
    @Override
    public Object @NotNull [] toArray() {
        try {
            semaphore.acquire();
            Object[] array = set.toArray();
            semaphore.release();

            return array;
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();

            return new Object[0];
        }
    }

    // Переопределенный метод для преобразования множества в массив с указанным типом в потокобезопасной манере
    @SuppressWarnings("unchecked")
    @Override
    public <U> U @NotNull [] toArray(U @NotNull [] a) {
        try {
            semaphore.acquire();
            U[] customArray = set.toArray(a);
            semaphore.release();

            return customArray;
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();

            // Создание пустого массива указанного типа
            return (U[]) Array.newInstance(a.getClass().getComponentType(), 0);
        }
    }

    // Переопределенный метод для добавления элемента в множество в потокобезопасной манере
    @Override
    public boolean add(T v) {
        try {
            semaphore.acquire();
            boolean add = set.add(v);
            semaphore.release();

            return add;
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();

            return false;
        }
    }

    // Переопределенный метод для удаления элемента из множества в потокобезопасной манере
    @Override
    public boolean remove(Object object) {
        try {
            semaphore.acquire();
            boolean remove = set.remove(object);
            semaphore.release();

            return remove;
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();

            return false;
        }
    }

    // Переопределенный метод для проверки, содержит ли множество все элементы из заданной коллекции в потокобезопасной манере
    @Override
    public boolean containsAll(@NotNull Collection<?> c) {
        try {
            semaphore.acquire();
            boolean containsAll = set.containsAll(c);
            semaphore.release();

            return containsAll;
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();

            return false;
        }
    }

    // Переопределенный метод для добавления всех элементов из заданной коллекции в множество в потокобезопасной манере
    @Override
    public boolean addAll(@NotNull Collection<? extends T> c) {
        try {
            semaphore.acquire();
            boolean addedAll = set.addAll(c);
            semaphore.release();

            return addedAll;
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();

            return false;
        }
    }

    // Переопределенный метод для оставления только тех элементов в множестве, которые присутствуют в заданной коллекции в потокобезопасной манере
    @Override
    public boolean retainAll(@NotNull Collection<?> c) {
        try {
            semaphore.acquire();
            boolean retainedAll = set.retainAll(c);
            semaphore.release();

            return retainedAll;
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();

            return false;
        }
    }

    // Переопределенный метод для удаления всех элементов из множества, которые присутствуют в заданной коллекции в потокобезопасной манере
    @Override
    public boolean removeAll(@NotNull Collection<?> c) {
        try {
            semaphore.acquire();
            boolean removedAll = set.removeAll(c);
            semaphore.release();

            return removedAll;
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();

            return false;
        }
    }

    // Переопределенный метод для очистки всех элементов из множества в потокобезопасной манере
    @Override
    public void clear() {
        try {
            semaphore.acquire();
            set.clear();
            semaphore.release();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
