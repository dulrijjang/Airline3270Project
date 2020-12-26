package edu.gsu.GUI;

import javax.swing.*;

import edu.gsu.common.Customer;
import javafx.application.Application;
import javafx.stage.Stage;

import java.awt.*;
import java.awt.event.*;

public class AccountPanel extends Application {

    private JButton booking;
    private JButton reservation;
    private JButton update;
    
    private Customer c1;
	
	public AccountPanel (Customer c1) {
		
		this.c1 = c1;
		
		
	}

	@Override
	public void start(Stage arg0) throws Exception {
		// TODO Auto-generated method stub
		
	}

    //public AccountPanel() {

       // setPreferredSize(new Dimension(300, 200));
      //  setBackground(Color.WHITE);
      //  setLayout(null);

      //  booking = new JButton("Book a Flight");
      //  reservation = new JButton("See Reserved Flights");
      //  update = new JButton("Update a Flight");

      //  booking.setBounds(20, 20, 260, 45);
     //   add(booking);
     //   booking.addActionListener(new AccountPanel.ButtonListener());

      //  reservation.setBounds(20, 70, 260, 45);
     //   add(reservation);
     //   reservation.addActionListener(new AccountPanel.ButtonListener());

     //   update.setBounds(20, 120, 260, 45);
     //   add(update);
     //   update.addActionListener(new AccountPanel.ButtonListener());
    //}

   // class ButtonListener implements ActionListener {

      // @Override
      //  public void actionPerformed(ActionEvent event) {

       //     if(event.getSource() == booking) {

       //         JFrame frame = new JFrame("BoBo Tour Bookings");
       ///         frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
       //         BookingPanel panel = new BookingPanel();
       ///         frame.getContentPane().add(panel);
       //         frame.pack();
       //         frame.setVisible(true);

       //     } else if (event.getSource() == reservation) {

       //         JFrame frame = new JFrame("BoBo Tour Reservations");
       //        frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        //        ReservationPanel panel = new ReservationPanel();
        //        frame.getContentPane().add(panel);
       //         frame.pack();
       //         frame.setVisible(true);

         //   } else if (event.getSource() == update) {

        //    }

      //  }
  // }

}
