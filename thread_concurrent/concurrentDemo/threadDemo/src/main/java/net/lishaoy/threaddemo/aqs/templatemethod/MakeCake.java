package net.lishaoy.threaddemo.aqs.templatemethod;

class MakeCake {

    public static void main(String[] args) {
        CheeseCake cheeseCake = new CheeseCake();
        CreamCake creamCake = new CreamCake();

        cheeseCake.making();
    }

}
