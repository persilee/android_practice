package needgeneric;

import needgeneric.entity.*;

public class Scenario {

    public static void main(String[] args) {

        scenario1();
        scenario2();

    }

    private static void scenario1() {

        James james = new James();
        Lucy lucy = new Lucy();

        FruitPlate fruitPlate = james.getPlate();

        james.addFruit(fruitPlate,new Orange());

        lucy.eat((Orange) fruitPlate.get());
    }


    private static void scenario2() {

        James james = new James();
        Lucy lucy = new Lucy();

        AiFruitPlate<Orange> aiFruitPlate = james.getAiFruitPlate();

        james.add(aiFruitPlate, new Orange());

        lucy.eat(aiFruitPlate.get());
    }

}
