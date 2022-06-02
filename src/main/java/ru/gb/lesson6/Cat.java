package ru.gb.lesson6;

public class Cat extends Animals {

    private static int catsCount;


    public Cat(String nickname) {

        super(nickname, 200, 0);
        this.catsCount++;
    }


    public static int getCatsCount() {
        return catsCount;
    }

    @Override
    public void swim(int distance) {
        System.out.println("Are you sure you want to throw " + getNickname() + " into the water?");
    }
}
