package com.epam.multithreading.main;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ExecutorDemo {
	public static void main(String[] args) {
		ExecutorService service = Executors.newFixedThreadPool(2);
		for (int i = 0; i < 5; i++) {
			service.submit(new Process(i));
		}
		System.out.println("All tasks Submitted");
		service.shutdown();
		try {
			service.awaitTermination(1, TimeUnit.DAYS);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.println("All tasks completed");
	}

}

class Process implements Runnable {

	private int id;

	public Process(int id) {
		this.id = id;
	}

	@Override
	public void run() {
		System.out.println("From Thread:" + id);
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("End of Thread" + id);
	}

}
