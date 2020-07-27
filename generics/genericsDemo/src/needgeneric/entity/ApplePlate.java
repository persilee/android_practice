package needgeneric.entity;

import java.util.ArrayList;
import java.util.List;

public class ApplePlate implements Plate<Apple> {

    private List<Apple> apples = new ArrayList<>(6);

    @Override
    public void set(Apple apple) {

        apples.add(apple);

    }

    @Override
    public Apple get() {

        int index = apples.size() - 1;

        if(index >= 0) return apples.get(index);

        return null;
    }
}
