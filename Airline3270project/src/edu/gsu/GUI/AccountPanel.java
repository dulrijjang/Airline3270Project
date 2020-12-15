package edu.gsu.GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class AccountPanel extends JPanel {

    private JButton booking;
    private JButton reservation;
    private JButton update;

    public AccountPanel(){

        setPreferredSize(new Dimension(300, 200));
        setBackground(Color.WHITE);
        setLayout(null);

        booking = new JButton("Book a Flight");
        reservation = new JButton("See Reserved Flights");
        update = new JButton("Update a Flight");

        booking.setBounds(20, 20, 260, 45);
        add(booking);
        booking.addActionListener(new AccountPanel.ButtonListener());

        reservation.setBounds(20, 70, 260, 45);
        add(reservation);
        reservation.addActionListener(new AccountPanel.ButtonListener());

        update.setBounds(20, 120, 260, 45);
        add(update);
        update.addActionListener(new AccountPanel.ButtonListener());
    }

    class ButtonListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent event) {

            if(event.getSource() == booking) {

                JFrame frame = new JFrame("BoBo Tour Bookings");
                frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
                BookingPanel panel = new BookingPanel();
                frame.getContentPane().add(panel);
                frame.pack();
                frame.setVisible(true);

            } else if (event.getSource() == reservation) {

                JFrame frame = new JFrame("BoBo Tour Reservations");
                frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
                ReservationPanel panel = new ReservationPanel();
                frame.getContentPane().add(panel);
                frame.pack();
                frame.setVisible(true);

            } else if (event.getSource() == update) {

            }

        }
    }

}
