package ru.gb.lesson6;

public class Main {

    public static void main(String[] args) {
        /*Dog dude = new Dog(" Dude");
        dude.run(700);
        dude.swim(120);
        dude.swim(10);
        System.out.println(Dog.getDogsCount());*/
        
        Cat kisik = new Cat("kisik");
        
        /*kisik.swim(5);
        kisik.run(70);
        kisik.run(202);
        System.out.println(Cat.getCatsCount());
        System.out.println(Animals.getAnimalsCount());*/
        
        Plate plate = new Plate(20);
        kisik.eating(plate);
        plate.addFood(150);
        kisik.eating(plate);
        kisik.eating(plate);

        System.out.println();
        
        Cat[] cats = new Cat[5];
        cats[0] = new Cat("Sisik");
        cats[1] = new Cat("Katik");
        cats[2] = new Cat("Jopik");
        cats[3] = new Cat("Basik");
        cats[4] = new Cat("Oleg");

        for (Cat cat:
             cats) {
            cat.eating(plate);
        }
    }
}
