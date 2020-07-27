package boundedgeneric;

public class BoundedGeneric {

    public static <T extends Comparable> T min(T a, T b) {

        if (a.compareTo(b) < 0)
            return a;
        else
            return b;

    }

    public static void main(String[] args) {

        System.out.println(BoundedGeneric.min(66,666));

    }

}
