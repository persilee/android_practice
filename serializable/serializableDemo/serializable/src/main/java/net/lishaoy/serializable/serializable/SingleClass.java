package net.lishaoy.serializable.serializable;

import java.io.Serializable;

public class SingleClass implements Serializable {
    private static final long serialVersionUID = 9153534024695280942L;
    private static boolean flag = false;

    private static SingleClass singleClass;

    public static SingleClass getInstance() {

        if(singleClass == null) {
            synchronized (SingleClass.class) {
                if (singleClass == null) {
                    singleClass = new SingleClass();
                }
            }
        }

        return singleClass;
    }

    private Object readResolve() {
        return singleClass;
    }

    public SingleClass() {
//        if (!flag) flag = true; else throw new RuntimeException("单例模式被侵犯！");
    }
}
