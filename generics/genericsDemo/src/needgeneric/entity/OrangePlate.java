package needgeneric.entity;

import java.util.ArrayList;
import java.util.List;

public class OrangePlate implements Plate<Orange> {

    private List<Orange> oranges = new ArrayList<>(6);

    @Override
    public void set(Orange orange) {

        oranges.add(orange);

    }

    @Override
    public Orange get() {

        int index = oranges.size() - 1;

        if(index >= 0) return oranges.get(index);

        return null;
    }
}
