package net.lishaoy.threaddemo.threadlocal;

class UseThreadLocal {

//    static Integer count = new Integer(1);

    static ThreadLocal<Integer> count = new ThreadLocal<Integer>(){
        @Override
        protected Integer initialValue() {
            return 0;
        }
    };
    //static MyThreadLocal<Integer> count = new MyThreadLocal<>();

    // 启动 3 个线程
    public void StartThread() {
        Thread[] threads = new Thread[3];
        for (int i = 0; i < threads.length; i++) {
            threads[i] = new Thread(new RunnableThread(i));
        }
        for (int i = 0; i < threads.length; i++) {
            threads[i].start();
        }
    }

    // 希望每个线程单独操作自己 count 变量
    public static class RunnableThread implements Runnable {
        int id;

        public RunnableThread(int id) {
            this.id = id;
        }

        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName() + " start");
//            count = count + id;
            Integer integer = count.get(); // 获取 ThreadLocal 里的值
            integer = integer + id;
            count.set(integer); // 如果下次还有使用，需要 set 值
//            count.set(id);
            System.out.println(Thread.currentThread().getName() + " count " + id);
        }
    }

    public static void main(String[] args) {
        UseThreadLocal threadLocal = new UseThreadLocal();
        threadLocal.StartThread();
    }

}
