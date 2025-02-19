package entities;

import exceptions.BussinesExceptions;

public class Account {

	private Integer number;
	private String holder;
	private Double balance;
	private Double withdrawLimit;
	
	public Account() {
	}

	public Account(Integer number, String holder, Double balance, Double withdrawLimit) {
		super();
		this.number = number;
		this.holder = holder;
		this.balance = balance;
		this.withdrawLimit = withdrawLimit;
	}

	public Integer getNumber() {
		return number;
	}

	public void setNumber(Integer number) {
		this.number = number;
	}

	public String getHolder() {
		return holder;
	}

	public void setHolder(String holder) {
		this.holder = holder;
	}

	public Double getBalance() {
		return balance;
	}

	public void setBalance(Double balance) {
		this.balance = balance;
	}

	public Double getWithdrawLimit() {
		return withdrawLimit;
	}

	public void setWithdrawLimit(Double withdrawLimit) {
		this.withdrawLimit = withdrawLimit;
	}
	
    public void deposit(double amount) {
    	balance += amount;
    }
    
    public void withdraw(double amount) {
		validateWithdraw(amount);
		balance -= amount;
	}
    
    public void validateWithdraw(double amount) {
        
        if(amount > getWithdrawLimit()) {
            throw new BussinesExceptions("Withdraw error: The amount exceeds withdraw limit");
        }
        if(amount > getBalance()) {
            throw new BussinesExceptions("Withdraw error: Not enough balance");
        }
    }
}