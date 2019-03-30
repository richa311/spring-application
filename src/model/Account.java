package model;

import java.math.BigDecimal;
import java.util.Date;

public class Account {

	private String accountNo;
	private BigDecimal balance; 
	private Date lastPaidOn;
	
	
	public Account(String accountNo, BigDecimal balance, Date lastPaidOn) {
		super();
		this.accountNo = accountNo;
		this.balance = balance;
		this.lastPaidOn = lastPaidOn;
	}
	
	
	public String getAccountNo() {
		return accountNo;
	}
	public void setAccountNo(String accountNo) {
		this.accountNo = accountNo;
	}
	public BigDecimal getBalance() {
		return balance;
	}
	public void setBalance(BigDecimal balance) {
		this.balance = balance;
	}
	public Date getLastPaidOn() {
		return lastPaidOn;
	}
	public void setLastPaidOn(Date lastPaidOn) {
		this.lastPaidOn = lastPaidOn;
	}
	
	
	
	
}
