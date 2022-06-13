package ru.gb.lesson8.listeners;

import ru.gb.lesson8.Calculation;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class OperatorButtonListener implements ActionListener {

    private JTextField inputField;

    public OperatorButtonListener(JTextField inputField) {

        this.inputField = inputField;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Calculation.getFirstNumber(inputField);
        JButton btn = (JButton) e.getSource();
        Calculation.getOperator(btn);
        inputField.setText(inputField.getText() + btn.getText());
    }
}
