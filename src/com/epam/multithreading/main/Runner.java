package com.epam.multithreading.main;

import java.util.Scanner;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Runner {
	private int value = 0;
	private Lock lock = new ReentrantLock();
	private Condition con = lock.newCondition();

	private void increment() {
		for (int i = 0; i < 10000; i++) {
			value++;
		}
	}

	public void firstThread() {
		lock.lock();
		try {
			con.await();
			System.out.println("Yeah! Its true, Lock released");
			increment();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			lock.unlock();
		}
	}

	public void secondThread() throws InterruptedException {
		Thread.sleep(1000);
		lock.lock();
		System.out.println("Press Enter Key");
		new Scanner(System.in).nextLine();
		con.signal();
		System.out.println("Lock released");
		try {
			increment();
		} finally {
			lock.unlock();
		}
	}

	public void finished() {
		System.out.println("Value is " + value);
	}
}
