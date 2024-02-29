package Practice3;

import org.jetbrains.annotations.NotNull;

import java.util.*;
import java.util.function.BiFunction;

// Потокобезопасная реализация интерфейса Map с использованием synchronized
public class SynchronizedMap<K, V> implements Map<K, V> {

    // Основной объект, представляющий собой синхронизированную обертку вокруг HashMap
    private final Map<K, V> synchronizedMap = new HashMap<>();

    // Переопределенные методы интерфейса Map с синхронизированным доступом

    @Override
    public synchronized int size() {
        return synchronizedMap.size();
    }

    @Override
    public synchronized boolean isEmpty() {
        return synchronizedMap.isEmpty();
    }

    @Override
    public synchronized boolean containsKey(Object key) {
        return synchronizedMap.containsKey(key);
    }

    @Override
    public synchronized boolean containsValue(Object value) {
        return synchronizedMap.containsValue(value);
    }

    @Override
    public synchronized V get(Object key) {
        return synchronizedMap.get(key);
    }

    @Override
    public synchronized V getOrDefault(Object key, V defaultValue) {
        return synchronizedMap.getOrDefault(key, defaultValue);
    }

    @Override
    public synchronized V put(K key, V value) {
        return synchronizedMap.put(key, value);
    }

    @Override
    public synchronized V remove(Object key) {
        return synchronizedMap.remove(key);
    }

    @Override
    public synchronized void putAll(@NotNull Map<? extends K, ? extends V> otherMap) {
        synchronizedMap.putAll(otherMap);
    }

    @Override
    public synchronized V compute(K key,
                                  @NotNull BiFunction<? super K, ? super V, ? extends V> remappingFunction) {
        return synchronizedMap.compute(key, remappingFunction);
    }

    @Override
    public synchronized void clear() {
        synchronizedMap.clear();
    }

    @Override
    public synchronized @NotNull Set<K> keySet() {
        return synchronizedMap.keySet();
    }

    @Override
    public synchronized @NotNull Collection<V> values() {
        return synchronizedMap.values();
    }

    @Override
    public synchronized @NotNull Set<Entry<K, V>> entrySet() {
        return synchronizedMap.entrySet();
    }
}
