package definegeneric;

public class GenericClass<T> {

    private T t;

    public T getT() {

        return t;
    }

    public void setT(T t) {

        this.t = t;
    }

    public static void main(String[] args) {

        GenericClass<String> genericClass = new GenericClass<>();
        genericClass.setT("OK");
        System.out.println(genericClass.getT());

    }
}
