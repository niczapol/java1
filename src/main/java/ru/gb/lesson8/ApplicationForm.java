package ru.gb.lesson8;

import ru.gb.lesson8.components.NumberJButton;
import ru.gb.lesson8.components.OperatorJButton;
import ru.gb.lesson8.listeners.ButtonListener;
import ru.gb.lesson8.listeners.CalcButtonActionListener;
import ru.gb.lesson8.listeners.ClearButtonActionListener;
import ru.gb.lesson8.listeners.OperatorButtonListener;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ApplicationForm extends JFrame {


    private JTextField inputField;

    public ApplicationForm(String title) throws HeadlessException {
        super(title);
        setBounds(400, 600, 250, 350);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setAlwaysOnTop(true);

        Button button = new Button("button");
        button.addActionListener(new ButtonListener(inputField));
        super.add(button);

        setJMenuBar(createMenu());

        setLayout(new BorderLayout());

        add(createTopPanel(), BorderLayout.NORTH);
        add(createCenterPanel(), BorderLayout.CENTER);


        setVisible(true);
    }

    private JMenuBar createMenu() {
        JMenuBar menuBar = new JMenuBar();

        JMenu menuFile = new JMenu("File");


        menuBar.add(menuFile);
        menuBar.add(new JMenuItem("About"));
        menuBar.add(new JMenuItem(" Help"));

        menuFile.add(new JMenuItem("Clear"));
        JMenuItem exitItem = menuFile.add(new JMenuItem("Exit"));
        exitItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        menuBar.add(exitItem);

        return menuBar;
    }

    private JPanel createCenterPanel() {
        JPanel centerPanel = new JPanel();
        centerPanel.setLayout(new BorderLayout());

        ActionListener buttonListener = new ButtonListener(inputField);
        ActionListener operatorButtonListener = new OperatorButtonListener(inputField);

        centerPanel.add(createDigitsPanel(buttonListener), BorderLayout.CENTER);
        centerPanel.add(createOperatorsPanel(operatorButtonListener), BorderLayout.WEST);


        return centerPanel;
    }

    private JPanel createOperatorsPanel(ActionListener OperatorButtonListener) {
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(4, 1));

        JButton minus = new OperatorJButton("-");
        minus.addActionListener(OperatorButtonListener);
        panel.add(minus);

        JButton plus = new OperatorJButton("+");
        plus.addActionListener(OperatorButtonListener);
        panel.add(plus);

        JButton multiply = new OperatorJButton("*");
        multiply.addActionListener(OperatorButtonListener);
        panel.add(multiply);

        JButton divide = new OperatorJButton("/");
        divide.addActionListener(OperatorButtonListener);
        panel.add(divide);


        return panel;
    }


    private JPanel createTopPanel() {
        JPanel top = new JPanel();
        top.setLayout(new BorderLayout());

        inputField = new JTextField();
        inputField.setEditable(false);
        top.add(inputField);
        inputField.setFont(new Font("TimesRoman", Font.PLAIN, 25));
        inputField.setMargin(new Insets(8, 0, 8, 0));
        inputField.setBackground(new Color(0xFAFAFA));


        return top;
    }

    private JPanel createDigitsPanel(ActionListener buttonListener) {
        JPanel digitsPanel = new JPanel();

        digitsPanel.setLayout(new GridLayout(4, 3));

        for (int i = 0; i < 10; i++) {
            String buttonTitle = (i == 9) ? "0" : String.valueOf(i + 1);
            JButton btn = new NumberJButton(buttonTitle);
            btn.addActionListener(buttonListener);
            digitsPanel.add(btn);
        }

        JButton clear = new OperatorJButton("C");
        digitsPanel.add(clear);
        clear.addActionListener(new ClearButtonActionListener(inputField));

        JButton calc = new OperatorJButton("=");
        calc.addActionListener(new CalcButtonActionListener(inputField));
        digitsPanel.add(calc);


        return digitsPanel;
    }
}
