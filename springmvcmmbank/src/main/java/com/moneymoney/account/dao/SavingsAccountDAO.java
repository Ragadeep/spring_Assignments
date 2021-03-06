package com.moneymoney.account.dao;

import java.sql.SQLException;
import java.util.List;

import com.moneymoney.account.SavingsAccount;
import com.moneymoney.exception.AccountNotFoundException;

public interface SavingsAccountDAO {

	SavingsAccount createNewAccount(SavingsAccount account)
			throws ClassNotFoundException, SQLException;

	boolean updateAccount(SavingsAccount account)
			throws ClassNotFoundException, SQLException;

	SavingsAccount getAccountById(int accountNumber)
			throws ClassNotFoundException, SQLException,
			AccountNotFoundException;

	List<SavingsAccount> getAllSavingsAccount() throws ClassNotFoundException,
			SQLException;

	void updateBalance(int accountNumber, double currentBalance) throws ClassNotFoundException, SQLException;

	void commit() throws SQLException;

	SavingsAccount delete(int accountNumber) throws SQLException,
			ClassNotFoundException, AccountNotFoundException; 

	double checkBalance(int accountNumber) throws ClassNotFoundException,
			SQLException, AccountNotFoundException;

	SavingsAccount searchAccount(int accountNumber);

	List<SavingsAccount> searchAccountByHolderName(String holderName);

	List<SavingsAccount> sortByAccountHolderName();

	List<SavingsAccount> sortByAccountHolderNameInDescendingOrder();

	List<SavingsAccount> sortByAccountBalance();

	List<SavingsAccount> sortByBalanceRange(int minimumBalance, int maximumBalance);

	List<SavingsAccount> sortByBalanceRangeInDescendingOrder(int minimumBalanceValue, int maximumBalanceValue);
}
