package net.lishaoy.threaddemo.waitnotify;

public class WaitNotify {

    public final static String CITY = "beijing";
    private int km;
    private String site;

    public WaitNotify(int km, String site) {
        this.km = km;
        this.site = site;
    }

    // 改变公里数，并通知
    public synchronized void changeKm() {
        this.km = 66;
        notifyAll();
    }

    // 改变公站点，并通知
    public synchronized void changeSite() {
        this.site = "guangzhou";
        notifyAll();
    }

    // 如果公里数小于 66，就等待
    public synchronized void waitKm() throws InterruptedException {
        while (this.km < 66) {
            wait();
            System.out.println("check km thread: " + Thread.currentThread().getName());
        }
        System.out.println("km is " + this.km);
    }

    // 如果站点是beijing，就等待
    public synchronized void waitSite() throws InterruptedException {
        while (CITY.equals(this.site)) {
            wait();
            System.out.println("check site thread: " + Thread.currentThread().getName());
        }
        System.out.println("site is " + this.site);
    }
}
