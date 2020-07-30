package net.lishaoy.threaddemo.lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class LockDemo {

    private int count = 0;
    private Lock lock = new ReentrantLock();

    public void add() {
        lock.lock();
        try {
            count ++;
        } finally {
            lock.unlock();
        }
    }

    public synchronized void add1() {
        count ++;
        add();
    }



}
