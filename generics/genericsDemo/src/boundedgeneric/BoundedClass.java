package boundedgeneric;

public class BoundedClass<T extends Comparable> {

    private T t;

    public void setT(T t) {

        this.t = t;
    }

    public T min(T outter){

        if(this.t.compareTo(outter) > 0)
            return outter;
        else
            return this.t;
    }

    public static void main(String[] args) {

        BoundedClass<String> boundedClass = new BoundedClass<>();
        boundedClass.setT("iOS");
        System.out.println(boundedClass.min("android"));

    }

}
