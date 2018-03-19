package com.epam.multithreading.main;

public class ReentrantLocks {

	public static void main(String[] args) {
		Runner runner = new Runner();
		Thread thread1 = new Thread(new Runnable() {

			@Override
			public void run() {
				runner.firstThread();
			}
		});
		Thread thread2 = new Thread(new Runnable() {

			@Override
			public void run() {
				try {
					runner.secondThread();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		thread1.start();
		thread2.start();
		try {
			thread1.join();
			thread2.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		runner.finished();
	}
}
