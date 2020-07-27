package methodgeneric;

public class MethodGeneric {

    public <T> T genericMethod(T...t) {

        return t[t.length/2];
    }

    public void test(int x, int y) {

        System.out.println(x + y);
    }

    public static void main(String[] args) {

        MethodGeneric methodGeneric = new MethodGeneric();
        methodGeneric.test(66, 666);
        System.out.println(methodGeneric.<String>genericMethod("java","dart","kotlin"));
        System.out.println(methodGeneric.genericMethod("java","dart","kotlin"));

    }

}
