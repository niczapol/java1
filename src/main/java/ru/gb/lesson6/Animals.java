package ru.gb.lesson6;

public abstract class Animals {

    private String nickname;
    private int staminaLimitForRun;
    private static int animalsCount;
    private int staminaLimitForSwim;

    public Animals(String nickname, int staminaLimitForRun, int staminaLimitForSwim) {

        this.nickname = nickname;
        this.staminaLimitForRun = staminaLimitForRun;
        this.staminaLimitForSwim = staminaLimitForSwim;
        this.animalsCount++;
    }

    public String getNickname() {
        return nickname;
    }

    public static int getAnimalsCount() {
        return animalsCount;
    }

    public int getStaminaLimitForRun() {
        return staminaLimitForRun;
    }

    public int getStaminaLimitForSwim() {
        return staminaLimitForSwim;
    }

    public void run(int runDistance) {
            if(runDistance <= getStaminaLimitForRun()) {
                System.out.println(getNickname() + " ran " + runDistance + "m.");
            } else {
                System.out.println(getNickname() + " ran " + getStaminaLimitForRun() + "m and tired((");
            }
        }

    public abstract void swim(int swimDistance);

}
