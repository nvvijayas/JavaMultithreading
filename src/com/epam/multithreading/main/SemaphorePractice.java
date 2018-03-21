package com.epam.multithreading.main;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import com.epam.multithreading.Connection;

public class SemaphorePractice {

	public static void main(String[] args) throws InterruptedException {

		ExecutorService executor = Executors.newCachedThreadPool();

		for (int i = 0; i < 200; i++) {
			executor.submit(new Runnable() {

				@Override
				public void run() {
					Connection.getInstance().connect();
				}
			});
		}
		executor.shutdown();
		executor.awaitTermination(1, TimeUnit.DAYS);

	}
}
