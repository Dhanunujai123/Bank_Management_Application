package com.BankApplication.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.BankApplication.Entity.Account;

public interface AccountRepository extends JpaRepository<Account,Long> {

	Account save(Account account);

}
