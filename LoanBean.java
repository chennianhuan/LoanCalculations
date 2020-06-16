/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import javax.ejb.Stateless;

/**
 *
 * @author Nianhuan Chen
 */
@Stateless
public class LoanBean implements LoanBeanRemote {
    double monthlyPayment;
    double totalPayment;

    @Override
    public double MonthlyPaymentBean(double annualInterestRate, int numberOfYears, double loanAmount) {
        // calculating monthly payment and total payment
        double monthlyInterestRate = annualInterestRate / 1200;
        monthlyPayment = loanAmount * monthlyInterestRate / (1 -
                        (1 / Math.pow(1 + monthlyInterestRate, numberOfYears * 12)));
        totalPayment = monthlyPayment * numberOfYears * 12;
                
        return monthlyPayment;
    }
    
    // get total payment
     public double GetTotalPaymentBean(){         
         return totalPayment;
     }
    
    
}
