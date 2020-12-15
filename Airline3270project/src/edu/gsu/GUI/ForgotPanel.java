package edu.gsu.GUI;

import edu.gsu.bizlogic.BizLogicProcess;
import edu.gsu.common.Customer;
import edu.gsu.exceptions.LoginException;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ForgotPanel extends JPanel {

    private Customer c1 = new Customer();

    private JButton forgot;
    private JLabel id;
    private JLabel q;
    private JLabel a;
    private JTextField idText;
    private JTextField qText;
    private JTextField aText;

    public ForgotPanel() {

        setPreferredSize(new Dimension(350, 200));
        setBackground(Color.WHITE);
        setLayout(null);

        forgot = new JButton("Forgot Password");
        forgot.addActionListener(new ForgotPanel.ButtonListener());

        id = new JLabel("Login ID: ");
        q = new JLabel("Security Question: ");
        a = new JLabel("Answer: ");
        idText = new JTextField(300);
        qText = new JTextField(300);
        aText = new JTextField(300);

        id.setBounds(20, 30, 120, 20);
        add(id);

        idText.setBounds(145, 30, 175, 20);
        add(idText);

        q.setBounds(20, 60, 120, 20);
        add(q);

        qText.setBounds(145, 60, 175, 20);
        add(qText);

        a.setBounds(20, 90, 100, 20);
        add(a);

        aText.setBounds(145, 90, 175, 20);
        add(aText);

        forgot.setBounds(100, 150, 150, 20);
        add(forgot);
    }

    class ButtonListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent event) {

            String id = idText.getText();
            String securityQ = qText.getText();
            String securityA = aText.getText();

            c1.setLoginID(id);
            c1.setSecurityQ(securityQ);
            c1.setSecurityA(securityA);
            c1.setAction("forgot");

            try {
                BizLogicProcess.process(c1);
            } catch (LoginException e) {
                System.out.print(e);
            } catch (Exception e) {
                System.out.print(e);
            }

        }
    }
}
