package com.epam.multithreading;

import java.util.concurrent.Semaphore;

public class Connection {
	private static Connection connection = new Connection();
	private int connections = 0;
	private Semaphore sem = new Semaphore(10);

	private Connection() {

	}

	public static Connection getInstance() {
		return connection;
	}

	public void connect() {
		try {
			sem.acquire();
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		synchronized (this) {
			connections++;
			System.out.println("Total connections are:" + connections);
		}
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		synchronized (this) {
			connections--;
		}
		sem.release();
	}

}
