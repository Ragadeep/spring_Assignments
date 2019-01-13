package com.moneymoney.account.validator;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.moneymoney.account.SavingsAccount;

@Component
public class SavingsAccountValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void validate(Object target, Errors errors) {
		SavingsAccount account = (SavingsAccount) target;
		if(!account.getBankAccount().getAccountHolderName().matches("[a-zA-Z\\s]*$")) {
			errors.rejectValue("bankAccount.accountHolderName", "accountHolderName.length","Employee name should contains ony characters");
		}
		if(account.getBankAccount().getAccountBalance()>0) {
			errors.rejectValue("accountBalance","accountBalance.minimum","Salary must be higher than 0");
		}
	}

}
