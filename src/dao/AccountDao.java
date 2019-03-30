package dao;

import java.util.List;

import model.Account;

public interface AccountDao {

	List<Account> finaAllAccounts() throws Exception;
}
