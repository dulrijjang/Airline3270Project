package edu.gsu.GUI;

import edu.gsu.bizlogic.BizLogicProcess;
import edu.gsu.common.Customer;
import edu.gsu.exceptions.LoginException;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

import static edu.gsu.db.DBQuery.login;

public class LoginPanel extends JPanel {

    private JButton login;
    private JButton register;
    private JLabel username;
    private JLabel password;
    private JButton forgot;
    private JTextField usnText;
    private JPasswordField pswText;

    private Customer c1 = new Customer();

    public LoginPanel(){

        //setPreferredSize(new Dimension(300, 200));
        //setBackground(Color.WHITE);
        //setLayout(null);

        //login = new JButton("Login");
        //register = new JButton("Register");
        //username = new JLabel("Username: ");
        //password = new JLabel("Password: ");
        //forgot = new JButton("Forgot my password");
        //usnText = new JTextField(25);
        //pswText = new JPasswordField(25);

        //username.setBounds(20, 30, 75, 20);
        //add(username);

        //usnText.setBounds(105, 30, 150, 20);
        //add(usnText);

        //password.setBounds(20, 65, 75, 20);
        //add(password);

        //pswText.setBounds(105, 65, 150, 20);
        //add(pswText);

        //login.setBounds(55, 100, 85, 20);
        //add(login);

        //register.setBounds(155, 100, 85, 20);
        //add(register);

        //forgot.setBounds(55, 135, 185, 20);
        //add(forgot);

        //login.addActionListener(new ButtonListener());
        //register.addActionListener(new ButtonListener());
        //forgot.addActionListener(new ButtonListener());




    }

    class ButtonListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent event) {

            if(event.getSource() == login) {

                String loginID = usnText.getText();
                String psw = pswText.getText();

                System.out.print(loginID + "," + psw);

                c1.setLoginID(loginID);
                c1.setPassword(psw);
                c1.setAction("login");

                try {
                    BizLogicProcess.process(c1);
                } catch (LoginException e) {
                    System.out.print(e);
                } catch (Exception e) {
                    System.out.print(e);
                }




            } else if (event.getSource() == register) {

                JFrame frame = new JFrame("BoBo Tour Registration");
                frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
                RegisterPanel panel = new RegisterPanel();
                frame.getContentPane().add(panel);
                frame.pack();
                frame.setVisible(true);

            } else if (event.getSource() == forgot) {

                JFrame frame = new JFrame("Forgot Password");
                frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
                ForgotPanel panel = new ForgotPanel();
                frame.getContentPane().add(panel);
                frame.pack();
                frame.setVisible(true);


            }
        }
    }


}
