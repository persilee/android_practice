package net.lishaoy.threaddemo.threadlocal;

import java.util.HashMap;
import java.util.Map;

public class MyThreadLocal<T> {

    private Map<Thread,T> threadTMap = new HashMap<>();

    public synchronized T get() {
        return threadTMap.get(Thread.currentThread());
    }

    public synchronized void set(T t) {
        threadTMap.put(Thread.currentThread(),t);
    }

}
