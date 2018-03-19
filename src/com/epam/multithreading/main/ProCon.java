package com.epam.multithreading.main;

import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class ProCon {
	private static BlockingQueue<Integer> queue = new ArrayBlockingQueue<Integer>(10);

	public static void main(String[] args) {
		Thread t1 = new Thread(new Runnable() {

			@Override
			public void run() {
				producer();
			}
		});
		Thread t2 = new Thread(new Runnable() {

			@Override
			public void run() {
				consumer();
			}
		});
		t1.start();
		t2.start();

		try {
			t1.join();
			t1.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public static void producer() {
		while (true) {
			Random random = new Random();
			try {
				Thread.sleep(1000);
				queue.put(random.nextInt(100));
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	public static void consumer() {
		while (true) {
			try {
				Thread.sleep(6000);
				int value = queue.take();
				System.out.println("value is :" + value + "size is :" + queue.size());
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
