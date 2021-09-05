package src;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.lang.Math;

public class Main {
    public static void main(String[] args) {
        new Render();
    }
}

class Render implements ActionListener {
    JFrame frame = new JFrame();

    ImageIcon background = new ImageIcon("rick_astley.jpg");
    JLabel back = new JLabel(background);

    JButton button = new JButton("Calculate");

    //define text fields
    JTextField principalTF = new JTextField();
    JTextField interestRateTF = new JTextField();
    JTextField yearsTF = new JTextField();
    JTextField resultTF = new JTextField();

    //define text labels
    JLabel principalLabel = new JLabel("Enter Principal:");
    JLabel interestRateLabel = new JLabel("Enter Annual Interest Rate:");
    JLabel yearsLabel = new JLabel("Enter Mortgage Years:");
    JLabel resultLabel = new JLabel("Monthly Payment:");

    Render() {
        frameProperties();
        buttonProperties();

        principalTFProperties();
        interestRateTFProperties();
        yearsTFProperties();
        resultTFProperties();

        principalLabelProperties();
        interestRateLabelProperties();
        yearsLabelProperties();
        resultLabelProperties();

        backgroundProperties();
    }

    public void frameProperties() {
        frame.setTitle("Mortgage Calculator");
        frame.getContentPane().setLayout(null);
        frame.setVisible(true);
        frame.setSize(400, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void buttonProperties() {
        button.setBounds(150, 265, 100, 40);
        frame.add(button);
        button.addActionListener(this);
    }

    //render text fields
    public void principalTFProperties() {
        principalTF.setBounds(100, 50, 200, 30);
        frame.add(principalTF);
        principalTF.addActionListener(this);
    }
    public void interestRateTFProperties() {
        interestRateTF.setBounds(100, 100, 200, 30);
        frame.add(interestRateTF);
        interestRateTF.addActionListener(this);
    }
    public void yearsTFProperties() {
        yearsTF.setBounds(100, 150, 200, 30);
        frame.add(yearsTF);
        yearsTF.addActionListener(this);
    }
    public void resultTFProperties() {
        resultTF.setBounds(100, 200, 200, 30);
        frame.add(resultTF);
        resultTF.setEditable(false);
    }

    //render text labels
    public void principalLabelProperties() {
        principalLabel.setBounds(100, 30, 200, 20);
        frame.add(principalLabel);
        principalLabel.setForeground(Color.white);
    }
    public void interestRateLabelProperties() {
        interestRateLabel.setBounds(100, 80, 200, 20);
        frame.add(interestRateLabel);
        interestRateLabel.setForeground(Color.white);
    }
    public void yearsLabelProperties() {
        yearsLabel.setBounds(100, 130, 200, 20);
        frame.add(yearsLabel);
        yearsLabel.setForeground(Color.white);
    }
    public void resultLabelProperties() {
        resultLabel.setBounds(100, 180, 200, 20);
        frame.add(resultLabel);
        resultLabel.setForeground(Color.white);
    }

    //render background
    public void backgroundProperties() {
        back.setLayout(null);
        back.setBounds(0, 0, 400, 400);
        frame.add(back);
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
