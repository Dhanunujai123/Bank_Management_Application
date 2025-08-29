package com.BankApplication.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.BankApplication.Entity.Account;
import com.BankApplication.Repository.AccountRepository;


@Service
public class AccountServiceImplimentaion implements AccountService {

	@Autowired
	AccountRepository repo;
	@Override
	public Account createAccount(Account account) {
		// TODO Auto-generated method stub
		
		Account account_saved =repo.save(account);
		return account_saved;
	}

	@Override
	public Account getAccountDteailsByAccountNumber(Long accountNumber) {
		// TODO Auto-generated method stub
		
		Optional<Account> account = repo.findById(accountNumber);
		if(account.isEmpty())
		{
			throw new RuntimeException("Account is not present");
		}
		
		Account account_found=account.get();
		
		return account_found;
	}

	@Override
	public List<Account> getAllAccountDetails() {
		// TODO Auto-generated method stub
		
		List<Account> listofALLaccounts = repo.findAll();
		return listofALLaccounts;
	}

	@Override
	public Account depositAmount(Long accountNumber, Double amount) {
		// TODO Auto-generated method stub
		Optional<Account> account = repo.findById(accountNumber);
		if(account.isEmpty())
		{
			throw new RuntimeException("Account is not present");
			
		}
		Account accountPresent=account.get();
		Double totalBalance = accountPresent.getAccount_balance() + amount;
		accountPresent.setAccount_balance(totalBalance);
		repo.save(accountPresent);
		
		return accountPresent ;
	}

	@Override
	public Account withdrawAmount(Long accountNumber, Double amount) {
		// TODO Auto-generated method stub
		Optional<Account> account = repo.findById(accountNumber);
		if(account.isEmpty())
		{
			throw new RuntimeException("Account is not present");
			
		}
		Account accountPresent=account.get();
		
		Double accountBalance = accountPresent.getAccount_balance()-amount;
		accountPresent.setAccount_balance(accountBalance);
		repo.save(accountPresent);
		return accountPresent;
	}

	@Override
	public void closeAccount(Long accountNumber) {
		// TODO Auto-generated method stub
		getAccountDteailsByAccountNumber(accountNumber);
		repo.deleteById(accountNumber);
	
		
	}

}
