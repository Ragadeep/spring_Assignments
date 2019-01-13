package com.moneymoney.account.service;

import java.util.logging.Logger;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Service;

import com.moneymoney.account.SavingsAccount;
import com.moneymoney.exception.InsufficientFundsException;
import com.moneymoney.exception.InvalidInputException;

@Aspect
@Service
public class savingsAccountValidation {
	Logger logger = Logger.getLogger(savingsAccountValidation.class.getName());
	
	@Around("execution(* com.moneymoney.account.service.SavingsAccountServiceImpl.deposit(..))")
	public void depositValidation(ProceedingJoinPoint pjp) throws Throwable {
		Object[] param = pjp.getArgs();
		double amount = (double) param[1];
		if(amount > 0) {
			pjp.proceed();
		}
		else {
			throw new InvalidInputException("Invalid Input Amount!"); 
		}
	}
	
	@Around("execution(* com.moneymoney.account.service.SavingsAccountServiceImpl.withdraw(..))")
	public void withdrawValidation(ProceedingJoinPoint pjp) throws Throwable {
		Object[] param = pjp.getArgs();
		SavingsAccount savingsAccount = (SavingsAccount)param[0];
		double currentBalance = savingsAccount.getBankAccount().getAccountBalance();
		double amount = (double) param[1];
		if(amount > 0 && currentBalance >= amount) {
			pjp.proceed();
		}
		else {
			throw new InvalidInputException("Invalid Input Amount!"); 
		}
	}
	
//	public void fundsTransferValida
//	
//	
//	
//	Object[] param=pjp.getArgs();
//	SavingsAccount sender = (SavingsAccount)param[0];
//	double senderBalance = sender.getBankAccount().getAccountBalance();
//	SavingsAccount receiver = (SavingsAccount)param[1];
//	//double recieverBalance=receiver.getBankAccount().getAccountBalance();
//	double amount = (Double)param[2];
//	if(sender==null ||receiver==null) {
//		logger.warning("Check the account numbers you have entered!!");
//	}
//	else if (amount<= senderBalance) {
//		pjp.proceed();
//	} else {
//		logger.warning("Withdraw amount should begreater than 0 and ");
//	}
}
