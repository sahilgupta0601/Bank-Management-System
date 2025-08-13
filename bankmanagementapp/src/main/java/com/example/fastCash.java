package com.example;

import java.awt.*;
import java.awt.event.*;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.Date;

import javax.swing.*;

public class fastCash extends JFrame implements ActionListener{

    JButton rupeeHundred, rupeeFivehundred, rupeeThousand, rupeeTwothousand, rupeeFivethousand, rupeeTenthousand, back;
    String pinNumber;
    String cardNumber;
    fastCash(String cardNumber, String pinNumber){
        setLayout(null);
        this.pinNumber = pinNumber;
        this.cardNumber = cardNumber;

        ImageIcon i1 = new ImageIcon(getClass().getResource("/com/example/icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);

        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 900, 900);
        add(image);

        JLabel text = new JLabel("Select Withdrawl amount");
        text.setBounds(215, 300, 700, 35);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System", Font.BOLD, 16));
        image.add(text);

        rupeeHundred = new JButton("Rs 100");
        rupeeHundred.setBounds(170, 415, 150, 30);
        rupeeHundred.addActionListener(this);
        image.add(rupeeHundred);

        rupeeFivehundred = new JButton("Rs 500");
        rupeeFivehundred.setBounds(355, 415, 150, 30);
        rupeeFivehundred.addActionListener(this);
        image.add(rupeeFivehundred);

        rupeeThousand = new JButton("Rs 1000");
        rupeeThousand.setBounds(170, 450, 150, 30);
        rupeeThousand.addActionListener(this);
        image.add(rupeeThousand);

        rupeeTwothousand = new JButton("Rs 2000");
        rupeeTwothousand.setBounds(355, 450, 150, 30);
        rupeeTwothousand.addActionListener(this);
        image.add(rupeeTwothousand);

        rupeeFivethousand = new JButton("Rs 5000");
        rupeeFivethousand.setBounds(170, 485, 150, 30);
        rupeeFivethousand.addActionListener(this);
        image.add(rupeeFivethousand);

        rupeeTenthousand = new JButton("Rs 10000");
        rupeeTenthousand.setBounds(355, 485, 150, 30);
        rupeeTenthousand.addActionListener(this);
        image.add(rupeeTenthousand);

        back = new JButton("Back");
        back.setBounds(355, 520, 150, 30);
        back.addActionListener(this);
        image.add(back);

        setSize(900, 900);
        setLocation(300, 0);
        setUndecorated(true);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()  == back){
            setVisible(false);

            new transactions(cardNumber, pinNumber).setVisible(true);
        }
        else{
            String amount = ((JButton)ae.getSource()).getText().substring(3);
            try{
                Conn conn = new Conn();
                ResultSet rs = conn.s.executeQuery("select * from bank where cardnumber = '"+cardNumber+"'");
                int balance = 0;
                while(rs.next()){
                    if(rs.getString("type").equals("Deposit")){
                        balance += Integer.parseInt(rs.getString("amount"));
                    }
                    else{
                        balance -= Integer.parseInt(rs.getString("amount"));
                    }
                }
                
                if(ae.getSource() != back && balance < Integer.parseInt(amount)){
                    JOptionPane.showConfirmDialog(null, "Insufficient Balance");
                    return ;
                }
                Date date = new Date();
                String query = "insert into bank values('"+cardNumber+"', '"+pinNumber+"', '"+date+"', 'Withdraw', '"+amount+"')";
                conn.s.executeUpdate(query);

                JOptionPane.showMessageDialog(null, "Rs " + amount + " Debited successfully");

                setVisible(false);

                new transactions(cardNumber, pinNumber).setVisible(true);
            }
            catch (Exception e){
                System.out.println(e);
            }
        }
    }
    public static void main(String[] args) {
        new fastCash("", "");
    }
}
