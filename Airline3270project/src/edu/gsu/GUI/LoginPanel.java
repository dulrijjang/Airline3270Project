package edu.gsu.GUI;

import edu.gsu.bizlogic.BizLogicProcess;
import edu.gsu.common.Customer;
import edu.gsu.exceptions.LoginException;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

import static edu.gsu.db.DBQuery.login;



public class LoginPanel extends Application {
	
	Stage window;
	
	StartingPanel sp = new StartingPanel();
	
    private Customer c1 = new Customer();

    public LoginPanel() {
    	
    
    }
    
	public void btLoginAction (ActionEvent event) {
		
		 if(event.getSource() == sp.btLogin) {
    		
    		String loginID = sp.tfname.getText();
    		String psw = sp.pfpsw.getText();
    		
    		System.out.println(loginID + "," + psw);
    		
    		c1.setLoginID(loginID);
    		c1.setPassword(psw);
    		c1.setAction("login");
    		
    		try {
    			
    			BizLogicProcess.process1(c1);
    			
    		}
    		
    		catch (LoginException e) {
    			
    			System.out.println(e);
    			
    		}
    		
    		catch (Exception e) {
    			
    			System.out.println(e);
    			
    		}
		 }
    		
	}
    	

	
//  class ButtonListener implements ActionListener {

 //      @Override
   //    public void actionPerformed(ActionEvent event) {

   //        if(event.getSource() == login) {

  //             String loginID = usnText.getText();
   //            String psw = pswText.getText();

     //          System.out.print(loginID + "," + psw);

   //            c1.setLoginID(loginID);
   //            c1.setPassword(psw);
    //           c1.setAction("login");

   //            try {
   //                BizLogicProcess.process(c1);
  //             } catch (LoginException e) {
    //               System.out.print(e);
   //            } catch (Exception e) {
   //                System.out.print(e);
   //            }




   //        } else if (event.getSource() == register) {

   //            JFrame frame = new JFrame("BoBo Tour Registration");
   //            frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
    //           RegisterPanel panel = new RegisterPanel();
   //            frame.getContentPane().add(panel);
   //            frame.pack();
   //            frame.setVisible(true);

   //        } else if (event.getSource() == forgot) {

   //            JFrame frame = new JFrame("Forgot Password");
   //            frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
   //           ForgotPanel panel = new ForgotPanel();
   //            frame.getContentPane().add(panel);
  //             frame.pack();
   //            frame.setVisible(true);


  //         }
    //   }
 //  }
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		
	}

}
