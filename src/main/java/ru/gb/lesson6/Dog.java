package ru.gb.lesson6;

public class Dog extends Animals {

    private static int dogsCount;

    public Dog(String nickname) {

        super(nickname, 500, 10);
        this.dogsCount++;

    }

    public static int getDogsCount() {
        return dogsCount;
    }

    @Override
    public void swim(int swimDistance) {
        if (swimDistance <= getStaminaLimitForSwim()) {
            System.out.println(getNickname() + " swim " + swimDistance + "m.");
        } else {
            System.out.println(getNickname() + " swim " + getStaminaLimitForSwim() + "m and tired((");
        }
    }
}
