package com.moneymoney.account.controller;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.moneymoney.account.SavingsAccount;
import com.moneymoney.account.service.SavingsAccountService;
import com.moneymoney.exception.AccountNotFoundException;

@Controller
public class AccountController {

	@Autowired
	private SavingsAccountService savingsAccountService;

	@RequestMapping("/")
	public String hello() {
		return "index";
	}

	@RequestMapping("/newSA")
	public String openSavingsAccount(Model model) {
		model.addAttribute("accounts", new SavingsAccount());
		return "openSavingsAccount";
	}

	@RequestMapping(value = "/createAccount", method = RequestMethod.POST)
	public String createAccount(@ModelAttribute("accounts") SavingsAccount accounts, BindingResult result)
			throws ClassNotFoundException, SQLException {
		if(result.hasErrors()) {
			return "openSavingsAccount";
		}
		savingsAccountService.createNewAccount(accounts.getBankAccount().getAccountHolderName(),
				accounts.getBankAccount().getAccountBalance(), accounts.isSalary());
		return "redirect: getAll";
	}

	@RequestMapping("/closeForm")
	public String closeAccountForm(Model model) {
		model.addAttribute("accounts", new SavingsAccount());
		return "closeAccount";
	}

	@RequestMapping(value = "/closeAccount", method = RequestMethod.POST)
	public String closeAccount(@ModelAttribute("accounts") SavingsAccount accounts)
			throws ClassNotFoundException, SQLException, AccountNotFoundException {
		savingsAccountService.delete(accounts.getBankAccount().getAccountNumber());
		return "redirect: getAll";
	}

	@RequestMapping("/getAll")
	public ModelAndView getAllAccounts(ModelAndView model) throws ClassNotFoundException, SQLException {
		List<SavingsAccount> accounts = savingsAccountService.getAllSavingsAccount();
		model.addObject("accounts", accounts);
		model.setViewName("AccountDetails");
		return model;
	}

	@RequestMapping("/searchForm")
	public String searchAccountForm(Model model) {
		model.addAttribute("accounts", new SavingsAccount());
		return "searchForm";
	}

	@RequestMapping(value = "/searchAccount", method = RequestMethod.POST)
	public ModelAndView searchAccount(ModelAndView model, @ModelAttribute("account") SavingsAccount account)
			throws ClassNotFoundException, SQLException, AccountNotFoundException {
		savingsAccountService.getAccountById(account.getBankAccount().getAccountNumber());
		model.addObject("account", account);
		model.setViewName("AccountDetails");
		return model;
	}

	@RequestMapping("/withdrawForm")
	public String withdrawForm() {
		return "withdrawForm";
	}

	@RequestMapping(value = "/withdrawAmmount", method = RequestMethod.POST)
	public String withdrawAmount(@RequestParam("accountNumber") int accountNumber,
			@RequestParam("accountBalance") double amount)
			throws ClassNotFoundException, SQLException, AccountNotFoundException {
		SavingsAccount savingsAccount = savingsAccountService.getAccountById(accountNumber);
		savingsAccountService.withdraw(savingsAccount, amount);
		return "redirect: getAll";
	}

	@RequestMapping("/depositForm")
	public String depositForm() {
		return "depositForm";
	}

	@RequestMapping(value = "/depositAmount", method = RequestMethod.POST)
	public String depositAmount(@RequestParam("accountNumber") int accountNumber,
			@RequestParam("accountBalance") double amount)
			throws ClassNotFoundException, SQLException, AccountNotFoundException {
		SavingsAccount savingsAccount = savingsAccountService.getAccountById(accountNumber);
		savingsAccountService.deposit(savingsAccount, amount);
		return "redirect: getAll";
	}

	@RequestMapping("fundstransferFrom")
	public String fundTransferForm() {
		return "fundTransfer";
	}

	@RequestMapping(value = "/fundTransfer", method = RequestMethod.POST)
	public String fundTransfer(@RequestParam("sender") int sender, @RequestParam("receiver") int receiver,
			@RequestParam("amount") double amount)
			throws ClassNotFoundException, SQLException, AccountNotFoundException {
		SavingsAccount senderAccount = savingsAccountService.getAccountById(sender);
		SavingsAccount receiverAccount = savingsAccountService.getAccountById(receiver);
		savingsAccountService.fundTransfer(senderAccount, receiverAccount, amount);
		return "redirect: getAll";
	}

	@RequestMapping("/updateAccount")
	public String updateAccountForm() {
		return "updateAccount";
	}

	@RequestMapping("/updateAccountForm")
	public String update(@RequestParam("accountNumber") int accountNumber, Model model)
			throws ClassNotFoundException, SQLException, AccountNotFoundException {
		SavingsAccount savingsAccount = savingsAccountService.getAccountById(accountNumber);
		model.addAttribute("account", savingsAccount);
		return "updateAccountForm";
	}

	@RequestMapping("/updateAccountDetails")
	public String updateAccount(@RequestParam("accountNumber") int accountNumber,
			@RequestParam("accountHolderName") String accountHolderName,
			@RequestParam("accountBalance") double accountBalance, @RequestParam("salary") boolean salary)
			throws ClassNotFoundException, SQLException, AccountNotFoundException {
		SavingsAccount savingsAccount = savingsAccountService.getAccountById(accountNumber);
		savingsAccount.getBankAccount().setAccountHolderName(accountHolderName);
		savingsAccount.setSalary(salary);
		savingsAccountService.updateAccount(savingsAccount);

		return "redirect: getAll";
	}
}
