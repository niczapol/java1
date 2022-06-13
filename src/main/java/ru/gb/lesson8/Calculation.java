package ru.gb.lesson8;

import javax.swing.*;


public class Calculation {
    private static Double num1;
    private static Double num2;
    private static String operator;


    public static void getFirstNumber(JTextField inputField) {
        num1 = Double.parseDouble(inputField.getText());

    }

    public static void getOperator(JButton btn) {
        operator = btn.getText();

    }

    public static void getSecondNumber(JTextField inputField) {
        String str = inputField.getText();
        str = str.substring(str.indexOf(operator) + 1);
        num2 = Double.parseDouble(str);
    }

    public static Double getResult() {
        return switch (operator) {
            case "+" -> num1 + num2;
            case "-" -> num1 - num2;
            case "*" -> num1 * num2;
            case "/" -> num1 / num2;
            default -> 0.0;
        };
    }
}
