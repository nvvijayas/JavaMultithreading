package com.epam.multithreading;

public class AccountDeadlock {
	private int balance = 10000;

	private void withdraw(int amount) {
		balance -= amount;
	}

	private void deposit(int amount) {
		balance += amount;
	}

	public int getBalance() {
		return balance;
	}

	public static void transfer(AccountDeadlock acc1, AccountDeadlock acc2, int amount) {
		acc1.withdraw(amount);
		acc2.deposit(amount);
	}

}
