package service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import dao.AccountDao;
import model.Account;

public class AccountService {

	private AccountDao accountDao; 
	
	public AccountService(AccountDao accountDao) {
		super();
		this.accountDao = accountDao;
	}
	
	public AccountDao getAccountDao() {
		return accountDao;
	}

	public void setAccountDao(AccountDao accountDao) {
		this.accountDao = accountDao;
	}
	
	public List<Account> findDelinquetAccounts() throws Exception{
	
		List<Account> delinquetAccounts = new ArrayList<>();
		List<Account> accounts = accountDao.finaAllAccounts();
		Date thirtyDayAgo = daysAgo(30);
		
		for(Account account : accounts) {
			Boolean owesMoney= false;
			Boolean thirtyDaysLate= false;
			if(account.getBalance().compareTo(BigDecimal.ZERO) > 0)
				owesMoney= true;
			if(account.getLastPaidOn().compareTo(thirtyDayAgo)>0)
				thirtyDaysLate= true;
			if(owesMoney && thirtyDaysLate)
				delinquetAccounts.add(account);
			
		}
	
	return delinquetAccounts;
	}

	private Date daysAgo(int date) {
		GregorianCalendar gc = new GregorianCalendar();
		gc.add(Calendar.DATE, -date);
		return gc.getTime();
	}
}
