package com.epam.multithreading.main;

import java.util.concurrent.CountDownLatch;
/*
 * CountDownLatch is used to make dependent threads to complete execution before the execution of the thread.
 * */

public class CountDownLatchDemo {
	public static void main(String[] args) {
		CountDownLatch latch = new CountDownLatch(2);

		Thread thread1 = new Thread(new Runnable() {

			@Override
			public void run() {
				try {
					System.out.println("Waiting for completion of first thread");
					Thread.sleep(3000);
					latch.countDown();
					System.out.println("completion of first thread");
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		});
		thread1.start();
		Thread thread2 = new Thread(new Runnable() {

			@Override
			public void run() {
				try {
					System.out.println("Waiting for completion of second task");
					Thread.sleep(1000);
					latch.countDown();
					System.out.println("completion of second task");
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		thread2.start();
		try {
			latch.await();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Execution finished");

	}
}
