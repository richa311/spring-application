package model;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import service.AccountService;

public class MainClass {

	public static void main(String args[]) throws Exception {
		
		ApplicationContext ac= new ClassPathXmlApplicationContext("ApplicationContext.xml");
		AccountService accountService = (AccountService)ac.getBean("accountService");
		List<Account> delinquetAccounts = accountService.findDelinquetAccounts();
		
		for(Account account : delinquetAccounts) {
			System.out.println(account);
		}
	}
}
