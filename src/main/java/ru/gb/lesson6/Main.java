package ru.gb.lesson6;

public class Main {

    public static void main(String[] args) {
        Dog dude = new Dog(" Dude");
        dude.run(700);
        dude.swim(120);
        dude.swim(10);
        System.out.println(Dog.getDogsCount());

        Cat kisik = new Cat("Kisik");
        kisik.swim(5);
        kisik.run(70);
        kisik.run(202);
        System.out.println(Cat.getCatsCount());
        System.out.println(Animals.getAnimalsCount());
    }
}
