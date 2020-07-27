package definegeneric;

public class SimpleClass {

    private Object object;

    public Object getObject() {

        return object;
    }

    public void setObject(Object object) {

        this.object = object;
    }

    public static void main(String[] args) {

        SimpleClass simpleClass = new SimpleClass();
        simpleClass.setObject(66);
        int i = (int) simpleClass.getObject();
        simpleClass.setObject("OK");
//        i = (int) simpleClass.getObject();
        System.out.println();

    }

}
