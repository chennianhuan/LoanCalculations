/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import javax.ejb.Remote;

/**
 *
 * @author Nianhuan Chen
 */
@Remote
public interface LoanBeanRemote {

    double MonthlyPaymentBean(double annualInterestRate, int numberOfYears, double loanAmount);
    double GetTotalPaymentBean();
}
