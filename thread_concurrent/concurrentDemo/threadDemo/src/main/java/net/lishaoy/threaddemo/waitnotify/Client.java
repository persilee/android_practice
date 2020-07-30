package net.lishaoy.threaddemo.waitnotify;

class Client {

    private static WaitNotify waitNotify = new WaitNotify(0, WaitNotify.CITY);

    private static class CheckKm extends Thread {

        @Override
        public void run() {
            try {
                waitNotify.waitKm();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private static class CheckSite extends Thread {
        @Override
        public void run() {
            try {
                waitNotify.waitSite();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 2; i++) {
            new CheckKm().start();
        }
        for (int i = 0; i < 2; i++) {
            new CheckSite().start();
        }

        Thread.sleep(1000);
        waitNotify.changeKm();
    }
}
