package net.lishaoy.threaddemo.synchronization;

class SharedThread {

    private int count = 0;
    private Object object = new Object();

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

//    public synchronized void addCount(){
//        count++;
//    }

    public void addCount(){
        synchronized (object) {
            count++;
        }
    }

    private static class CountThread extends Thread {

        private SharedThread sharedThread;

        public CountThread(SharedThread sharedThread) {
            this.sharedThread = sharedThread;
        }

        @Override
        public void run() {
            for (int i = 0; i < 6666; i++) {
                sharedThread.addCount();
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        SharedThread sharedThread = new SharedThread();
        CountThread countThread = new CountThread(sharedThread);
        CountThread countThread1 = new CountThread(sharedThread);
        countThread.start();
        countThread1.start();
        Thread.sleep(66);
        System.out.println(sharedThread.getCount());
        System.out.println(6666 * 2);
    }
}
