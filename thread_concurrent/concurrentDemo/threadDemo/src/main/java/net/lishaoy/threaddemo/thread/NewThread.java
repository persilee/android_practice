package net.lishaoy.threaddemo.thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class NewThread {

    /**
     * 继承 Thread，重写 run() 方法
     */
    private static class UseThread extends Thread {

        @Override
        public void run() {
            super.run();

            System.out.println("extends Thread");
        }
    }

    /**
     * 实现 Runnable 接口
     */
    private static class UseRunnable implements Runnable {

        @Override
        public void run() {
            System.out.println("implements Runnable");
        }
    }

    /**
     * 实现 Callable 接口
     */
    private static class UseCallable implements Callable<String> {

        @Override
        public String call() throws Exception {
            System.out.println("implements Callable");
            return "return UseCallable";
        }
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        // 使用 Thread 创建线程
        UseThread useThread = new UseThread();
        useThread.start();
        // 使用 Runnable 创建线程
        UseRunnable useRunnable = new UseRunnable();
        new Thread(useRunnable).start();
        // 使用 Callable 创建线程
        UseCallable useCallable = new UseCallable();
        FutureTask<String> task = new FutureTask<>(useCallable);
        new Thread(task).start();
        System.out.println(task.get());

    }

}