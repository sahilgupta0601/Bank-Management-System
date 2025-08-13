package com.example;

import java.awt.Color;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class balanceEnquiry extends JFrame implements ActionListener{

    String cardNumber, pinNumber;   
    JButton back;

    balanceEnquiry(String cardNumber, String pinNumber){
        setLayout(null);
        this.cardNumber = cardNumber;
        this.pinNumber = pinNumber;

        ImageIcon i1 = new ImageIcon(getClass().getResource("/com/example/icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);

        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 900, 900);
        add(image);

        back = new JButton("Back");
        back.setBounds(355, 520, 150, 30);
        back.addActionListener(this);
        image.add(back);

        int balance = 0;
        try{
            Conn conn = new Conn();
            ResultSet rs = conn.s.executeQuery("select * from bank where cardNumber = '"+cardNumber+"' ");
            while(rs.next()){
                if(rs.getString("type").equals("Deposit")){
                    balance += Integer.parseInt(rs.getString("amount"));
                }
                else {
                    balance -= Integer.parseInt(rs.getString("amount"));
                }
            }
        }
        catch(Exception e){
            System.out.println(e);
        }

        JLabel balanceAmount = new JLabel("Your current account balance is Rs " + balance);
        balanceAmount.setForeground(Color.WHITE);
        balanceAmount.setBounds(170, 300, 400, 30);
        image.add(balanceAmount);

        setSize(900, 900);
        setLocation(350, 0);
        setUndecorated(true);
        setVisible(true);

    }
    public static void main(String[] args) {
        new balanceEnquiry("", "");
    }

    @Override
    public void actionPerformed(ActionEvent ae){
        setVisible(false);

        new transactions(cardNumber, pinNumber).setVisible(true);
    }
}
