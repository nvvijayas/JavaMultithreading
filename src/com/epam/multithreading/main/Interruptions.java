package com.epam.multithreading.main;

import java.util.Random;

public class Interruptions {

	public static void main(String[] args) {
		System.out.println("Started");
		Thread thread1 = new Thread(new Runnable() {
			Random random = new Random();

			@Override
			public void run() {
				for (int i = 0; i < 1E8; i++) {

					if (Thread.currentThread().isInterrupted()) {
						System.out.println("Interrupted");
						break;
					}

					/*try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						System.err.println("Interrupted");
						break;
					}*/
					Math.sin(random.nextDouble());
				}
			}
		});

		thread1.start();
		try {
			Thread.sleep(500);
			thread1.interrupt();
			thread1.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("finished");
	}

}
