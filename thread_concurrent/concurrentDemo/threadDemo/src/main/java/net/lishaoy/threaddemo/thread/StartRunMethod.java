package net.lishaoy.threaddemo.thread;

import java.util.concurrent.TimeUnit;

class StartRunMethod {

    public static class StartAndRun extends Thread {

        @Override
        public void run() {
            System.out.println("run: This is " + Thread.currentThread().getName());
        }

        public void runMethod() {
            System.out.println("runMethod: This is " + Thread.currentThread().getName());
        }
    }

    public static void main(String[] args) {

        StartAndRun startAndRun = new StartAndRun();
        startAndRun.setName("ThreadRun"); // 设置线程的名字
        startAndRun.start(); // 真正启动名字为 ThreadRun 的线程
        startAndRun.run();  // 只是一个普通方法，和 runMethod() 没有区别
        startAndRun.runMethod();

    }
}
