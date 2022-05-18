package ru.gb.lesson2;

public class Homework {

    static int a = 10;
    static int b = 4;
    static String str = "Hello!";
    static int year = 1937;

    public static void main(String[] args) {
        numberRangeCheck(a, b);
        positiveOrNegativeCheck(a);
        checkNumberOnNegative(b);
        stringPrinting(b, str);
        leapYearCheck(year);
    }

    static boolean numberRangeCheck( int a, int b) {
        return a + b > 10 && a + b <20;
    }

    static void positiveOrNegativeCheck(int a) {
        if(a >= 0) {
            System.out.println("Number is positive");
        }
        System.out.println("Number is negative");
    }

    static boolean checkNumberOnNegative (int a) {
        return a < 0;
    }

    static void stringPrinting(int a, String s) {
        for (int i = 0; i < a; i++) System.out.println(s);
    }

    static boolean leapYearCheck(int a) {
        if(a % 4 == 0) {
            return a % 100 != 0 || a % 400 == 0;
        }
        return false;
    }
}
