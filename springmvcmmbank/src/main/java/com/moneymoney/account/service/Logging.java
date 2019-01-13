package com.moneymoney.account.service;

import java.util.logging.Logger;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Service;

@Aspect
@Service
public class Logging {
	Logger logger = Logger.getLogger(Logging.class.getName());
	
	@After("execution(* com.moneymoney.account.service.SavingsAccountServiceImpl.createNewAccount(..))")
	public void createNewAccountLog() {
		logger.info("Account Was Created SuccessFully"); 
	}
	
	@After("execution(* com.moneymoney.account.service.SavingsAccountServiceImpl.updateAccount(..))")
	public void updateAccountLog() {
		logger.info("Account Details are Updated SuccessFully"); 
	}
	
	@After("execution(* com.moneymoney.account.service.SavingsAccountServiceImpl.delete(..))")
	public void deleteLog() {
		logger.info("Account was deleted permanently"); 
	}
	
	@After("execution(* com.moneymoney.account.service.SavingsAccountServiceImpl.withdraw(..))")
	public void withdrawLog() {
		logger.info("You withdrawn ammount from your Account"); 
	}
	
	@After("execution(* com.moneymoney.account.service.SavingsAccountServiceImpl.deposit(..))")
	public void depositLog() {
		logger.info("Deposited amount successfully"); 
	}
}
