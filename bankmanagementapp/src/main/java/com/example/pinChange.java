package com.example;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class pinChange extends JFrame implements ActionListener {

    JButton change, back;
    JPasswordField pin, repin;
    String cardNumber, pinNumber;

    pinChange(String cardNumber, String pinNumber){
        setLayout(null);
        this.cardNumber = cardNumber;
        this.pinNumber = pinNumber;

        ImageIcon i1 = new ImageIcon(getClass().getResource("/com/example/icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);

        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 900, 900);
        add(image);

        JLabel pinChangeText = new JLabel("CHANGE YOUR PIN");
        pinChangeText.setForeground(Color.WHITE);
        pinChangeText.setFont(new Font("System", Font.BOLD, 16));
        pinChangeText.setBounds(250, 280, 500, 35);
        image.add(pinChangeText);

        JLabel pinText = new JLabel("NEW PIN: ");
        pinText.setForeground(Color.WHITE);
        pinText.setFont(new Font("System", Font.BOLD, 16));
        pinText.setBounds(165, 320, 150, 30);
        image.add(pinText);

        pin = new JPasswordField();
        pin.setFont(new Font("Raleway", Font.BOLD, 16));
        pin.setBounds( 350, 320, 150, 30);
        image.add(pin);

        JLabel repinText = new JLabel("RE ENTER NEW PIN: ");
        repinText.setForeground(Color.WHITE);
        repinText.setFont(new Font("System", Font.BOLD, 16));
        repinText.setBounds(165, 360, 180, 30);
        image.add(repinText);

        repin = new JPasswordField();
        repin.setFont(new Font("Raleway", Font.BOLD, 16));
        repin.setBounds( 350, 360, 150, 30);
        image.add(repin);

        change = new JButton("CHANGE");
        change.setBounds(355, 485, 150 ,30);
        change.addActionListener(this);
        image.add(change);

        back = new JButton("BACK");
        back.setBounds(355, 520, 150 ,30);
        back.addActionListener(this);
        image.add(back);

        setSize(900, 900);
        setLocation(350, 0);
        setVisible(true);


    }
    public static void main(String[] args) {
        new pinChange("", "");
    }

    @Override
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == change){
            try{
                String npin = pin.getText();
                String rpin = repin.getText();

                if(!npin.equals(rpin)){
                    JOptionPane.showMessageDialog(null, "Entered PIN does not match");
                    return ;
                }

                if(npin.equals("")){
                    JOptionPane.showMessageDialog(null, "Please enter New PIN");
                    return ;
                }

                if(rpin.equals("")){
                    JOptionPane.showMessageDialog(null, "Please re-enter New PIN");
                    return ;
                }

                if(npin.length() != 4){
                    JOptionPane.showMessageDialog(null, "PIN should be of exactly 4 digits");
                    return;
                }

                Conn conn = new Conn();
                String query1 = "update bank set pin = '"+npin+"' where cardnumber = '"+cardNumber+"'";
                String query2 = "update login set pinNumber = '"+npin+"' where cardNumber = '"+cardNumber+"'";
                String query3 = "update signupthree set pinNumber = '"+npin+"' where cardNumber = '"+cardNumber+"'";

                conn.s.executeUpdate(query1);
                conn.s.executeUpdate(query2);
                conn.s.executeUpdate(query3);

                JOptionPane.showMessageDialog(null, "PIN Changed successfully");

                setVisible(false);

                new transactions(cardNumber, npin);
                
            }
            catch(Exception e){
                System.out.println(e);
            }
        }
        else if(ae.getSource() == back){
            setVisible(false);

            new transactions(cardNumber, pinNumber).setVisible(true);
        }
        
    }
}
