package needgeneric.entity;

public interface Plate<T> {

    public void set(T t);

    public T get();

}
