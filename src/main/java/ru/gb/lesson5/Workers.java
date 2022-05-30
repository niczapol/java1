package ru.gb.lesson5;

public class Workers {

    private String fullName;
    private String position;
    private String email;
    private String phoneNumber;

    private int salary;
    private int age;

    public Workers(String fullName, String position, String email, String phoneNumber, int salary, int age) {
        this.fullName = fullName;
        this.position = position;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.salary = salary;
        this.age = age;
    }

    public void getWorkerInfo() {
        System.out.println(this);
    }

    public int getAge() {
        return age;
    }

    public String toString() {
        return String.format("Worker: %s, position: %s, email: %s, phone number: %s, salary: %d, age: %d", fullName, position, email, phoneNumber, salary, age);
    }
}
