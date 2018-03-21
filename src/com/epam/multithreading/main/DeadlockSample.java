package com.epam.multithreading.main;

import com.epam.multithreading.RunnerDeadlock;

public class DeadlockSample {
	public static void main(String[] args) {
		RunnerDeadlock runner = new RunnerDeadlock();
		Thread thread1 = new Thread(new Runnable() {

			@Override
			public void run() {
				for (int i = 0; i < 10000; i++) {
					runner.firstThread();
				}
			}
		});
		Thread thread2 = new Thread(new Runnable() {

			@Override
			public void run() {
				for (int i = 0; i < 10000; i++) {
					runner.firstThread();
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
