package methodgeneric;

public class MethodGeneric2 {

    static class Fruit{

        @Override
        public String toString() {

            return "fruit";
        }
    }

    static class Apple extends Fruit {

        @Override
        public String toString() {

            return "Apple";
        }
    }

    static class Person{

        @Override
        public String toString() {

            return "person";
        }
    }

    static class ShowClass<T> {

        public void show1(T t){
            System.out.println(t.toString());
        }

        public <E> void show2(E e) {
            System.out.println(e.toString());
        }

        public <T> void show3(T t) {
            System.out.println(t.toString());
        }
    }

    public static void main(String[] args) {

        Apple apple = new Apple();
        Person person = new Person();

        ShowClass<Fruit> showClass = new ShowClass<>();
        showClass.show1(apple);
//        showClass.show1(person);

        showClass.show2(apple);
        showClass.show2(person);

        showClass.show3(apple);
        showClass.show3(person);


    }

}
