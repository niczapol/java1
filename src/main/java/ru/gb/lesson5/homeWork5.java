package ru.gb.lesson5;

public class homeWork5 {

    public static void main(String[] args) {

        Workers[] personArray = new Workers[5];

        personArray[0] = new Workers("Stephen Williams", "engineer", "wistep@gmail.com", "89735663207", 1420, 28);
        personArray[1] = new Workers("John Jones", "security", "Johj@gmail.com", "85642336142", 960, 47);
        personArray[2] = new Workers("Sung Jinwoo", "cook", "sjw@gmail.com", "87653420654", 1100, 24);
        personArray[3] = new Workers("Harry Miller", "sailor", "greatestPirate@gmail.com", "89765762323", 600, 55);
        personArray[4] = new Workers("Marry  Wilson", "HR manager", "marson@gmail.com", "87552354665", 1200, 25);

        for (Workers workers : personArray) {

            if (workers.getAge() >= 40) {
                workers.getWorkerInfo();
                System.out.println();
            }
        }
    }


}
