/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package loanclient;

import bean.LoanBeanRemote;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.event.ActionEvent;
import javafx.geometry.Insets; 
import javafx.geometry.Pos; 
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane; 
import javafx.scene.text.Text; 
import javafx.scene.control.TextField; 
import javafx.stage.Stage;
/**
 *
 * @author Nianhuan Chen
 */
public class Main extends Application {
    
    @javax.ejb.EJB
    private static LoanBeanRemote loanBean;
    
    @Override
    public void start(Stage stage) {
      //creating texts
      Text text1 = new Text("annualInterestRate");       
      Text text2 = new Text("numberOfYears"); 
      Text text3 = new Text("loanAmount"); 
      Text text4 = new Text("monthlyPayment");
      Text text5 = new Text("totalAmount");
      
      // creating labels
      Label monthlyPayment = new Label("MonthlyPayment");
      Label totalPayment = new Label("totalPayment");
	  
      //Creating Text Filed for three inputs        
      TextField textField1 = new TextField();              
      TextField textField2 = new TextField();  
      TextField textField3 = new TextField();
       
      //Creating Buttons 
      Button button1 = new Button("Calculate"); 
      
      // Calculate the monthly payment and total payment when button is clicked
      button1.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                double annualInterestRate_d = Double.parseDouble(textField1.getText());
                int numberOfYears_i = Integer.parseInt(textField2.getText());
                double loanAmount_d = Double.parseDouble(textField3.getText());
                
                double m_result= loanBean.MonthlyPaymentBean(annualInterestRate_d, numberOfYears_i, loanAmount_d);
                double t_result = loanBean.GetTotalPaymentBean();
                
                System.out.println(monthlyPayment + " " + totalPayment);
                monthlyPayment.setText("" + m_result);
                totalPayment.setText("" + t_result);               
            }
        });
        
        //Creating a Grid Pane 
      GridPane gridPane = new GridPane();    
      
      //Setting size for the pane  
      gridPane.setMinSize(400, 200); 
       
      //Setting the padding  
      gridPane.setPadding(new Insets(10, 10, 10, 10)); 
      
      //Setting the vertical and horizontal gaps between the columns 
      gridPane.setVgap(5); 
      gridPane.setHgap(5);       
      
      //Setting the Grid alignment 
      gridPane.setAlignment(Pos.CENTER); 
      //Arranging all the nodes in the grid 
      gridPane.add(text1, 0, 0); 
      gridPane.add(textField1, 1, 0); 
      gridPane.add(button1, 2, 0);
      gridPane.add(text2, 0, 1);       
      gridPane.add(textField2, 1, 1); 
      gridPane.add(text3, 0, 2);
      gridPane.add(textField3, 1, 2); 
      gridPane.add(text4,0,3);
      gridPane.add(text5,0,4);
      gridPane.add(monthlyPayment, 1, 3);
      gridPane.add(totalPayment, 1, 4);
      
      
      //Creating a scene object 
      Scene scene = new Scene(gridPane);  
      
      //Setting title to the Stage 
      stage.setTitle("Loan Calculation"); 
         
      //Adding scene to the stage 
      stage.setScene(scene); 
         
      //Displaying the contents of the stage 
      stage.show(); 
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}

