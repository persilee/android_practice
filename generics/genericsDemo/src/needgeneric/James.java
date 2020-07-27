package needgeneric;

import needgeneric.entity.*;

public class James extends Person {

    public FruitPlate getPlate() {

        return new FruitPlate();

    }

    public FruitPlateGen getAiFruitPlateGen(FruitPlateGen<Fruit> plate) {

        return new FruitPlateGen();
    }

    public FruitPlateGen getAiFruitPlateGen2(FruitPlateGen<? extends Fruit> plate) {

        return new FruitPlateGen();
    }

    public FruitPlateGen getAiFruitPlateGen3(FruitPlateGen<? super Apple> plate) {

        return new FruitPlateGen();
    }

    public ApplePlate getApplePlate() {

        return  new ApplePlate();

    }

    public OrangePlate getOrangePlate() {

        return  new OrangePlate();

    }

    public AiFruitPlate getAiFruitPlate() {

        return new AiFruitPlate();

    }

    public void addFruit(FruitPlate fruitPlate, Fruit fruit) {

        fruitPlate.set(fruit);

    }

    public void addApple(ApplePlate applePlate) {

        applePlate.set(new Apple());

    }

    public void addOrange(OrangePlate orangePlate, Orange orange) {

        orangePlate.set(orange);

    }

    public void add(AiFruitPlate<Orange> aiFruitPlate, Orange orange) {

        aiFruitPlate.set(orange);

    }

}
