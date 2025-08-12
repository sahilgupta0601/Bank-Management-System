package com.example;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class signUpTwo extends JFrame implements ActionListener{
    JTextField panText, aadharText;
    JRadioButton syes, sno, eyes, eno;
    JButton next;
    @SuppressWarnings("rawtypes")
    JComboBox religionText, occupationText, qualificationText, categoryText, incomeText;
    String formno; 
    @SuppressWarnings({ "rawtypes", "unchecked" })
    signUpTwo(String formno) {
        this.formno = formno;
        setLayout(null);

        setTitle("NEW ACCOUNT APPLICATION FORM - PAGE 2");

        JLabel additionalDetails = new JLabel("Page 2 : Additional Details");
        additionalDetails.setFont(new Font("Raleway", Font.BOLD, 22));
        additionalDetails.setBounds(290, 80, 400, 30);
        add(additionalDetails);

        JLabel religion = new JLabel("Religion:");
        religion.setFont(new Font("Raleway", Font.BOLD, 20));
        religion.setBounds(100, 140, 200, 30);
        add(religion);

        String valReligion[] = {"Hindu", "Sikh", "Christian", "Muslim", "Others"};
        religionText = new JComboBox(valReligion);
        religionText.setBounds(300, 140, 400, 30);
        religionText.setBackground(Color.WHITE);
        add(religionText);

        JLabel category = new JLabel("Category:");
        category.setFont(new Font("Raleway", Font.BOLD, 20));
        category.setBounds(100, 190, 200, 30);
        add(category);

        String valCaterogry[] = {"General", "OBC", "SC", "ST", "Others"};
        categoryText = new JComboBox(valCaterogry);
        categoryText.setBounds(300, 190, 400, 30);
        categoryText.setBackground(Color.WHITE);
        add(categoryText);


        JLabel income = new JLabel("Income:");
        income.setFont(new Font("Raleway", Font.BOLD, 20));
        income.setBounds(100, 240, 200, 30);
        add(income);

        String valIncome[] = {"Null", "<2,50,000", "<5,00,000", "<10,00,000", "10 lakh and above"};
        incomeText = new JComboBox(valIncome);
        incomeText.setBounds(300, 240, 400, 30);
        incomeText.setBackground(Color.WHITE);
        add(incomeText);
        

        JLabel qualification = new JLabel("Qualification:");
        qualification.setFont(new Font("Raleway", Font.BOLD, 20));
        qualification.setBounds(100, 290, 200, 30);
        add(qualification);

        String valeducation[] = {"Non-graduate", "Graduate", "Post-Graduate", "Doctorate", "Others"};
        qualificationText = new JComboBox(valeducation);
        qualificationText.setBounds(300, 290, 400, 30);
        qualificationText.setBackground(Color.WHITE);
        add(qualificationText);

        JLabel occupation = new JLabel("Occupation:");
        occupation.setFont(new Font("Raleway", Font.BOLD, 20));
        occupation.setBounds(100, 340, 200, 30);
        add(occupation);

        String valOccupation[] = {"Salaried", "Self Employed", "Bussiness", "Student", "Retired", "Others"};
        occupationText = new JComboBox(valOccupation);
        occupationText.setBounds(300, 340, 400, 30);
        occupationText.setBackground(Color.WHITE);
        add(occupationText);

        JLabel pan = new JLabel("PAN:");
        pan.setFont(new Font("Raleway", Font.BOLD, 20));
        pan.setBounds(100, 440, 200, 30);
        add(pan);

        panText = new JTextField();
        panText.setFont(new Font("Raleway", Font.BOLD, 14));
        panText.setBounds(300, 440, 400, 30);
        add(panText);

        JLabel aadhar = new JLabel("Aadhar Number:");
        aadhar.setFont(new Font("Raleway", Font.BOLD, 20));
        aadhar.setBounds(100, 490, 200, 30);
        add(aadhar);

        aadharText = new JTextField();
        aadharText.setFont(new Font("Raleway", Font.BOLD, 14));
        aadharText.setBounds(300, 490, 400, 30);
        add(aadharText);


        JLabel seniorCitizen = new JLabel("Senior Citizen:");
        seniorCitizen.setFont(new Font("Raleway", Font.BOLD, 20));
        seniorCitizen.setBounds(100, 540, 200, 30);
        add(seniorCitizen);

        sno = new JRadioButton("No");
        sno.setBounds(300, 540, 100, 30);
        sno.setBackground(Color.WHITE);
        add(sno);

        syes = new JRadioButton("Yes");
        syes.setBounds(450, 540, 100, 30);
        syes.setBackground(Color.WHITE);
        add(syes);

        ButtonGroup seniorCitizenBtn = new ButtonGroup();
        seniorCitizenBtn.add(syes);
        seniorCitizenBtn.add(sno);

        JLabel existingAccount = new JLabel("Existing Account:");
        existingAccount.setFont(new Font("Raleway", Font.BOLD, 20));
        existingAccount.setBounds(100, 590, 200, 30);
        add(existingAccount);

        eno = new JRadioButton("No");
        eno.setBounds(300, 590, 100, 30);
        eno.setBackground(Color.WHITE);
        add(eno);

        eyes = new JRadioButton("Yes");
        eyes.setBounds(450, 590, 100, 30);
        eyes.setBackground(Color.WHITE);
        add(eyes);

        ButtonGroup existingAccountBtn = new ButtonGroup();
        existingAccountBtn.add(syes);
        existingAccountBtn.add(sno);

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
        new signUpTwo("");
    }
    @Override
    public void actionPerformed(ActionEvent ae) {
        String religion = (String) religionText.getSelectedItem();
        String category = (String) categoryText.getSelectedItem();
        String income = (String) incomeText.getSelectedItem();
        String qualification = (String) qualificationText.getSelectedItem();
        String occupation = (String) occupationText.getSelectedItem();
        String seniorCitizen = null;
        if(syes.isSelected()){
            seniorCitizen = "YES";
        }
        else if (sno.isSelected()) {
            seniorCitizen = "NO";
        }

        String existingAccount = null;
        if(eyes.isSelected()){
            existingAccount = "YES";
        }
        else if(eno.isSelected()){
            existingAccount = "NO";
        }

        String pan = panText.getText();
        String aadhar = aadharText.getText();


       try {
            Conn c = new Conn();
            if (c.s != null) {  // ✅ Ensure statement is not null
                String query = "INSERT INTO signuptwo VALUES('" + formno + "', '" + religion + "', '" + category + "', '" + income + "', '" + qualification + "', '" + occupation + "', '" + pan + "', '" + aadhar + "','" + seniorCitizen + "', '" + existingAccount + "')";
                c.s.executeUpdate(query);
            } else {
                System.out.println("Statement not initialized. Check connection.");
            }

            setVisible(false);
            new signUpThree(formno).setVisible(true);

    } catch(Exception e){
        System.out.println("SQL Error: " + e);
    }
    }
}
