package net.lishaoy.threaddemo.thread;

class InterruptThread {

    private static class MyThread extends Thread {

        @Override
        public void run() {
            String threadName = Thread.currentThread().getName(); // 获取当前线程名
           while (!isInterrupted()) { // 判断是否需要中止
               System.out.println(threadName + " running ...");
           }
        }
    }

    public static void main(String[] args) throws InterruptedException {

        MyThread myThread = new MyThread();
        myThread.start();
        Thread.sleep(6);
        myThread.interrupt(); // 发出中断信号

    }
}
