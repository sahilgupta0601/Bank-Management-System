package com.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.awt.event.ActionListener;

public class Login extends JFrame implements ActionListener{
    JButton loginButton, clearButton, signUpButton;
    JTextField cardText;
    JPasswordField pinText;
    Login(){
        setTitle("AUTOMATED TELLER MACHINE");
        setLayout(null);
        ImageIcon logo = new ImageIcon(getClass().getResource("/com/example/icons/logo.jpg"));
        Image logoSizing  = logo.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
        ImageIcon logoIcon = new ImageIcon(logoSizing);
        JLabel label = new JLabel(logoIcon);
        label.setBounds(150, 10, 100, 100);
        add(label);

        // welcomeText 
        JLabel welcomeText = new JLabel("Welcome to ATM");
        welcomeText.setFont(new Font("Osward", Font.BOLD, 36));
        welcomeText.setBounds(300, 40, 500, 40);
        add(welcomeText);

        // card number 
        JLabel cardNo = new JLabel("Card Number : ");
        cardNo.setFont(new Font("Raleway", Font.BOLD, 26));
        cardNo.setBounds(150, 150, 190, 30);
        add(cardNo);

        cardText = new JTextField();
        cardText.setBounds(360, 150, 240, 30);
        cardText.setFont(new Font("Arial", Font.BOLD, 14));
        add(cardText);

        // pin number 
        JLabel pinNo = new JLabel("PIN : ");
        pinNo.setFont(new Font("Raleway", Font.BOLD, 26));
        pinNo.setBounds(150, 200, 200, 30);
        add(pinNo);

        pinText = new JPasswordField();
        pinText.setBounds(360, 200, 240, 30);
        pinText.setFont(new Font("Arial", Font.BOLD, 14));
        add(pinText);

        // Buttons 
        loginButton = new JButton("SIGN IN");
        loginButton.setBounds(360, 300, 100, 30);
        loginButton.setBackground(Color.BLACK);
        loginButton.setForeground(Color.WHITE);
        loginButton.addActionListener(this);
        add(loginButton);

        clearButton = new JButton("CLEAR");
        clearButton.setBounds(500, 300, 100, 30);
        clearButton.setBackground(Color.BLACK);
        clearButton.setForeground(Color.WHITE);
        clearButton.addActionListener((java.awt.event.ActionListener) this);
        add(clearButton);

        signUpButton = new JButton("SIGN UP");
        signUpButton.setBounds(360, 350, 240, 30);
        signUpButton.setBackground(Color.BLACK);
        signUpButton.setForeground(Color.WHITE);
        signUpButton.addActionListener((java.awt.event.ActionListener) this);
        add(signUpButton);

        setSize(800, 480);
        setVisible(true);
        setLocation(350, 200);

        getContentPane().setBackground(Color.WHITE);
    }
    public static void main(String[] args) {
        System.out.println("Hello Sahil");
        new Login();

    }

    @Override
    public void actionPerformed(ActionEvent ae) {

        if(ae.getSource() == clearButton){
            cardText.setText("");
            pinText.setText("");
        }
        else if (ae.getSource() == loginButton) {
            Conn conn = new Conn();
            String cardNumber = cardText.getText();
            @SuppressWarnings("deprecation")
            String pinNumber = pinText.getText();
            String query = "select * from login where cardNumber = '" +cardNumber+ "' and pinNumber = '" +pinNumber+ "'";

            try{
                ResultSet rs = conn.s.executeQuery(query);
                if(rs.next()){
                    setVisible(false);
                    new transactions(cardNumber, pinNumber).setVisible(true);
                }
                else{
                    JOptionPane.showMessageDialog(null, "Incorrect Card number or Pin");
                }
            }
            catch(Exception e){
                System.out.println(e);
            }
        }
        else if(ae.getSource() == signUpButton){
            setVisible(false);
            new signUpOne().setVisible(true); 
        }
    }
}
