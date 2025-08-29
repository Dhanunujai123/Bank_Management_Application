package com.BankApplication.Service;

import java.util.List;

import com.BankApplication.Entity.Account;

public interface AccountService {

	public Account createAccount(Account account);
	public Account getAccountDteailsByAccountNumber(Long accountNumber);
    public List<Account> getAllAccountDetails();
    public Account depositAmount(Long accountNumber,Double money);
    public Account withdrawAmount(Long accountNumber, Double amount);
    public void closeAccount(Long accountNumber);
	//public Account depositAmount(Long accountNumber, Double amount);
    
    
}
