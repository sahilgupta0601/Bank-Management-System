package com.example;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import javax.swing.*;
import com.toedter.calendar.JDateChooser;

public class signUpOne extends JFrame implements ActionListener{

    long random;
    JTextField nameText, fnameText, addressText, cityText, stateText, pinText, emailText;
    JDateChooser datechooser;
    JRadioButton male, female, married, unmarried, other;
    JButton next;

    signUpOne() {

        setLayout(null);
        Random ran = new Random();
        random = Math.abs((ran.nextLong()%9000L) + 1000L);

        JLabel formNo = new JLabel("APPLICATION NO. " + random);
        formNo.setFont(new Font("Raleway", Font.BOLD, 38));
        formNo.setBounds(200, 20, 600, 40);
        add(formNo);


        JLabel personDetails = new JLabel("Page 1 : Personal Details");
        personDetails.setFont(new Font("Raleway", Font.BOLD, 22));
        personDetails.setBounds(290, 80, 400, 30);
        add(personDetails);


        JLabel name = new JLabel("Name:");
        name.setFont(new Font("Raleway", Font.BOLD, 20));
        name.setBounds(100, 140, 200, 30);
        add(name);

        nameText = new JTextField();
        nameText.setFont(new Font("Raleway", Font.BOLD, 14));
        nameText.setBounds(300, 140, 400, 30);
        add(nameText);


        JLabel fname = new JLabel("Father's Name:");
        fname.setFont(new Font("Raleway", Font.BOLD, 20));
        fname.setBounds(100, 190, 200, 30);
        add(fname);

        fnameText = new JTextField();
        fnameText.setFont(new Font("Raleway", Font.BOLD, 14));
        fnameText.setBounds(300, 190, 400, 30);
        add(fnameText);


        JLabel dob = new JLabel("Date of Birth:");
        dob.setFont(new Font("Raleway", Font.BOLD, 20));
        dob.setBounds(100, 240, 200, 30);
        add(dob);

        datechooser = new JDateChooser();  
        datechooser.setBounds(300, 240, 400, 30);
        add(datechooser);

        JLabel gender = new JLabel("Gender:");
        gender.setFont(new Font("Raleway", Font.BOLD, 20));
        gender.setBounds(100, 290, 200, 30);
        add(gender);

        male = new JRadioButton("Male");
        male.setBounds(300, 290, 100, 30);
        male.setBackground(Color.WHITE);
        add(male);

        female = new JRadioButton("Female");
        female.setBounds(450, 290, 100, 30);
        female.setBackground(Color.WHITE);
        add(female);

        ButtonGroup gendergroup = new ButtonGroup();
        gendergroup.add(female);
        gendergroup.add(male);

        JLabel email = new JLabel("Email Address:");
        email.setFont(new Font("Raleway", Font.BOLD, 20));
        email.setBounds(100, 340, 200, 30);
        add(email);

        emailText = new JTextField();
        emailText.setFont(new Font("Raleway", Font.BOLD, 14));
        emailText.setBounds(300, 340, 400, 30);
        add(emailText); 


        JLabel marital = new JLabel("Marital Status:");
        marital.setFont(new Font("Raleway", Font.BOLD, 20));
        marital.setBounds(100, 390, 200, 30);
        add(marital);

        married = new JRadioButton("Married");
        married.setBounds(300, 390, 100, 30);
        married.setBackground(Color.WHITE);
        add(married);

        unmarried = new JRadioButton("Unmarried");
        unmarried.setBounds(450, 390, 100, 30);
        unmarried.setBackground(Color.WHITE);
        add(unmarried);

        other = new JRadioButton("Other");
        other.setBounds(600, 390, 100, 30);
        other.setBackground(Color.WHITE);
        add(other);

        ButtonGroup maritalgroup = new ButtonGroup();
        maritalgroup.add(married);
        maritalgroup.add(unmarried);
        maritalgroup.add(other);

        JLabel address = new JLabel("Address:");
        address.setFont(new Font("Raleway", Font.BOLD, 20));
        address.setBounds(100, 440, 200, 30);
        add(address);

        addressText = new JTextField();
        addressText.setFont(new Font("Raleway", Font.BOLD, 14));
        addressText.setBounds(300, 440, 400, 30);
        add(addressText);

        JLabel city = new JLabel("City:");
        city.setFont(new Font("Raleway", Font.BOLD, 20));
        city.setBounds(100, 490, 200, 30);
        add(city);

        cityText = new JTextField();
        cityText.setFont(new Font("Raleway", Font.BOLD, 14));
        cityText.setBounds(300, 490, 400, 30);
        add(cityText);


        JLabel state = new JLabel("State:");
        state.setFont(new Font("Raleway", Font.BOLD, 20));
        state.setBounds(100, 540, 200, 30);
        add(state);

        stateText = new JTextField();
        stateText.setFont(new Font("Raleway", Font.BOLD, 14));
        stateText.setBounds(300, 540, 400, 30);
        add(stateText);

        JLabel pincode = new JLabel("Pin Code:");
        pincode.setFont(new Font("Raleway", Font.BOLD, 20));
        pincode.setBounds(100, 590, 200, 30);
        add(pincode);

        pinText = new JTextField();
        pinText.setFont(new Font("Raleway", Font.BOLD, 14));
        pinText.setBounds(300, 590, 400, 30);
        add(pinText);

        next = new JButton("Next");
        next.setBackground(Color.BLACK);
        next.setForeground(Color.WHITE);
        next.setFont(new Font("Raleway", Font.BOLD, 14));
        next.setBounds(400, 650, 70, 40);
        next.addActionListener(this);
        add(next);

        getContentPane().setBackground(Color.WHITE);
        setSize(850, 800);
        setLocation(350, 10);
        setVisible(true);
    }
    public static void main(String[] args) {
        new signUpOne();
    }
    @Override
    public void actionPerformed(ActionEvent ae) {
        String formno = "" + random;
        String name = nameText.getText();
        String fname = fnameText.getText();
        String dob = ((JTextField) datechooser.getDateEditor().getUiComponent()).getText();
        String gender = null;
        if(male.isSelected()){
            gender = "Male";
        }
        else if (male.isSelected()) {
            gender = "Female";
        }

        String email = emailText.getText();
        String maritalStatus = null;
        if(married.isSelected()){
            maritalStatus = "Married";
        }
        else if(unmarried.isSelected()){
            maritalStatus = "Unmarried";
        }
        else if(other.isSelected()){
            maritalStatus = "Other";
        }

        String address = addressText.getText();
        String city = cityText.getText();
        String state = stateText.getText();
        String pincode = pinText.getText();

       try {
        if(name.equals("")){
            JOptionPane.showMessageDialog(null, "Name is Required");
        } else {
            Conn c = new Conn();
            if (c.s != null) {  // ✅ Ensure statement is not null
                String query = "INSERT INTO signup VALUES('" + formno + "', '" + name + "', '" + fname + "', '" + dob + "', '" + gender + "', '" + email + "', '" + maritalStatus + "', '" + address + "', '" + city + "', '" + state + "', '" + pincode + "')";
                c.s.executeUpdate(query);
            } else {
                System.out.println("Statement not initialized. Check connection.");
            }

            setVisible(false);

            new signUpTwo(formno).setVisible(true);
        }
    } catch(Exception e){
        System.out.println("SQL Error: " + e);
    }
    }
}
