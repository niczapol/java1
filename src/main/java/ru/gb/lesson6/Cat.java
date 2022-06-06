package ru.gb.lesson6;

public class Cat extends Animals {

    private static int catsCount;
    private int satiety = 0;
    private final int SATIETY_CAP = 30;
    private int amountOfFoodToSatiety;


    public Cat(String nickname) {

        super(nickname, 200, 0);
        this.catsCount++;
    }


    public static int getCatsCount() {
        return catsCount;
    }

    public int getAmountOfFoodToSatiety() {
        return amountOfFoodToSatiety = SATIETY_CAP - satiety;
    }

    @Override
    public void swim(int distance) {
        System.out.println("Are you sure you want to throw " + getNickname() + " into the water?");
    }

    public void eating(Plate plate) {
       satiety += plate.decreaseFood(getAmountOfFoodToSatiety());

       if (getAmountOfFoodToSatiety() == 0) {
           System.out.println(getNickname() + " is full");
       } else {
           System.out.println(getNickname() + " did not have enough food, " + getNickname() + " wants " + getAmountOfFoodToSatiety() + " more");
       }
    }
}
