package com.epam.multithreading;

public class SynchronizedThread {
	static int count = 0;

	public static synchronized void increment(){
		count++;
		System.out.println(count);
	}
	
	public static void main(String[] args) {

		Thread thread1 = new Thread(new Runnable() {
			public void run() {
				for (int i = 0; i < 10000; i++) {
					increment();
				}
			}
		});

		Thread thread2 = new Thread(new Runnable() {
			public void run() {
				for (int i = 0; i < 10000; i++) {
					increment();
				}
			}
		});

		thread1.start();
		thread2.start();

		try {
			thread1.join();
			thread2.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(count);

	}

}
