package com.epam.multithreading;

import java.util.Scanner;

public class Threading1 extends Thread {
	private volatile boolean shutdownhook = true;
	public void run() {
		while (shutdownhook) {
			System.out.println("Hello");
			try {
				Thread.sleep(100);
			} catch (InterruptedException ie) {
				ie.printStackTrace();
			}
		}
	}
	
	public void shutdown() {
		shutdownhook = false;
	}

}
