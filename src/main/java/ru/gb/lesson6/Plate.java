package ru.gb.lesson6;

public class Plate {

    private int foodCount;

    public Plate(int foodCount) {

        this.foodCount = foodCount;
    }

    public void addFood(int amountOfFoodAdded) {
        foodCount += amountOfFoodAdded;
    }

    public int decreaseFood(int amountOfFoodToSatiety) {
        int amountOfFoodEaten;

        if ((amountOfFoodToSatiety) <= foodCount) {
            foodCount -= (amountOfFoodToSatiety);
            System.out.println("Current amount of food: " + foodCount);
            return amountOfFoodToSatiety;
        } else {
            amountOfFoodEaten = foodCount;
            foodCount = 0;
            System.out.println("Plate is empty");
            return amountOfFoodEaten;
        }
    }
}
