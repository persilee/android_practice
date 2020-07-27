package subtypes;

import needgeneric.James;
import needgeneric.entity.Apple;
import needgeneric.entity.Fruit;
import needgeneric.entity.FruitPlateGen;
import needgeneric.entity.Orange;

import java.util.ArrayList;
import java.util.List;

public class GenericSubtypes {

    public static void use() {

        Apple apple = new Apple();
        Orange orange = new Orange();
        Fruit fruit = new Fruit();
        fruit = apple;

        FruitPlateGen<Fruit> fruitPlate = new FruitPlateGen<Fruit>();
        fruitPlate.set(apple);
        fruitPlate.set(orange);

        James james = new James();
        james.getAiFruitPlateGen(new FruitPlateGen<Fruit>());
        james.getAiFruitPlateGen2(new FruitPlateGen<Orange>());
//        james.getAiFruitPlateGen(new FruitPlateGen<Orange>());
        james.getAiFruitPlateGen(new ExtendFruitPlate<Orange>());
        james.getAiFruitPlateGen3(new FruitPlateGen<Apple>());
        james.getAiFruitPlateGen3(new FruitPlateGen<Fruit>());

//        FruitPlateGen<? extends Fruit> fruitPlateGen = new FruitPlateGen<>();
//        fruitPlateGen.set(apple);
//        fruitPlateGen.set(orange);
//        fruitPlateGen.set(fruit);
//        Fruit fruit1 = fruitPlateGen.get();
//
//        FruitPlateGen<? super Apple> fruitPlateGen1 = new FruitPlateGen<>();
//        fruitPlateGen1.set(apple);
//        fruitPlateGen1.set(orange);
//        fruitPlateGen1.set(fruit);
//        Object object = fruitPlateGen1.get();
//        Fruit fruit2 = fruitPlateGen1.get();
//        Apple apple2 = fruitPlateGen1.get();
//        Orange orange2 = fruitPlateGen1.get();



    }

    public static void use2() {

        Apple apple = new Apple();
        Orange orange = new Orange();
        Fruit fruit = apple;

        List<Apple> apples = new ArrayList<>();
//        List<Fruit> fruits = apples;

        List<? extends Fruit> fruits1 = apples;
        List<? super Apple> fruits2 = apples;

    }

    private static class ExtendFruitPlate<Orange> extends FruitPlateGen<Fruit> {

    }

}
