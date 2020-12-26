package edu.gsu.GUI;

import edu.gsu.bizlogic.BizLogicProcess;
import edu.gsu.common.Action;
import edu.gsu.common.Customer;
import edu.gsu.db.DBQuery;
import edu.gsu.exceptions.LoginException;
import edu.gsu.GUI.AccountPanel;
import edu.gsu.GUI.PopUP;
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

    
    public void btLoginAction (String loginID, String psw) throws Exception {
		
    
    	System.out.println(loginID + "," + psw);
    		
    	c1.setLoginID(loginID);
    	c1.setPassword(psw);
    	c1.setAction(Action.LOGIN);
    	
    	
    	
    	boolean successLogin = PopUP.confirmation(c1);
    	
    	if (successLogin) {
    		
    		DBQuery.login(c1);
    		System.out.println("Welcome back!");
    		c1.setAction(Action.GET_FLIGHTS);
    		successLogin = PopUP.confirmation(c1);
    		
    		if (successLogin) {
    			
    			Stage stage = (Stage) sp.btLogin.getScene().getWindow();
    			stage.close();
    			
    			AccountPanel ap = new AccountPanel(c1);
    			
    			try {
    				
    				ap.start(new Stage());
    				
    			}
    			
    			catch (Exception e) {
    				
    				e.printStackTrace();
    				
    			}
    			
    			
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
