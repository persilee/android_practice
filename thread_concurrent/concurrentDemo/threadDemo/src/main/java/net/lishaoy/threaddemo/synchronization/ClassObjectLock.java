package net.lishaoy.threaddemo.synchronization;

import net.lishaoy.threaddemo.tools.SleepTool;

class ClassObjectLock {

    private static class ClassLock extends Thread {
        @Override
        public void run() {
            System.out.println("Class Lock is running ...");
            lockClass();
        }
    }

    private static class ObjectLock extends Thread {
        private ClassObjectLock classObjectLock;

        public ObjectLock(ClassObjectLock classObjectLock) {
            this.classObjectLock = classObjectLock;
        }

        @Override
        public void run() {
            System.out.println("Object Lock is running ...");
            classObjectLock.lockObject();
        }
    }

    private static class ObjectLock1 extends Thread {
        private ClassObjectLock classObjectLock;

        public ObjectLock1(ClassObjectLock classObjectLock) {
            this.classObjectLock = classObjectLock;
        }

        @Override
        public void run() {
            System.out.println("Object Lock1 is running ...");
            classObjectLock.lockObject1();
        }
    }

    // 对象锁
    private synchronized void lockObject() {
        SleepTool.second(2);
        System.out.println("Object Lock use");
        SleepTool.second(2);
        System.out.println("Object Lock end");
    }

    // 对象锁
    private synchronized void lockObject1() {
        SleepTool.second(2);
        System.out.println("Object Lock1 use");
        SleepTool.second(2);
        System.out.println("Object Lock1 end");
    }

    // 类锁
    private static synchronized void lockClass() {
        SleepTool.second(2);
        System.out.println("Class Lock use");
        SleepTool.second(2);
        System.out.println("Class Lock end");
    }

    public static void main(String[] args) {
        ClassObjectLock classObjectLock = new ClassObjectLock();
        ObjectLock objectLock = new ObjectLock(classObjectLock);

        ClassObjectLock classObjectLock1 = new ClassObjectLock();
        ObjectLock1 objectLock1 = new ObjectLock1(classObjectLock1);
        objectLock.start();
        objectLock1.start();

        ClassLock classLock = new ClassLock();
        classLock.start();
    }

}
