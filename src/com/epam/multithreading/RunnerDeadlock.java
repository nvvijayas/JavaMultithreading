package com.epam.multithreading;

import java.util.Random;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class RunnerDeadlock {
	private AccountDeadlock account1 = new AccountDeadlock();
	private AccountDeadlock account2 = new AccountDeadlock();

	Lock lock1 = new ReentrantLock();
	Lock lock2 = new ReentrantLock();

	Random random = new Random();

	public void acquireLock(Lock lock1, Lock lock2) {
		while (true) {
			boolean firstLock = false;
			boolean secondLock = false;

			try {
				firstLock = lock1.tryLock();
				secondLock = lock2.tryLock();
			} finally {
				if (firstLock && secondLock) {
					return;
				}
				if (firstLock) {
					lock1.unlock();
				}
				if (secondLock) {
					lock2.unlock();
				}
			}
		}
	}

	public void firstThread() {
		for (int i = 0; i < 10000; i++) {
			acquireLock(lock1, lock2);
			try {
				AccountDeadlock.transfer(account1, account2, random.nextInt(100));
			} finally {
				lock1.unlock();
				lock2.unlock();
			}
		}
	}

	public void secondThread() {
		for (int i = 0; i < 10000; i++) {
			acquireLock(lock2, lock1);
			try {
				AccountDeadlock.transfer(account2, account1, random.nextInt(100));
			} finally {
				lock2.unlock();
				lock1.unlock();
			}
		}
	}

	public void finished() {
		System.out.println("Balance in account1 is " + account1.getBalance());
		System.out.println("Balance in account2 is " + account2.getBalance());
		System.out.println("Total Amount in two Accounts is " + (account1.getBalance() + account2.getBalance()));
	}
}
