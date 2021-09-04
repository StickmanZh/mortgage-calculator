package src;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.lang.Math;

class Render implements ActionListener {
    JFrame frame = new JFrame();
    JButton button = new JButton("Calculate");
    JTextField principalTF = new JTextField("Enter Principal:");
    JTextField interestRateTF = new JTextField("Enter Annual Interest Rate:");
    JTextField yearsTF = new JTextField("Enter Mortgage Years:");
    JTextField resultTF = new JTextField("Result:");

    Render() {
        frameProperties();
        buttonProperties();
        principalTFProperties();
        interestRateTFProperties();
        yearsTFProperties();
        resultTFProperties();
    }

    public void frameProperties() {
        frame.setTitle("Mortgage Calculator");
        frame.getContentPane().setLayout(null);
        frame.setVisible(true);
        frame.setSize(400, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void buttonProperties() {
        button.setBounds(150, 300, 100, 40);
        frame.add(button);
        button.addActionListener(this);
    }

    public void principalTFProperties() {
        principalTF.setBounds(80, 50, 200, 30);
        frame.add(principalTF);
        principalTF.addActionListener(this);
    }

    public void interestRateTFProperties() {
        interestRateTF.setBounds(80, 100, 200, 30);
        frame.add(interestRateTF);
        interestRateTF.addActionListener(this);
    }

    public void yearsTFProperties() {
        yearsTF.setBounds(80, 150, 200, 30);
        frame.add(yearsTF);
        yearsTF.addActionListener(this);
    }

    public void resultTFProperties() {
        resultTF.setBounds(80, 200, 200, 30);
        frame.add(resultTF);
        resultTF.setEditable(false);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String principalString = principalTF.getText();
        String interestRateString = interestRateTF.getText();
        String yearsString = yearsTF.getText();

        double principal = Double.parseDouble(principalString);

        double interestRatePerMonth = Double.parseDouble(interestRateString);
        interestRatePerMonth /= 12;

        double numberOfPayments = Double.parseDouble(yearsString);
        numberOfPayments *= 12;

        double monthlyPayment = (principal * interestRatePerMonth * Math.pow((1 + interestRatePerMonth), numberOfPayments)) / (Math.pow((1 + interestRatePerMonth), numberOfPayments) - 1);
        double roundedPayment = Math.round(monthlyPayment * 100.0) / 100.0;
        resultTF.setText("$" + String.valueOf(roundedPayment));
    }
}
 
public class Main {
    public static void main(String[] args) {
        new Render();
    }
}
