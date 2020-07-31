package net.lishaoy.threaddemo.aqs.templatemethod;

public abstract class AbstractCake {

    protected abstract void mould(); // 制作形状
    protected abstract void butter(); // 涂抹奶油
    protected abstract void toast(); // 烤面包

    public final void making() {
        this.mould();
        this.butter();
        this.toast();
    }
}
