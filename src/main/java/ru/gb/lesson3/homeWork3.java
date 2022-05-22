package ru.gb.lesson3;


public class homeWork3 {
    public static void main(String[] args) {
        task1();
        task2();
        task3();
        task4();
        task5(5, 6);
        task6();
        int[] array = new int[] {2, 6, 7, 1, 5, 2, 9, 6, 3, 1};
        checkBalance(array);
        massiveShift(array, -1);
    }

    static void task1() {
        int[] arr = {0, 1, 1, 0, 1, 0, 1, 1, 0, 0, 1};

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 0) {
                arr[i] = 1;
            } else arr[i] = 0;
        }
    }

    static void task2() {
        int[] arr = new int[100];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = i + 1;
        }
    }

    static void task3() {
        int[] arr = new int[]{1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};

        for (int i : arr) {
            if (i < 6) i *= 2;
        }
    }

    static void task4() {
        int[][] arr = new int[9][9];

        for (int i = 0; i < arr.length; i++) {
            arr[i][i] = 1;
            arr[arr.length - 1 - i][i] = 1;
        }
    }

    static int[] task5(int length, int value) {
        int[] arr = new int[length];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = value;
        }
        return arr;
    }

    static void task6() {
        int[] arr = new int[]{4, -5, 1, 8, -6, 33, -9, 2};
        int min = arr[0];
        int max = arr[arr.length -1];

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < min) {
                min = arr[i];
            }
            if (arr[i] > max) {
                max = arr[i];
            }
        }
    }

    static boolean checkBalance(int[] arr) {
        int sumLeft = 0;

        for (int i = 0; i < arr.length; i++) {
            int sumRight = 0;
            sumLeft +=arr[i];

            for (int j = i+1; j < arr.length; j++) {
                sumRight += arr[j];
                if (sumRight > sumLeft) break;
            }
            if(sumLeft == sumRight) return true;
        }
        return false;
    }

    static void massiveShift(int[] arr, int shiftCount) {
        
        for (int i = 0; i < shiftCount; i++) {
            int x = arr[0];
            arr[0] = arr[arr.length-1];

            for (int j = 0; j < arr.length - 1; j++) {
                int y = arr[j+1];
                arr[j+1] = x;
                x = y;
            }
        }
    }
}
