package com.epam.multithreading.main;

import java.io.IOException;
import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class CallableFuture {

	public static void main(String[] args) {
		ExecutorService executor = Executors.newCachedThreadPool();
		Future<Integer> future = executor.submit(new Callable<Integer>() {
			public Integer call() throws IOException {
				Random random = new Random();
				System.out.println("Starting......");
				int duration = random.nextInt(4000);
				if (duration > 3000) {
					throw new IOException("Waiting for too long");
				}
				try {
					Thread.sleep(duration);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println("Finished....");
				return duration;
			}
		});
		executor.shutdown();

			try {
				System.out.println(future.get());
			} catch (InterruptedException e) {
				e.printStackTrace();
			} catch (ExecutionException e) {
				IOException exception = (IOException) e.getCause();
				System.err.println(exception.getMessage());
			}
	}
}
