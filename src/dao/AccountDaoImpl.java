package dao;

import java.io.BufferedReader;
import java.io.FileReader;
import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import model.Account;

public class AccountDaoImpl implements AccountDao{
	
	private Resource csvResource;

	@Override
	public List<Account> finaAllAccounts() throws Exception {
		
		List<Account> accounts = new ArrayList<>();
		DateFormat df = new SimpleDateFormat("MMddyyy");	
		BufferedReader br = new BufferedReader(new FileReader(csvResource.getFile()));
		String line = null;
		while((line=br.readLine())!= null) {
			String[] fields = line.split(",");
			String accountNo=fields[0];
			BigDecimal balance = new BigDecimal(fields[1]);
			Date lastPaidOn = df.parse(fields[2]); 
			
			Account account = new Account(accountNo,balance,lastPaidOn);
			accounts.add(account);
		}
		 
		return accounts;
	}

	public Resource getCsvResource() {
		return csvResource;
	}

	public void setCsvResource(Resource csvResource) {
		this.csvResource = csvResource;
	}

}
