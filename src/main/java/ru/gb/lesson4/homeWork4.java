package ru.gb.lesson4;

import java.util.Random;
import java.util.Scanner;

public class homeWork4 {

    private static final int SIZE = 6;
    private static final int DOTS_TO_WIN = 4;


    private static final char DOT_EMPTY = '•';
    private static final char DOT_HUMAN = 'X';
    private static final char DOT_AI = 'O';
    private static final String HEADER_FIRST_SYMBOL = "#";
    private static final String SPACE_MAP = " ";
    private static int turnsCount;
    private static int lastTurnColumn;
    private static int lastTurnLine;

    private static final char[][] map = new char[SIZE][SIZE];

    private static Scanner in = new Scanner(System.in);
    private static Random random = new Random();


    public static void main(String[] args) {
        mapInitialization();
        mapPrinting();
        playGame();
    }

    private static void mapInitialization() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                map[i][j] = DOT_EMPTY;
            }
        }
    }

    private static void mapPrinting() {
        printMapHeader();
        printMapBody();
        System.out.println();
    }

    private static void printMapHeader() {
        System.out.print(HEADER_FIRST_SYMBOL + SPACE_MAP);

        for (int i = 0; i < SIZE; i++) {
            System.out.print(i + 1 + SPACE_MAP);
        }
        System.out.println();
    }

    private static void printMapBody() {
        for (int i = 0; i < SIZE; i++) {
            System.out.print(i + 1 + SPACE_MAP);

            for (int j = 0; j < SIZE; j++) {
                System.out.print(map[i][j] + SPACE_MAP);
            }
            System.out.println();
        }
    }

    private static void playGame() {
        while (true) {
            humanTurn();
            mapPrinting();
            if (endCheck(DOT_HUMAN)) {
                break;
            }

            aiTurn();
            mapPrinting();
            if (endCheck(DOT_AI)) {
                break;
            }
        }
    }

    private static void humanTurn() {
        int columnNumber, lineNumber;

        do {
            System.out.print("Select column: ");
            columnNumber = getValidNumberFromScanner() - 1;

            System.out.print("Select line: ");
            lineNumber = getValidNumberFromScanner() - 1;
            System.out.println();

            if (isCellFree(lineNumber, columnNumber)) {
                break;
            }
            System.out.printf("Cell %d: %d is already occupied, select another cell%n%n", columnNumber + 1, lineNumber + 1);

        } while (!isCellFree(lineNumber, columnNumber));

        map[lineNumber][columnNumber] = DOT_HUMAN;
        lastTurnColumn = columnNumber;
        lastTurnLine = lineNumber;
        turnsCount++;
        System.out.println("You turn:");
    }

    private static int getValidNumberFromScanner() {
        while (true) {

            if (in.hasNextInt()) {
                int n = in.nextInt();

                if (isNumberValid(n)) {
                    return n;
                }
                System.out.println("Number must be between 1 and  " + SIZE);

            } else {
                System.out.println("Please, enter valid number");
                in.next();
            }
        }
    }

    private static boolean isNumberValid(int n) {
        return n >= 1 && n <= SIZE;
    }

    private static void aiTurn() {
        int columnNumber, lineNumber;
        do {

            columnNumber = random.nextInt(SIZE);
            lineNumber = random.nextInt(SIZE);

        } while (!isCellFree(lineNumber, columnNumber));

        map[lineNumber][columnNumber] = DOT_AI;
        lastTurnColumn = columnNumber;
        lastTurnLine = lineNumber;
        turnsCount++;
        System.out.println("AI turn:");
    }

    private static boolean isCellFree(int lineNumber, int columnNumber) {
        return map[lineNumber][columnNumber] == DOT_EMPTY;
    }

    private static boolean endCheck(char symbol) {

        if (winConditionCheck(symbol)) {
            if (symbol == DOT_HUMAN) {
                System.out.println("Congratulations, you won!");
            } else {
                System.out.println("AI beat you AF");
            }
            return true;
        }

        if (checkDraw()) {
            System.out.println("Draw!");
            return true;
        }

        return false;
    }

    private static boolean winConditionCheck(char symbol) {
        int symbolCount = 0;

        for (int i = 0; i < SIZE; i++) {

            if (map[lastTurnLine][i] == symbol) {
                symbolCount++;
            } else {
                symbolCount = 0;
            }

            if (symbolCount == DOTS_TO_WIN) {
                return true;
            }
        }
        symbolCount = 0;

        for (int i = 0; i < SIZE; i++) {

            if (map[i][lastTurnColumn] == symbol) {
                symbolCount++;
            } else {
                symbolCount = 0;
            }

            if (symbolCount == DOTS_TO_WIN) {
                return true;
            }
        }
        symbolCount = 0;

        if (lastTurnLine >= lastTurnColumn) {
            for (int i = 0; i < (SIZE - (lastTurnLine - lastTurnColumn)); i++) {

                if (map[lastTurnLine - lastTurnColumn + i][i] == symbol) {
                    symbolCount++;
                } else {
                    symbolCount = 0;
                }

                if (symbolCount == DOTS_TO_WIN) {
                    return true;
                }
            }
        } else {
            for (int i = 0; i < (SIZE - (lastTurnColumn - lastTurnLine)); i++) {

                if (map[i][lastTurnColumn - lastTurnLine + i] == symbol) {
                    symbolCount++;
                } else {
                    symbolCount = 0;
                }

                if (symbolCount == DOTS_TO_WIN) {
                    return true;
                }
            }
        }

        symbolCount = 0;

        if (lastTurnLine >= (SIZE - lastTurnColumn - 1)) {
            for (int i = 0; (lastTurnLine - (SIZE - lastTurnColumn - 1) + i) < SIZE; i++) {

                if (map[SIZE - 1 - i][lastTurnLine - (SIZE - lastTurnColumn - 1) + i] == symbol) {
                    symbolCount++;

                } else {
                    symbolCount = 0;
                }

                if (symbolCount == DOTS_TO_WIN) {
                    return true;
                }
            }
        } else {
            for (int i = 0; lastTurnColumn + lastTurnLine - i >= 0; i++) {

                if (map[lastTurnColumn + lastTurnLine - i][i] == symbol) {
                    symbolCount++;
                } else {
                    symbolCount = 0;
                }

                if (symbolCount == DOTS_TO_WIN) {
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean checkDraw() {

        return turnsCount >= SIZE * SIZE;
    }


}
