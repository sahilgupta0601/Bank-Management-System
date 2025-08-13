package com.example;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.*;

public class signUpThree extends JFrame implements ActionListener{

    JRadioButton saving, fixed, current, recurring;
    JCheckBox hearby, emessage, internetBanking, mobileBanking, atmCard, sms, checkbook; 
    JButton submit, cancel;
    String formno;

    signUpThree(String formno){
        setLayout(null);
        this.formno = formno;

        JLabel l1 = new JLabel("Page 3 : Account Details");
        l1.setFont(new Font("Raleway", Font.BOLD, 22));
        l1.setBounds(280, 40, 400, 40);
        add(l1);

        JLabel accountType = new JLabel("Account Type");
        accountType.setFont(new Font("Raleway", Font.BOLD, 22));
        accountType.setBounds(100, 140, 200, 30);
        add(accountType);

        saving = new JRadioButton("Savings Account");
        saving.setFont(new Font("Raleway", Font.BOLD, 16));
        saving.setBounds(100, 200, 250, 30);
        add(saving);

        fixed = new JRadioButton("Fixed Deposit Account");
        fixed.setFont(new Font("Raleway", Font.BOLD, 16));
        fixed.setBounds(100, 250, 250, 30);
        add(fixed);

        current = new JRadioButton("Current Account");
        current.setFont(new Font("Raleway", Font.BOLD, 16));
        current.setBounds(370, 200, 250, 30);
        add(current);

        recurring = new JRadioButton("Recurring Deposit Account");
        recurring.setFont(new Font("Raleway", Font.BOLD, 16));
        recurring.setBounds(370, 250, 250, 30);
        add(recurring);

        ButtonGroup accountBtn = new ButtonGroup();
        accountBtn.add(saving);
        accountBtn.add(current);
        accountBtn.add(fixed);
        accountBtn.add(recurring);

        JLabel card = new JLabel("Card Number: ");
        card.setFont(new Font("Raleway", Font.BOLD, 22));
        card.setBounds(100, 320, 200, 40);
        add(card);

        JLabel cardnumber = new JLabel("XXXX-XXXX-XXXX-5620");
        cardnumber.setFont(new Font("Raleway", Font.BOLD, 22));
        cardnumber.setBounds(370, 320, 300, 40);
        add(cardnumber);

        JLabel cardDetail = new JLabel("(Your 16 Digit card Number)");
        cardDetail.setFont(new Font("Raleway", Font.BOLD, 12));
        cardDetail.setBounds(100, 340, 300, 40);
        add(cardDetail);

        JLabel pin = new JLabel("PIN: ");
        pin.setFont(new Font("Raleway", Font.BOLD, 22));
        pin.setBounds(100, 380, 200, 40);
        add(pin);

        JLabel pinnumber = new JLabel("XXXX");
        pinnumber.setFont(new Font("Raleway", Font.BOLD, 22));
        pinnumber.setBounds(370, 380, 300, 40);
        add(pinnumber);

        JLabel pinDetail = new JLabel("(Your 4 Digit pin number)");
        pinDetail.setFont(new Font("Raleway", Font.BOLD, 12));
        pinDetail.setBounds(100, 400, 200, 40);
        add(pinDetail);

        JLabel services = new JLabel("Services Required: ");
        services.setFont(new Font("Raleway", Font.BOLD, 22));
        services.setBounds(100, 450, 300, 40);
        add(services);

        atmCard = new JCheckBox("ATM CARD");
        atmCard.setBackground(Color.WHITE);
        atmCard.setFont(new Font("Raleway", Font.BOLD, 16));
        atmCard.setBounds(100, 500, 200, 40);
        add(atmCard);

        internetBanking = new JCheckBox("Internet Banking");
        internetBanking.setBackground(Color.WHITE);
        internetBanking.setFont(new Font("Raleway", Font.BOLD, 16));
        internetBanking.setBounds(400, 500, 200, 40);
        add(internetBanking);

        mobileBanking = new JCheckBox("Mobile Banking");
        mobileBanking.setBackground(Color.WHITE);
        mobileBanking.setFont(new Font("Raleway", Font.BOLD, 16));
        mobileBanking.setBounds(100, 550, 200, 40);
        add(mobileBanking);

        sms = new JCheckBox("Email & SMS Alerts");
        sms.setBackground(Color.WHITE);
        sms.setFont(new Font("Raleway", Font.BOLD, 16));
        sms.setBounds(400, 550, 200, 40);
        add(sms);

        checkbook = new JCheckBox("Check Book");
        checkbook.setBackground(Color.WHITE);
        checkbook.setFont(new Font("Raleway", Font.BOLD, 16));
        checkbook.setBounds(100, 600, 200, 40);
        add(checkbook);

        emessage = new JCheckBox("E-Statement");
        emessage.setBackground(Color.WHITE);
        emessage.setFont(new Font("Raleway", Font.BOLD, 16));
        emessage.setBounds(400, 600, 200, 40);
        add(emessage);

        hearby = new JCheckBox("I hereby declares that the above entered details are correct to the best of my knowledge");
        hearby.setBackground(Color.WHITE);
        hearby.setFont(new Font("Raleway", Font.BOLD, 12));
        hearby.setBounds(100, 680, 600, 30);
        add(hearby);

        submit = new JButton("Submit");
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.WHITE);
        submit.setFont(new Font("Raleway", Font.BOLD, 20));
        submit.setBounds(200, 740, 120, 30);
        submit.addActionListener(this);
        add(submit);

        cancel = new JButton("Cancel");
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.setFont(new Font("Raleway", Font.BOLD, 20));
        cancel.setBounds(400, 740, 120, 30);
        cancel.addActionListener(this);
        add(cancel);

        getContentPane().setBackground(Color.WHITE);

        setSize(850, 820);
        setLocation(350, 0);
        setVisible(true);


    }
    public static void main(String[] args) {
        new signUpThree("");
    }

    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == submit){
            String accountType = null;
            if(saving.isSelected()){
                accountType = "Savings Account";
            }
            else if (recurring.isSelected()){
                accountType = "Reccuring Deposit Account";
            } else if (fixed.isSelected()){
                accountType = "Fixed Deposit Account";
            } else if(current.isSelected()){
                accountType = "Current Account";
            }

            Random random = new Random();
            String cardNumber = "" + Math.abs((random.nextLong() % 90000000L) + 5040628300000000L);

            String pinNumber = String.format("%04d", random.nextInt(10000));

            String facility = "";
            if(atmCard.isSelected()){
                facility += "ATM Card, ";
            }
            if(internetBanking.isSelected()){
                facility += "Internet Banking, ";
            }
            if(mobileBanking.isSelected()){
                facility += "Mobile Banking, ";
            }
            if(sms.isSelected()){
                facility += "Email & SMS Alerts, ";
            }
            if(checkbook.isSelected()){
                facility += "Cheque Book, ";
            }
            if(emessage.isSelected()){
                facility += "E-Statement";
            }

            try{
                if(accountType.equals("")){
                    JOptionPane.showMessageDialog(null, "Account Type is Required");
                }
                else {
                    Conn conn = new Conn();
                    String query1 = "insert into signupthree values('" +formno+ "', '" +accountType+ "', '" +cardNumber+ "', '" +pinNumber+ "', '" +facility+ "')";
                    String query2 = "insert into login values('" +formno+ "', '" +cardNumber+ "', '" +pinNumber+ "')";
                    conn.s.executeUpdate(query1);
                    conn.s.executeUpdate(query2);

                    JOptionPane.showMessageDialog(null, "Card Number : " + cardNumber + "\nPin Number : " + pinNumber);

                    setVisible(false);
                    new deposit(cardNumber, pinNumber).setVisible(true);

                }
            }
            catch (Exception e){
                System.out.println(e);
            }
        }
        else if(ae.getSource() == cancel){
            setVisible(false);
            new Login().setVisible(true);
        }
    }
}
