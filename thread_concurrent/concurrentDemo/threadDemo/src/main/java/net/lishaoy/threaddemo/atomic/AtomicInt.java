package net.lishaoy.threaddemo.atomic;

import java.util.concurrent.atomic.AtomicInteger;

class AtomicInt {

    static AtomicInteger atomicInteger = new AtomicInteger(6);

    public static void main(String[] args) {
        atomicInteger.getAndDecrement(); // 自增1，返回之前的值
        System.out.println(atomicInteger);
        atomicInteger.incrementAndGet(); // 自增1，返回新增
        System.out.println(atomicInteger);
        System.out.println(atomicInteger.addAndGet(6));
        System.out.println(atomicInteger.getAndAdd(6));
    }

}
