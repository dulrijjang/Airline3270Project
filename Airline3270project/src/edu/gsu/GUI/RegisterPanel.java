package edu.gsu.GUI;

import edu.gsu.common.Customer;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;

import static edu.gsu.bizlogic.BizLogicProcess.process;

public class RegisterPanel extends JPanel {

    private Customer c1 = new Customer();

    private JButton create;
    private JLabel username ;
    private JLabel password;
    private JLabel firstName;
    private JLabel lastName;
    private JLabel email;
    private JLabel address;
    private JLabel zip;
    private JLabel state;
    private JLabel ssn;
    private JLabel securityQ;
    private JLabel securityA;
    private JTextField usnText;
    private JTextField pswText;
    private JTextField firstNameTxt;
    private JTextField lastNameTxt;
    private JTextField emailTxt;
    private JTextField addressTxt;
    private JTextField zipTxt;
    private JTextField stateTxt;
    private JTextField ssnTxt;
    private JTextField securityQTxt;
    private JTextField securityATxt;
    private int royaltyNumber;

    public RegisterPanel(){

        setPreferredSize(new Dimension(400, 450));
        setBackground(Color.WHITE);
        setLayout(null);

        create = new JButton("Create Account");
        create.addActionListener(new RegisterPanel.ButtonListener());

        username = new JLabel("Username: ");
        password = new JLabel("Password: ");
        firstName = new JLabel("First name: ");
        lastName = new JLabel("Last name: ");
        email = new JLabel("E-mail: ");
        address = new JLabel("Street address: ");
        zip = new JLabel("ZIP Code: ");
        state = new JLabel("State: ");
        ssn = new JLabel("SSN: ");
        securityQ = new JLabel("Security Question: ");
        securityA = new JLabel("Answer: ");

        usnText = new JTextField(200);
        pswText = new JTextField(200);
        firstNameTxt = new JTextField(200);
        lastNameTxt = new JTextField(200);
        emailTxt = new JTextField(200);
        addressTxt = new JTextField(200);
        zipTxt = new JTextField(200);
        stateTxt = new JTextField(200);
        ssnTxt = new JTextField(200);
        securityQTxt = new JTextField(300);
        securityATxt = new JTextField(300);

        username.setBounds(20, 30, 75, 20);
        add(username);

        usnText.setBounds(150, 30, 200, 20);
        add(usnText);

        password.setBounds(20, 60, 75, 20);
        add(password);

        pswText.setBounds(150, 60, 200, 20);
        add(pswText);

        firstName.setBounds(20, 90, 75, 20);
        add(firstName);

        firstNameTxt.setBounds(150, 90, 200, 20);
        add(firstNameTxt);

        lastName.setBounds(20, 120, 75, 20);
        add(lastName);

        lastNameTxt.setBounds(150, 120, 200, 20);
        add(lastNameTxt);

        email.setBounds(20, 150, 75, 20);
        add(email);

        emailTxt.setBounds(150, 150, 200, 20);
        add(emailTxt);

        address.setBounds(20, 180, 100, 20);
        add(address);

        addressTxt.setBounds(150, 180, 200, 20);
        add(addressTxt);

        zip.setBounds(20, 210, 75, 20);
        add(zip);

        zipTxt.setBounds(150, 210, 200, 20);
        add(zipTxt);

        state.setBounds(20, 240, 75, 20);
        add(state);

        stateTxt.setBounds(150, 240, 200, 20);
        add(stateTxt);

        ssn.setBounds(20, 270, 75, 20);
        add(ssn);

        ssnTxt.setBounds(150, 270, 200, 20);
        add(ssnTxt);

        securityQ.setBounds(20, 300, 120, 20);
        add(securityQ);

        securityQTxt.setBounds(150, 300, 200, 20);
        add(securityQTxt);

        securityA.setBounds(20, 330, 100, 20);
        add(securityA);

        securityATxt.setBounds(150, 330, 200, 20);
        add(securityATxt);

        create.setBounds(100, 375, 200, 25);
        add(create);


    }
    private class ButtonListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent event) {

                Random rand = new Random();
                String royaltyNumber = rand.nextInt(10000) + "";

                c1.setRoyaltyNumber(royaltyNumber); // royaltyNumber;
                c1.setFirstName(firstNameTxt.getText()); // firstName;
                c1.setLastName(lastNameTxt.getText()); // lastName;
                c1.setLoginID(usnText.getText()); // loginID;
                c1.setPassword(pswText.getText()); // password;
                c1.setEmail(emailTxt.getText()); // email;
                c1.setAddress(addressTxt.getText()); // address;
                c1.setZip(zipTxt.getText()); // zip;
                c1.setState(stateTxt.getText()); //state;
                c1.setSSN(ssnTxt.getText()); //ssn;
                c1.setSecurityQ(securityQTxt.getText()); // securityQ;
                c1.setSecurityA(securityATxt.getText()); // securityA;

                c1.setAction("register");

                try {
                    process(c1);
                } catch (Exception e) {
                    e.printStackTrace();
                }

        }

    }
}
