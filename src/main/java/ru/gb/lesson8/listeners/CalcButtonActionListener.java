package ru.gb.lesson8.listeners;

import ru.gb.lesson8.Calculation;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;

public class CalcButtonActionListener implements ActionListener {
    private JTextField inputField;

    public CalcButtonActionListener(JTextField inputField) {
        this.inputField = inputField;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Calculation.getSecondNumber(inputField);
        String formattedResult = new DecimalFormat("#0.00").format(Calculation.getResult()).replace(",", ".");
        inputField.setText(formattedResult);
    }
}
