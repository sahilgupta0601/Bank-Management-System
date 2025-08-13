package com.example;

import java.awt.Color;
import java.awt.Font;
import java.sql.ResultSet;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;

public class miniStatement extends JFrame{

    String cardNumber, pinNumber;
    
    miniStatement(String cardNumber, String pinNumber){
        setLayout(null);
        this.cardNumber = cardNumber;
        this.pinNumber = pinNumber;

        setTitle("Mini Statement");

        JLabel text = new JLabel("Indian Bank");
        text.setBounds(100, 30, 200, 40);
        text.setFont(new Font("Raleway", Font.BOLD, 22));
        add(text);

        JLabel card = new JLabel("Card Number : " + cardNumber);
        card.setBounds(80, 80, 200, 40);
        add(card);

        JTextArea mini = new JTextArea();
        // mini.setFont(new Font("SansSerif", Font.PLAIN, 14));
        mini.setBounds(50, 150, 300, 120); // Fits inside frame
        add(mini);

        JLabel balanceAmount = new JLabel();
        balanceAmount.setBounds(50, 300, 300, 40);
        add(balanceAmount);

        try{
            Conn conn = new Conn();

            ResultSet rs = conn.s.executeQuery("select * from bank where cardNumber = '"+cardNumber+"' order by date desc limit 5");
            while(rs.next()){
                mini.setText(mini.getText() + rs.getString("date") + "     " + rs.getString("type") + "     " + rs.getString("amount")  + "\n");
            }

            ResultSet rs1 = conn.s.executeQuery("select * from bank where cardNumber = '"+cardNumber+"'");
            int balance = 0;

            while (rs1.next()) {
                if(rs1.getString("type").equals("Deposit")){
                    balance += Integer.parseInt(rs1.getString("amount"));
                }
                else{
                    balance -= Integer.parseInt(rs1.getString("amount"));
                }
            }
            balanceAmount.setText("Your balance amount is Rs " + balance);
        }
        catch (Exception e){
            System.out.println(e);
        }

        setSize(400, 600);
        setLocation(20, 20);
        getContentPane().setBackground(Color.WHITE);
        setVisible(true);
    }
    public static void main(String[] args) {
        new miniStatement("", "");
    }
}
