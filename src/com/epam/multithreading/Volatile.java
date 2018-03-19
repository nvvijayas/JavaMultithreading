package com.epam.multithreading;

public class Volatile extends Thread {

	public boolean state = true;

	@Override
	public void run() {
		while (state) {
			System.out.println("Testing Volatile");
		}
	}

	public void shutdown() {
		state = false;
	}

}
