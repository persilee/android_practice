package net.lishaoy.threaddemo.aqs.templatemethod;

public class CreamCake extends AbstractCake {

    @Override
    protected void mould() {
        System.out.println("奶油蛋糕制作形状 ...");
    }

    @Override
    protected void butter() {
        System.out.println("奶油蛋糕涂抹奶油 ...");
    }

    @Override
    protected void toast() {
        System.out.println("奶油蛋糕烤面包 ...");
    }
}
