package net.lishaoy.threaddemo.atomic;

import java.util.concurrent.atomic.AtomicReference;

class UseAtomicReference {

    static AtomicReference<UserInfo> reference; // 原子更新引用类型

    public static void main(String[] args) {
        UserInfo user = new UserInfo("lsy", 66);
        reference = new AtomicReference(user);
        UserInfo updateUser = new UserInfo("per",36);
        reference.compareAndSet(user,updateUser);

        System.out.println(reference.get());
        System.out.println(user);
    }

    //定义一个实体类
    static class UserInfo {
        private volatile String name;
        private int age;
        public UserInfo(String name, int age) {
            this.name = name;
            this.age = age;
        }
        public String getName() {
            return name;
        }
        public int getAge() {
            return age;
        }

        @Override
        public String toString() {
            return "UserInfo{" +
                    "name='" + name + '\'' +
                    ", age=" + age +
                    '}';
        }
    }

}
