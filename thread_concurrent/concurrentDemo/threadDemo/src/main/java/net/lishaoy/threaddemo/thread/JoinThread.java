package net.lishaoy.threaddemo.thread;

class JoinThread {

    private static class JoinMethod extends Thread {

        private Thread thread;

        public JoinMethod(Thread thread) {
            this.thread = thread;
        }

        @Override
        public void run() {
            for (int i = 0; i < 6; i++) {
                System.out.println(thread.getName() + " running ... ");
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {

        JoinMethod joinMethod = new JoinMethod(new Thread());
        JoinMethod joinMethod1 = new JoinMethod(new Thread());
        joinMethod.start();
        joinMethod.join(); // 使用 join() 方法，由 joinMethod 执行完成之后才让出执行权
        joinMethod1.start();

    }

}
